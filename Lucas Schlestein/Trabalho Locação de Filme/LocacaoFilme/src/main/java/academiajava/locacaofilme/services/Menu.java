package academiajava.locacaofilme.services;

import academiajava.locacaofilme.models.*;
import academiajava.locacaofilme.daos.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        while (true) {
            try {
                System.out.println("\nBEM VINDO AO SERVIÇO DE LOCALIZAÇÃO DE FILMES");
                System.out.println("\n————SERVIÇOS DISPONÍVEIS PARA CONFIGURAÇÃO————");
                System.out.println("1- Cliente");
                System.out.println("2- Dependente");
                System.out.println("3- Endereço");
                System.out.println("4- Profissão");
                System.out.println("5- Filme");
                System.out.println("6- Categoria");
                System.out.println("7- Genero");
                System.out.println("8- Ator");
                System.out.println("9- Filme Ator");
                System.out.println("10- Locação");
                System.out.println("11- Locação Filme");
                System.out.print("Digite o número do item que deseja configurar: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> configureEntity(DAOLoader.createClienteDAO(), "Cliente");
                    case 2 -> configureEntity(DAOLoader.createDependenteDAO(), "Dependente");
                    case 3 -> configureEntity(DAOLoader.createEnderecoDAO(), "Endereço");
                    case 4 -> configureEntity(DAOLoader.createProfissaoDAO(), "Profissão");
                    case 5 -> configureEntity(DAOLoader.createFilmeDAO(), "Filme");
                    case 6 -> configureEntity(DAOLoader.createCategoriaDAO(), "Categoria");
                    case 7 -> configureEntity(DAOLoader.createGeneroDAO(), "Genero");
                    case 8 -> configureEntity(DAOLoader.createAtorDAO(), "Ator");
                    case 9 -> configureEntity(DAOLoader.createFilmeAtorDAO(), "FilmeAtor");
                    case 10 -> configureEntity(DAOLoader.createLocacaoDAO(), "Locação");
                    case 11 -> configureEntity(DAOLoader.createLocacaoFilmeDAO(), "Locação e Filme");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private int getCrudOption() {
        System.out.println("\n————CONFIGURAÇÃO————");
        System.out.println("1- Inserir");
        System.out.println("2- Atualizar");
        System.out.println("3- Buscar por ID");
        System.out.println("4- Listar");
        System.out.println("5- Deletar");
        System.out.print("Digite o número do item que deseja configurar: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void configureEntity(Object dao, String entityName) {
        int option = getCrudOption();

        try {
            switch (option) {
                case 1 -> insertEntity(dao, entityName);
                case 2 -> updateEntity(dao, entityName);
                case 3 -> findEntityById(dao, entityName);
                case 4 -> listEntities(dao);
                case 5 -> deleteEntityById(dao, entityName);
                default -> System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a operação: " + e.getMessage());
        }
    }

    private void insertEntity(Object dao, String entityName) {
        try {
            switch (entityName) {
                case "Cliente" -> {
                    ClienteDAO clienteDAO = (ClienteDAO) dao;
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite a profissão (ID): ");
                    int profissaoId = scanner.nextInt();
                    scanner.nextLine();
                    Profissao profissao = DAOLoader.createProfissaoDAO().findById(profissaoId);
                    Cliente cliente = new Cliente(cpf, nome, telefone, profissao);
                    clienteDAO.insert(cliente);
                    System.out.println("Cliente inserido com sucesso!");
                }
                case "Dependente" -> {
                    DependenteDAO dependenteDAO = (DependenteDAO) dao;
                    System.out.print("Digite o ID do cliente: ");
                    int clienteId = scanner.nextInt();
                    System.out.print("Digite o ID do dependente: ");
                    int dependenteId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o parentesco: ");
                    String parentesco = scanner.nextLine();
                    Cliente cliente = DAOLoader.createClienteDAO().findById(clienteId);
                    Cliente dependenteCliente = DAOLoader.createClienteDAO().findById(dependenteId);
                    Dependente dependente = new Dependente(cliente, dependenteCliente, parentesco);
                    dependenteDAO.insert(dependente);
                    System.out.println("Dependente inserido com sucesso!");
                }
                case "Endereço" -> {
                    EnderecoDAO enderecoDAO = (EnderecoDAO) dao;
                    System.out.print("Digite o logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Digite o tipo de logradouro: ");
                    String tipoLogradouro = scanner.nextLine();
                    System.out.print("Digite o complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Digite a cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Digite a UF: ");
                    String uf = scanner.nextLine();
                    System.out.print("Digite o CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Digite o número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Digite o bairro: ");
                    String bairro = scanner.nextLine();
                    Endereco endereco = new Endereco(logradouro, tipoLogradouro, complemento, cidade, uf, cep, numero, bairro);
                    enderecoDAO.insert(endereco);
                    System.out.println("Endereço inserido com sucesso!");
                }
                case "Profissão" -> {
                    ProfissaoDAO profissaoDAO = (ProfissaoDAO) dao;
                    System.out.print("Digite o nome da profissão: ");
                    String nome = scanner.nextLine();
                    Profissao profissao = new Profissao(nome);
                    profissaoDAO.insert(profissao);
                    System.out.println("Profissão inserida com sucesso!");
                }
                case "Filme" -> {
                    FilmeDAO filmeDAO = (FilmeDAO) dao;
                    System.out.print("Digite o título original: ");
                    String tituloOriginal = scanner.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite a categoria (ID): ");
                    int categoriaId = scanner.nextInt();
                    System.out.print("Digite o gênero (ID): ");
                    int generoId = scanner.nextInt();
                    scanner.nextLine();
                    Categoria categoria = DAOLoader.createCategoriaDAO().findById(categoriaId);
                    Genero genero = DAOLoader.createGeneroDAO().findById(generoId);
                    Filme filme = new Filme(tituloOriginal, titulo, quantidade, categoria, genero);
                    filmeDAO.insert(filme);
                    System.out.println("Filme inserido com sucesso!");
                }
                case "Categoria" -> {
                    CategoriaDAO categoriaDAO = (CategoriaDAO) dao;
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o valor: ");
                    BigDecimal valor = scanner.nextBigDecimal();
                    scanner.nextLine();
                    Categoria categoria = new Categoria(nome, valor);
                    categoriaDAO.insert(categoria);
                    System.out.println("Categoria inserida com sucesso!");
                }
                case "Genero" -> {
                    GeneroDAO generoDAO = (GeneroDAO) dao;
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    Genero genero = new Genero(nome);
                    generoDAO.insert(genero);
                    System.out.println("Genero inserido com sucesso!");
                }
                case "Ator" -> {
                    AtorDAO atorDAO = (AtorDAO) dao;
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    Ator ator = new Ator(nome);
                    atorDAO.insert(ator);
                    System.out.println("Ator inserido com sucesso!");
                }
                case "FilmeAtor" -> {
                    FilmeAtorDAO filmeAtorDAO = (FilmeAtorDAO) dao;
                    System.out.print("Digite o ID do ator: ");
                    int atorId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    System.out.print("É ator (true/false): ");
                    boolean isAtor = scanner.nextBoolean();
                    System.out.print("É diretor (true/false): ");
                    boolean isDiretor = scanner.nextBoolean();
                    scanner.nextLine();
                    Ator ator = DAOLoader.createAtorDAO().findById(atorId);
                    Filme filme = DAOLoader.createFilmeDAO().findById(filmeId);
                    FilmeAtor filmeAtor = new FilmeAtor(ator, filme, isAtor, isDiretor);
                    filmeAtorDAO.insert(filmeAtor);
                    System.out.println("Filme e Ator inseridos com sucesso!");
                }
                case "Locação" -> {
                    LocacaoDAO locacaoDAO = (LocacaoDAO) dao;
                    System.out.print("Digite a data de locação (yyyy-mm-dd): ");
                    String dataLocacaoStr = scanner.nextLine();
                    System.out.print("Digite o desconto: ");
                    BigDecimal desconto = scanner.nextBigDecimal();
                    System.out.print("Digite a multa: ");
                    BigDecimal multa = scanner.nextBigDecimal();
                    System.out.print("Digite o subtotal: ");
                    BigDecimal subTotal = scanner.nextBigDecimal();
                    System.out.print("Digite o ID do cliente: ");
                    int clienteId = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cliente = DAOLoader.createClienteDAO().findById(clienteId);
                    Date dataLocacao = java.sql.Date.valueOf(dataLocacaoStr);
                    Locacao locacao = new Locacao(dataLocacao, desconto, multa, subTotal, cliente);
                    locacaoDAO.insert(locacao);
                    System.out.println("Locação inserida com sucesso!");
                }
                case "Locação e Filme" -> {
                    LocacaoFilmeDAO locacaoFilmeDAO = (LocacaoFilmeDAO) dao;
                    System.out.print("Digite o ID da locação: ");
                    int locacaoId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    System.out.print("Digite o valor: ");
                    BigDecimal valor = scanner.nextBigDecimal();
                    System.out.print("Digite o número de dias: ");
                    int numeroDias = scanner.nextInt();
                    System.out.print("Digite a data de devolução (yyyy-mm-dd): ");
                    String dataDevolucaoStr = scanner.next();
                    scanner.nextLine();
                    Locacao locacao = DAOLoader.createLocacaoDAO().findById(locacaoId);
                    Filme filme = DAOLoader.createFilmeDAO().findById(filmeId);
                    Date dataDevolucao = java.sql.Date.valueOf(dataDevolucaoStr);
                    LocacaoFilme locacaoFilme = new LocacaoFilme(locacao, filme, valor, numeroDias, dataDevolucao);
                    locacaoFilmeDAO.insert(locacaoFilme);
                    System.out.println("Locação e Filme inseridos com sucesso!");
                }
                default -> System.out.println("Entidade não suportada para inserção.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir " + entityName + ": " + e.getMessage());
        }
    }

    private void updateEntity(Object dao, String entityName) {
        try {
            System.out.print("Digite o ID do " + entityName + ": ");
            int id = scanner.nextInt();
            scanner.nextLine();

            switch (entityName) {
                case "Cliente" -> {
                    ClienteDAO clienteDAO = (ClienteDAO) dao;
                    Cliente cliente = clienteDAO.findById(id);
                    System.out.print("Digite o novo nome: ");
                    cliente.setNome(scanner.nextLine());
                    System.out.print("Digite o novo telefone: ");
                    cliente.setTelefone(scanner.nextLine());
                    clienteDAO.update(cliente);
                    System.out.println("Cliente atualizado com sucesso!");
                }
                case "Dependente" -> {
                    DependenteDAO dependenteDAO = (DependenteDAO) dao;
                    Dependente dependente = dependenteDAO.findById(id);
                    System.out.print("Digite o novo parentesco: ");
                    String novoParentesco = scanner.nextLine();
                    dependente.setParentesco(novoParentesco);
                    dependenteDAO.update(id, novoParentesco);
                    System.out.println("Dependente atualizado com sucesso!");
                }
                case "Endereço" -> {
                    EnderecoDAO enderecoDAO = (EnderecoDAO) dao;
                    Endereco endereco = enderecoDAO.findById(id);
                    System.out.print("Digite o novo logradouro: ");
                    endereco.setLogradouro(scanner.nextLine());
                    enderecoDAO.update(endereco);
                    System.out.println("Endereço atualizado com sucesso!");
                }
                case "Profissão" -> {
                    ProfissaoDAO profissaoDAO = (ProfissaoDAO) dao;
                    Profissao profissao = profissaoDAO.findById(id);
                    System.out.print("Digite o novo nome da profissão: ");
                    profissao.setNome(scanner.nextLine());
                    profissaoDAO.update(profissao);
                    System.out.println("Profissão atualizada com sucesso!");
                }
                case "Filme" -> {
                    FilmeDAO filmeDAO = (FilmeDAO) dao;
                    Filme filme = filmeDAO.findById(id);
                    System.out.print("Digite o novo título: ");
                    filme.setTitulo(scanner.nextLine());
                    System.out.print("Digite a nova quantidade: ");
                    filme.setQuantidade(scanner.nextInt());
                    scanner.nextLine();
                    filmeDAO.update(filme);
                    System.out.println("Filme atualizado com sucesso!");
                }
                case "Categoria" -> {
                    CategoriaDAO categoriaDAO = (CategoriaDAO) dao;
                    Categoria categoria = categoriaDAO.findById(id);
                    System.out.print("Digite o novo nome: ");
                    categoria.setNome(scanner.nextLine());
                    System.out.print("Digite o novo valor: ");
                    categoria.setValor(scanner.nextBigDecimal());
                    scanner.nextLine();
                    categoriaDAO.update(categoria);
                    System.out.println("Categoria atualizada com sucesso!");
                }
                case "Genero" -> {
                    GeneroDAO generoDAO = (GeneroDAO) dao;
                    Genero genero = generoDAO.findById(id);
                    System.out.print("Digite o novo nome: ");
                    genero.setNome(scanner.nextLine());
                    generoDAO.update(genero);
                    System.out.println("Genero atualizado com sucesso!");
                }
                case "Ator" -> {
                    AtorDAO atorDAO = (AtorDAO) dao;
                    Ator ator = atorDAO.findById(id);
                    System.out.print("Digite o novo nome: ");
                    ator.setNome(scanner.nextLine());
                    atorDAO.update(ator);
                    System.out.println("Ator atualizado com sucesso!");
                }
                case "FilmeAtor" -> {
                    FilmeAtorDAO filmeAtorDAO = (FilmeAtorDAO) dao;
                    System.out.print("Digite o ID do ator: ");
                    int atorId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    FilmeAtor filmeAtor = filmeAtorDAO.findById(atorId, filmeId);
                    System.out.print("É ator (true/false): ");
                    filmeAtor.setIsAtor(scanner.nextBoolean());
                    System.out.print("É diretor (true/false): ");
                    filmeAtor.setIsDiretor(scanner.nextBoolean());
                    scanner.nextLine();
                    filmeAtorDAO.update(filmeAtor);
                    System.out.println("Filme e Ator atualizados com sucesso!");
                }
                case "Locação" -> {
                    LocacaoDAO locacaoDAO = (LocacaoDAO) dao;
                    Locacao locacao = locacaoDAO.findById(id);
                    System.out.print("Digite a nova data de locação (yyyy-mm-dd): ");
                    locacao.setDataLocacao(java.sql.Date.valueOf(scanner.nextLine()));
                    System.out.print("Digite o novo desconto: ");
                    locacao.setDesconto(scanner.nextBigDecimal());
                    System.out.print("Digite a nova multa: ");
                    locacao.setMulta(scanner.nextBigDecimal());
                    System.out.print("Digite o novo subtotal: ");
                    locacao.setSubTotal(scanner.nextBigDecimal());
                    scanner.nextLine();
                    locacaoDAO.update(locacao);
                    System.out.println("Locação atualizada com sucesso!");
                }
                case "Locação e Filme" -> {
                    LocacaoFilmeDAO locacaoFilmeDAO = (LocacaoFilmeDAO) dao;
                    System.out.print("Digite o ID da locação: ");
                    int locacaoId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    LocacaoFilme locacaoFilme = locacaoFilmeDAO.findById(locacaoId, filmeId);
                    System.out.print("Digite o novo valor: ");
                    locacaoFilme.setValor(scanner.nextBigDecimal());
                    System.out.print("Digite o novo número de dias: ");
                    locacaoFilme.setNumeroDias(scanner.nextInt());
                    System.out.print("Digite a nova data de devolução (yyyy-mm-dd): ");
                    locacaoFilme.setDataDevolucao(java.sql.Date.valueOf(scanner.next()));
                    scanner.nextLine();
                    locacaoFilmeDAO.update(locacaoFilme);
                    System.out.println("Locação e Filme atualizados com sucesso!");
                }
                default -> System.out.println("Entidade não suportada para atualização.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar " + entityName + ": " + e.getMessage());
        }
    }

    private void findEntityById(Object dao, String entityName) {
        try {
            System.out.print("Digite o ID do " + entityName + ": ");
            int id = scanner.nextInt();
            scanner.nextLine();
            switch (entityName) {
                case "Cliente" -> {
                    ClienteDAO clienteDAO = (ClienteDAO) dao;
                    Cliente foundCliente = clienteDAO.findById(id);
                    System.out.println(foundCliente.toString());
                }
                case "Dependente" -> {
                    DependenteDAO dependenteDAO = (DependenteDAO) dao;
                    Dependente foundDependente = dependenteDAO.findById(id);
                    System.out.println(foundDependente.toString());
                }
                case "Endereço" -> {
                    EnderecoDAO enderecoDAO = (EnderecoDAO) dao;
                    Endereco foundEndereco = enderecoDAO.findById(id);
                    System.out.println("Endereço encontrado: " + foundEndereco.getLogradouro());
                }
                case "Profissão" -> {
                    ProfissaoDAO profissaoDAO = (ProfissaoDAO) dao;
                    Profissao foundProfissao = profissaoDAO.findById(id);
                    System.out.println("Profissão encontrada: " + foundProfissao.getNome());
                }
                case "Filme" -> {
                    FilmeDAO filmeDAO = (FilmeDAO) dao;
                    Filme foundFilme = filmeDAO.findById(id);
                    System.out.println("Filme encontrado: " + foundFilme.getTitulo());
                }
                case "Categoria" -> {
                    CategoriaDAO categoriaDAO = (CategoriaDAO) dao;
                    Categoria foundCategoria = categoriaDAO.findById(id);
                    System.out.println("Categoria encontrada: " + foundCategoria.getNome());
                }
                case "Genero" -> {
                    GeneroDAO generoDAO = (GeneroDAO) dao;
                    Genero foundGenero = generoDAO.findById(id);
                    System.out.println("Genero encontrado: " + foundGenero.getNome());
                }
                case "Ator" -> {
                    AtorDAO atorDAO = (AtorDAO) dao;
                    Ator foundAtor = atorDAO.findById(id);
                    System.out.println("Ator encontrado: " + foundAtor.getNome());
                }
                case "FilmeAtor" -> {
                    FilmeAtorDAO filmeAtorDAO = (FilmeAtorDAO) dao;
                    System.out.print("Digite o ID do ator: ");
                    int atorId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    FilmeAtor foundFilmeAtor = filmeAtorDAO.findById(atorId, filmeId);
                    System.out.println("Filme e Ator encontrados: " + foundFilmeAtor.getFilme().getTitulo() + " - " + foundFilmeAtor.getAtor().getNome());
                }
                case "Locação" -> {
                    LocacaoDAO locacaoDAO = (LocacaoDAO) dao;
                    Locacao foundLocacao = locacaoDAO.findById(id);
                    System.out.println("Locação encontrada: " + foundLocacao.getCliente().getNome() + " - " + foundLocacao.getDataLocacao());
                }
                case "Locação e Filme" -> {
                    LocacaoFilmeDAO locacaoFilmeDAO = (LocacaoFilmeDAO) dao;
                    System.out.print("Digite o ID da locação: ");
                    int locacaoId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    LocacaoFilme foundLocacaoFilme = locacaoFilmeDAO.findById(locacaoId, filmeId);
                    System.out.println("Locação e Filme encontrados: " + foundLocacaoFilme.getLocacao().getCliente().getNome() + " - " + foundLocacaoFilme.getFilme().getTitulo());
                }
                default -> System.out.println("Entidade não suportada para busca.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar " + entityName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void listEntities(Object dao) {
        try {
            if (dao instanceof ClienteDAO clienteDAO) {
                List<Cliente> clientes = clienteDAO.findAll();
                clientes.forEach(c -> System.out.println(c.toString()));
            } else if (dao instanceof DependenteDAO dependenteDAO) {
                List<Dependente> dependentes = dependenteDAO.findAll();
                dependentes.forEach(d -> System.out.println(d.toString()));
            } else if (dao instanceof EnderecoDAO enderecoDAO) {
                List<Endereco> enderecos = enderecoDAO.findAll();
                enderecos.forEach(e -> System.out.println(e.toString()));
            } else if (dao instanceof ProfissaoDAO profissaoDAO) {
                List<Profissao> profissoes = profissaoDAO.findAll();
                profissoes.forEach(p -> System.out.println(p.toString()));
            } else if (dao instanceof FilmeDAO filmeDAO) {
                List<Filme> filmes = filmeDAO.findAll();
                filmes.forEach(f -> System.out.println(f.toString()));
            } else if (dao instanceof CategoriaDAO categoriaDAO) {
                List<Categoria> categorias = categoriaDAO.findAll();
                categorias.forEach(c -> System.out.println(c.toString()));
            } else if (dao instanceof GeneroDAO generoDAO) {
                List<Genero> generos = generoDAO.findAll();
                generos.forEach(g -> System.out.println(g.toString()));
            } else if (dao instanceof AtorDAO atorDAO) {
                List<Ator> atores = atorDAO.findAll();
                atores.forEach(a -> System.out.println(a.toString()));
            } else if (dao instanceof FilmeAtorDAO filmeAtorDAO) {
                List<FilmeAtor> filmeAtores = filmeAtorDAO.findAll();
                filmeAtores.forEach(fa -> System.out.println(fa.toString()));
            } else if (dao instanceof LocacaoDAO locacaoDAO) {
                List<Locacao> locacoes = locacaoDAO.findAll();
                locacoes.forEach(l -> System.out.println(l.toString()));
            } else if (dao instanceof LocacaoFilmeDAO locacaoFilmeDAO) {
                List<LocacaoFilme> locacaoFilmes = locacaoFilmeDAO.findAll();
                locacaoFilmes.forEach(lf -> System.out.println(lf.toString()));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar entidades: " + e.getMessage());
        }
    }

    private void deleteEntityById(Object dao, String entityName) {
        try {
            System.out.print("Digite o ID do " + entityName + " a ser deletado: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            switch (entityName) {
                case "Cliente" -> {
                    ClienteDAO clienteDAO = (ClienteDAO) dao;
                    clienteDAO.deleteById(id);
                    System.out.println(entityName + " deletado com sucesso!");
                }
                case "Dependente" -> {
                    DependenteDAO dependenteDAO = (DependenteDAO) dao;
                    dependenteDAO.deleteById(id);
                    System.out.println("Dependente deletado com sucesso!");
                }
                case "Endereço" -> {
                    EnderecoDAO enderecoDAO = (EnderecoDAO) dao;
                    enderecoDAO.deleteById(id);
                    System.out.println("Endereço deletado com sucesso!");
                }
                case "Profissão" -> {
                    ProfissaoDAO profissaoDAO = (ProfissaoDAO) dao;
                    profissaoDAO.deleteById(id);
                    System.out.println("Profissão deletada com sucesso!");
                }
                case "Filme" -> {
                    FilmeDAO filmeDAO = (FilmeDAO) dao;
                    filmeDAO.deleteById(id);
                    System.out.println("Filme deletado com sucesso!");
                }
                case "Categoria" -> {
                    CategoriaDAO categoriaDAO = (CategoriaDAO) dao;
                    categoriaDAO.deleteById(id);
                    System.out.println("Categoria deletada com sucesso!");
                }
                case "Genero" -> {
                    GeneroDAO generoDAO = (GeneroDAO) dao;
                    generoDAO.deleteById(id);
                    System.out.println("Genero deletado com sucesso!");
                }
                case "Ator" -> {
                    AtorDAO atorDAO = (AtorDAO) dao;
                    atorDAO.deleteById(id);
                    System.out.println("Ator deletado com sucesso!");
                }
                case "FilmeAtor" -> {
                    FilmeAtorDAO filmeAtorDAO = (FilmeAtorDAO) dao;
                    System.out.print("Digite o ID do ator: ");
                    int atorId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    filmeAtorDAO.deleteById(atorId, filmeId);
                    System.out.println("Filme e Ator deletados com sucesso!");
                }
                case "Locação" -> {
                    LocacaoDAO locacaoDAO = (LocacaoDAO) dao;
                    locacaoDAO.deleteById(id);
                    System.out.println("Locação deletada com sucesso!");
                }
                case "Locação e Filme" -> {
                    LocacaoFilmeDAO locacaoFilmeDAO = (LocacaoFilmeDAO) dao;
                    System.out.print("Digite o ID da locação: ");
                    int locacaoId = scanner.nextInt();
                    System.out.print("Digite o ID do filme: ");
                    int filmeId = scanner.nextInt();
                    scanner.nextLine();
                    locacaoFilmeDAO.deleteById(locacaoId, filmeId);
                    System.out.println("Locação e Filme deletados com sucesso!");
                }
                default -> System.out.println("Entidade não suportada para deleção.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar " + entityName + ": " + e.getMessage());
        }
    }

}
