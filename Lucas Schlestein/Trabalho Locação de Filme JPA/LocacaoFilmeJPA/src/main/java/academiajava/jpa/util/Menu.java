package academiajava.jpa.util;

import academiajava.jpa.dao.*;
import academiajava.jpa.model.*;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AtorDAO atorDAO = new AtorDAO();
    private static final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final DependenteDAO dependenteDAO = new DependenteDAO();
    private static final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private static final FilmeDAO filmeDAO = new FilmeDAO();
    private static final GeneroDAO generoDAO = new GeneroDAO();
    private static final LocacaoDAO locacaoDAO = new LocacaoDAO();
    private static final ProfissaoDAO profissaoDAO = new ProfissaoDAO();

    public void show() {
        System.out.println("\n————— BEM VINDO AO PROGRAMA —————");
        while (true) {
            showMainMenu();
            int option = getOptionInput();
            switch (option) {
                case 1 -> configureEntity("Ator");
                case 2 -> configureEntity("Categoria");
                case 3 -> configureEntity("Cliente");
                case 4 -> configureEntity("Dependente");
                case 5 -> configureEntity("Endereco");
                case 6 -> configureEntity("Filme");
                case 7 -> configureEntity("Genero");
                case 8 -> configureEntity("Locacao");
                case 9 -> configureEntity("Profissao");
                case 10 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n———————— MENU ————————");
        System.out.println("\nOpções Disponíveis para Configuração");
        System.out.println("1- Ator");
        System.out.println("2- Categoria");
        System.out.println("3- Cliente");
        System.out.println("4- Dependente");
        System.out.println("5- Endereco");
        System.out.println("6- Filme");
        System.out.println("7- Genero");
        System.out.println("8- Locacao");
        System.out.println("9- Profissao");
        System.out.println("10- Sair do Programa");
        System.out.print("\nDigite o número do item que deseja configurar: ");
    }

    private int getCrudOption(String entity) {
        System.out.printf("\n————— CONFIGURAÇÃO ————— [%s]%n", entity);
        System.out.println("1- Inserir");
        System.out.println("2- Atualizar");
        System.out.println("3- Buscar por ID");
        System.out.println("4- Listar");
        System.out.println("5- Deletar");
        System.out.println("6- Voltar ao Menu");
        System.out.println("7- Sair do Programa");
        System.out.print("\nDigite o número do item que deseja configurar: ");
        return getOptionInput();
    }

    private int getOptionInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, por favor, digite um número.");
            return -1;
        }
    }

    private void configureEntity(String entity) {
        while (true) {
            int option = getCrudOption(entity);
            try {
                switch (option) {
                    case 1 -> insertEntity(entity);
                    case 2 -> updateEntity(entity);
                    case 3 -> findEntityById(entity);
                    case 4 -> listEntities(entity);
                    case 5 -> deleteEntityById(entity);
                    case 6 -> {
                        return;
                    }
                    case 7 -> {
                        System.out.println("Saindo...");
                        System.exit(0);
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao executar a operação: " + e.getMessage());
            }
        }
    }

    private void insertEntity(String entity) {
        try {
            switch (entity) {
                case "Ator" -> {
                    System.out.print("Nome do Ator: ");
                    String nome = scanner.nextLine();
                    System.out.print("É Ator (true/false): ");
                    Boolean eAtor = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("É Diretor (true/false): ");
                    Boolean eDiretor = Boolean.parseBoolean(scanner.nextLine());
                    Ator ator = Ator.builder().nome(nome).eAtor(eAtor).eDiretor(eDiretor).build();
                    atorDAO.persist(ator);
                    System.out.println("Ator salvo com sucesso!");
                }
                case "Categoria" -> {
                    System.out.print("Nome da Categoria: ");
                    String nome = scanner.nextLine();
                    System.out.print("Valor da Categoria: ");
                    Double valor = Double.parseDouble(scanner.nextLine());
                    Categoria categoria = Categoria.builder().nome(nome).valor(valor).build();
                    categoriaDAO.persist(categoria);
                    System.out.println("Categoria salva com sucesso!");
                }
                case "Cliente" -> {
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Cliente: ");
                    Long cpf = Long.parseLong(scanner.nextLine());
                    System.out.print("Telefone do Cliente: ");
                    Long telefone = Long.parseLong(scanner.nextLine());
                    System.out.print("ID da Profissão: ");
                    Integer profissaoId = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID do Endereço: ");
                    Integer enderecoId = Integer.parseInt(scanner.nextLine());

                    Profissao profissao = profissaoDAO.findById(profissaoId);
                    Endereco endereco = enderecoDAO.findById(enderecoId);

                    if (profissao != null && endereco != null) {
                        Cliente cliente = Cliente.builder()
                                .nome(nome)
                                .cpf(cpf)
                                .telefone(telefone)
                                .profissao(profissao)
                                .endereco(endereco)
                                .build();
                        clienteDAO.persist(cliente);
                        System.out.println("Cliente salvo com sucesso!");
                    } else {
                        System.out.println("Profissão ou Endereço não encontrado!");
                    }
                }
                case "Dependente" -> {
                    System.out.print("ID do Cliente: ");
                    Integer clienteId = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID do Dependente: ");
                    Integer dependenteId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Parentesco: ");
                    String parentesco = scanner.nextLine();

                    Cliente cliente = clienteDAO.findById(clienteId);
                    Cliente dependente = clienteDAO.findById(dependenteId);

                    if (cliente != null && dependente != null) {
                        Dependente dep = Dependente.builder()
                                .cliente(cliente)
                                .dependente(dependente)
                                .parentesco(parentesco)
                                .build();
                        dependenteDAO.persist(dep);
                        System.out.println("Dependente salvo com sucesso!");
                    } else {
                        System.out.println("Cliente ou Dependente não encontrado!");
                    }
                }
                case "Endereco" -> {
                    System.out.print("Logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Tipo de Logradouro: ");
                    String tipoLogradouro = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("UF: ");
                    String uf = scanner.nextLine();
                    System.out.print("CEP: ");
                    Integer cep = Integer.parseInt(scanner.nextLine());
                    System.out.print("Número: ");
                    Integer numero = Integer.parseInt(scanner.nextLine());
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();

                    Endereco endereco = Endereco.builder()
                            .logradouro(logradouro)
                            .tipoLogradouro(tipoLogradouro)
                            .complemento(complemento)
                            .cidade(cidade)
                            .uf(uf)
                            .cep(cep)
                            .numero(numero)
                            .bairro(bairro)
                            .build();
                    enderecoDAO.persist(endereco);
                    System.out.println("Endereco salvo com sucesso!");
                }
                case "Filme" -> {
                    System.out.print("Título Original do Filme: ");
                    String tituloOriginal = scanner.nextLine();
                    System.out.print("Título do Filme: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    Integer quantidade = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID da Categoria: ");
                    Integer categoriaId = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID do Genero: ");
                    Integer generoId = Integer.parseInt(scanner.nextLine());

                    Categoria categoria = categoriaDAO.findById(categoriaId);
                    Genero genero = generoDAO.findById(generoId);

                    if (categoria != null && genero != null) {
                        Filme filme = Filme.builder()
                                .tituloOriginal(tituloOriginal)
                                .titulo(titulo)
                                .quantidade(quantidade)
                                .categoria(categoria)
                                .genero(genero)
                                .build();
                        filmeDAO.persist(filme);
                        System.out.println("Filme salvo com sucesso!");
                    } else {
                        System.out.println("Categoria ou Genero não encontrado!");
                    }
                }
                case "Genero" -> {
                    System.out.print("Nome do Genero: ");
                    String nome = scanner.nextLine();
                    Genero genero = Genero.builder().nome(nome).build();
                    generoDAO.persist(genero);
                    System.out.println("Genero salvo com sucesso!");
                }
                case "Locacao" -> {
                    System.out.print("Data da Locação (YYYY-MM-DD): ");
                    String dataLocacaoStr = scanner.nextLine();
                    System.out.print("Data de Devolução (YYYY-MM-DD): ");
                    String dataDevolucaoStr = scanner.nextLine();
                    System.out.print("Número de Dias: ");
                    Integer numeroDias = Integer.parseInt(scanner.nextLine());
                    System.out.print("Valor: ");
                    Double valor = Double.parseDouble(scanner.nextLine());
                    System.out.print("Desconto: ");
                    Double desconto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Multa: ");
                    Double multa = Double.parseDouble(scanner.nextLine());
                    System.out.print("SubTotal: ");
                    Double subTotal = Double.parseDouble(scanner.nextLine());
                    System.out.print("ID do Cliente: ");
                    Integer clienteId = Integer.parseInt(scanner.nextLine());

                    Cliente cliente = clienteDAO.findById(clienteId);

                    if (cliente != null) {
                        Locacao locacao = Locacao.builder()
                                .dataLocacao(java.sql.Date.valueOf(dataLocacaoStr))
                                .dataDevolucao(java.sql.Date.valueOf(dataDevolucaoStr))
                                .numeroDias(numeroDias)
                                .valor(valor)
                                .desconto(desconto)
                                .multa(multa)
                                .subTotal(subTotal)
                                .cliente(cliente)
                                .build();
                        locacaoDAO.persist(locacao);
                        System.out.println("Locacao salva com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case "Profissao" -> {
                    System.out.print("Nome da Profissão: ");
                    String nome = scanner.nextLine();
                    Profissao profissao = Profissao.builder().nome(nome).build();
                    profissaoDAO.persist(profissao);
                    System.out.println("Profissão salva com sucesso!");
                }
                default -> System.out.println("Entidade não suportada para inserção.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir " + entity + ": " + e.getMessage());
        }
    }

    private void updateEntity(String entity) {
        try {
            System.out.print("Digite o ID do " + entity + ": ");
            Integer id = Integer.parseInt(scanner.nextLine());

            switch (entity) {
                case "Ator" -> {
                    Ator ator = atorDAO.findById(id);
                    if (ator != null) {
                        System.out.print("Novo nome do Ator: ");
                        ator.setNome(scanner.nextLine());
                        System.out.print("É Ator (true/false): ");
                        ator.setEAtor(Boolean.parseBoolean(scanner.nextLine()));
                        System.out.print("É Diretor (true/false): ");
                        ator.setEDiretor(Boolean.parseBoolean(scanner.nextLine()));
                        atorDAO.update(ator);
                        System.out.println("Ator atualizado com sucesso!");
                    } else {
                        System.out.println("Ator não encontrado!");
                    }
                }
                case "Categoria" -> {
                    Categoria categoria = categoriaDAO.findById(id);
                    if (categoria != null) {
                        System.out.print("Novo nome da Categoria: ");
                        categoria.setNome(scanner.nextLine());
                        System.out.print("Novo valor da Categoria: ");
                        categoria.setValor(Double.parseDouble(scanner.nextLine()));
                        categoriaDAO.update(categoria);
                        System.out.println("Categoria atualizada com sucesso!");
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                }
                case "Cliente" -> {
                    Cliente cliente = clienteDAO.findById(id);
                    if (cliente != null) {
                        System.out.print("Novo nome do Cliente: ");
                        cliente.setNome(scanner.nextLine());
                        System.out.print("Novo CPF do Cliente: ");
                        cliente.setCpf(Long.parseLong(scanner.nextLine()));
                        System.out.print("Novo telefone do Cliente: ");
                        cliente.setTelefone(Long.parseLong(scanner.nextLine()));
                        System.out.print("ID da Nova Profissão: ");
                        Integer profissaoId = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID do Novo Endereço: ");
                        Integer enderecoId = Integer.parseInt(scanner.nextLine());

                        Profissao profissao = profissaoDAO.findById(profissaoId);
                        Endereco endereco = enderecoDAO.findById(enderecoId);

                        if (profissao != null && endereco != null) {
                            cliente.setProfissao(profissao);
                            cliente.setEndereco(endereco);
                            clienteDAO.update(cliente);
                            System.out.println("Cliente atualizado com sucesso!");
                        } else {
                            System.out.println("Profissão ou Endereço não encontrado!");
                        }
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case "Dependente" -> {
                    System.out.print("ID do Cliente: ");
                    Integer clienteId = Integer.parseInt(scanner.nextLine());
                    Dependente dependente = dependenteDAO.findById(clienteId);
                    if (dependente != null) {
                        System.out.print("Novo parentesco: ");
                        dependente.setParentesco(scanner.nextLine());
                        dependenteDAO.update(dependente);
                        System.out.println("Dependente atualizado com sucesso!");
                    } else {
                        System.out.println("Dependente não encontrado!");
                    }
                }
                case "Endereco" -> {
                    Endereco endereco = enderecoDAO.findById(id);
                    if (endereco != null) {
                        System.out.print("Novo logradouro: ");
                        endereco.setLogradouro(scanner.nextLine());
                        System.out.print("Novo tipo de logradouro: ");
                        endereco.setTipoLogradouro(scanner.nextLine());
                        System.out.print("Novo complemento: ");
                        endereco.setComplemento(scanner.nextLine());
                        System.out.print("Nova cidade: ");
                        endereco.setCidade(scanner.nextLine());
                        System.out.print("Nova UF: ");
                        endereco.setUf(scanner.nextLine());
                        System.out.print("Novo CEP: ");
                        endereco.setCep(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Novo número: ");
                        endereco.setNumero(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Novo bairro: ");
                        endereco.setBairro(scanner.nextLine());
                        enderecoDAO.update(endereco);
                        System.out.println("Endereco atualizado com sucesso!");
                    } else {
                        System.out.println("Endereco não encontrado!");
                    }
                }
                case "Filme" -> {
                    Filme filme = filmeDAO.findById(id);
                    if (filme != null) {
                        System.out.print("Novo título original do Filme: ");
                        filme.setTituloOriginal(scanner.nextLine());
                        System.out.print("Novo título do Filme: ");
                        filme.setTitulo(scanner.nextLine());
                        System.out.print("Nova quantidade: ");
                        filme.setQuantidade(Integer.parseInt(scanner.nextLine()));
                        System.out.print("ID da Nova Categoria: ");
                        Integer categoriaId = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID do Novo Genero: ");
                        Integer generoId = Integer.parseInt(scanner.nextLine());

                        Categoria categoria = categoriaDAO.findById(categoriaId);
                        Genero genero = generoDAO.findById(generoId);

                        if (categoria != null && genero != null) {
                            filme.setCategoria(categoria);
                            filme.setGenero(genero);
                            filmeDAO.update(filme);
                            System.out.println("Filme atualizado com sucesso!");
                        } else {
                            System.out.println("Categoria ou Genero não encontrado!");
                        }
                    } else {
                        System.out.println("Filme não encontrado!");
                    }
                }
                case "Genero" -> {
                    Genero genero = generoDAO.findById(id);
                    if (genero != null) {
                        System.out.print("Novo nome do Genero: ");
                        genero.setNome(scanner.nextLine());
                        generoDAO.update(genero);
                        System.out.println("Genero atualizado com sucesso!");
                    } else {
                        System.out.println("Genero não encontrado!");
                    }
                }
                case "Locacao" -> {
                    Locacao locacao = locacaoDAO.findById(id);
                    if (locacao != null) {
                        System.out.print("Nova data da Locação (YYYY-MM-DD): ");
                        locacao.setDataLocacao(java.sql.Date.valueOf(scanner.nextLine()));
                        System.out.print("Nova data de Devolução (YYYY-MM-DD): ");
                        locacao.setDataDevolucao(java.sql.Date.valueOf(scanner.nextLine()));
                        System.out.print("Novo número de dias: ");
                        locacao.setNumeroDias(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Novo valor: ");
                        locacao.setValor(Double.parseDouble(scanner.nextLine()));
                        System.out.print("Novo desconto: ");
                        locacao.setDesconto(Double.parseDouble(scanner.nextLine()));
                        System.out.print("Nova multa: ");
                        locacao.setMulta(Double.parseDouble(scanner.nextLine()));
                        System.out.print("Novo subTotal: ");
                        locacao.setSubTotal(Double.parseDouble(scanner.nextLine()));
                        locacaoDAO.update(locacao);
                        System.out.println("Locacao atualizada com sucesso!");
                    } else {
                        System.out.println("Locacao não encontrada!");
                    }
                }
                case "Profissao" -> {
                    Profissao profissao = profissaoDAO.findById(id);
                    if (profissao != null) {
                        System.out.print("Novo nome da Profissão: ");
                        profissao.setNome(scanner.nextLine());
                        profissaoDAO.update(profissao);
                        System.out.println("Profissão atualizada com sucesso!");
                    } else {
                        System.out.println("Profissão não encontrada!");
                    }
                }
                default -> System.out.println("Entidade não suportada para atualização.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar " + entity + ": " + e.getMessage());
        }
    }

    private void findEntityById(String entity) {
        try {
            System.out.print("Digite o ID do " + entity + ": ");
            Integer id = Integer.parseInt(scanner.nextLine());

            switch (entity) {
                case "Ator" -> {
                    Ator ator = atorDAO.findById(id);
                    System.out.println(ator != null ? ator : "Ator não encontrado!");
                }
                case "Categoria" -> {
                    Categoria categoria = categoriaDAO.findById(id);
                    System.out.println(categoria != null ? categoria : "Categoria não encontrada!");
                }
                case "Cliente" -> {
                    Cliente cliente = clienteDAO.findById(id);
                    System.out.println(cliente != null ? cliente : "Cliente não encontrado!");
                }
                case "Dependente" -> {
                    Dependente dependente = dependenteDAO.findById(id);
                    System.out.println(dependente != null ? dependente : "Dependente não encontrado!");
                }
                case "Endereco" -> {
                    Endereco endereco = enderecoDAO.findById(id);
                    System.out.println(endereco != null ? endereco : "Endereco não encontrado!");
                }
                case "Filme" -> {
                    Filme filme = filmeDAO.findById(id);
                    System.out.println(filme != null ? filme : "Filme não encontrado!");
                }
                case "Genero" -> {
                    Genero genero = generoDAO.findById(id);
                    System.out.println(genero != null ? genero : "Genero não encontrado!");
                }
                case "Locacao" -> {
                    Locacao locacao = locacaoDAO.findById(id);
                    System.out.println(locacao != null ? locacao : "Locacao não encontrada!");
                }
                case "Profissao" -> {
                    Profissao profissao = profissaoDAO.findById(id);
                    System.out.println(profissao != null ? profissao : "Profissão não encontrada!");
                }
                default -> System.out.println("Entidade não suportada para busca.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar " + entity + ": " + e.getMessage());
        }
    }

    private void listEntities(String entity) {
        try {
            switch (entity) {
                case "Ator" -> {
                    List<Ator> atores = atorDAO.findAll();
                    atores.forEach(System.out::println);
                }
                case "Categoria" -> {
                    List<Categoria> categorias = categoriaDAO.findAll();
                    categorias.forEach(System.out::println);
                }
                case "Cliente" -> {
                    List<Cliente> clientes = clienteDAO.findAll();
                    clientes.forEach(System.out::println);
                }
                case "Dependente" -> {
                    List<Dependente> dependentes = dependenteDAO.findAll();
                    dependentes.forEach(System.out::println);
                }
                case "Endereco" -> {
                    List<Endereco> enderecos = enderecoDAO.findAll();
                    enderecos.forEach(System.out::println);
                }
                case "Filme" -> {
                    List<Filme> filmes = filmeDAO.findAll();
                    filmes.forEach(System.out::println);
                }
                case "Genero" -> {
                    List<Genero> generos = generoDAO.findAll();
                    generos.forEach(System.out::println);
                }
                case "Locacao" -> {
                    List<Locacao> locacoes = locacaoDAO.findAll();
                    locacoes.forEach(System.out::println);
                }
                case "Profissao" -> {
                    List<Profissao> profissoes = profissaoDAO.findAll();
                    profissoes.forEach(System.out::println);
                }
                default -> System.out.println("Entidade não suportada para listagem.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar entidades: " + e.getMessage());
        }
    }

    private void deleteEntityById(String entity) {
        try {
            System.out.print("Digite o ID do " + entity + " a ser deletado: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            switch (entity) {
                case "Ator" -> {
                    Ator ator = atorDAO.findById(id);
                    if (ator != null) {
                        atorDAO.delete(ator);
                        System.out.println("Ator deletado com sucesso!");
                    } else {
                        System.out.println("Ator não encontrado!");
                    }
                }
                case "Categoria" -> {
                    Categoria categoria = categoriaDAO.findById(id);
                    if (categoria != null) {
                        categoriaDAO.delete(categoria);
                        System.out.println("Categoria deletada com sucesso!");
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                }
                case "Cliente" -> {
                    Cliente cliente = clienteDAO.findById(id);
                    if (cliente != null) {
                        clienteDAO.delete(cliente);
                        System.out.println("Cliente deletado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case "Dependente" -> {
                    Dependente dependente = dependenteDAO.findById(id);
                    if (dependente != null) {
                        dependenteDAO.delete(dependente);
                        System.out.println("Dependente deletado com sucesso!");
                    } else {
                        System.out.println("Dependente não encontrado!");
                    }
                }
                case "Endereco" -> {
                    Endereco endereco = enderecoDAO.findById(id);
                    if (endereco != null) {
                        enderecoDAO.delete(endereco);
                        System.out.println("Endereco deletado com sucesso!");
                    } else {
                        System.out.println("Endereco não encontrado!");
                    }
                }
                case "Filme" -> {
                    Filme filme = filmeDAO.findById(id);
                    if (filme != null) {
                        filmeDAO.delete(filme);
                        System.out.println("Filme deletado com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado!");
                    }
                }
                case "Genero" -> {
                    Genero genero = generoDAO.findById(id);
                    if (genero != null) {
                        generoDAO.delete(genero);
                        System.out.println("Genero deletado com sucesso!");
                    } else {
                        System.out.println("Genero não encontrado!");
                    }
                }
                case "Locacao" -> {
                    Locacao locacao = locacaoDAO.findById(id);
                    if (locacao != null) {
                        locacaoDAO.delete(locacao);
                        System.out.println("Locacao deletada com sucesso!");
                    } else {
                        System.out.println("Locacao não encontrada!");
                    }
                }
                case "Profissao" -> {
                    Profissao profissao = profissaoDAO.findById(id);
                    if (profissao != null) {
                        profissaoDAO.delete(profissao);
                        System.out.println("Profissão deletada com sucesso!");
                    } else {
                        System.out.println("Profissão não encontrada!");
                    }
                }
                default -> System.out.println("Entidade não suportada para deleção.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar " + entity + ": " + e.getMessage());
        }
    }
}
