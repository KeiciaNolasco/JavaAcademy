package academiajava.jpa.util;

import academiajava.jpa.DAO.DepartamentoDAO;
import academiajava.jpa.DAO.FuncionarioDAO;
import academiajava.jpa.DAO.ProjetoDAO;
import academiajava.jpa.model.Departamento;
import academiajava.jpa.model.Funcionario;
import academiajava.jpa.model.Projeto;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private static final ProjetoDAO projetoDAO = new ProjetoDAO();

    public void show() {
        System.out.println("\n————— BEM VINDO AO PROGRAMA —————");
        while (true) {
            showMainMenu();
            int option = getOptionInput();
            switch (option) {
                case 1 -> configureEntity("Departamento");
                case 2 -> configureEntity("Funcionário");
                case 3 -> configureEntity("Projeto");
                case 4 -> {
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
        System.out.println("1- Departamento");
        System.out.println("2- Funcionário");
        System.out.println("3- Projeto");
        System.out.println("4- Sair do Programa");
        System.out.print("\nDigite o número do item que deseja configurar: ");
    }

    private int getCrudOption(String entity) {
        System.out.printf("\n————— CONFIGURAÇÃO ————— [%s]%n", entity);
        System.out.println("1- Inserir");
        System.out.println("2- Atualizar");
        System.out.println("3- Buscar por ID");
        if (entity.equals("Funcionário")) {
            System.out.println("4- Buscar por ID do Departamento");
            System.out.println("5- Buscar por ID do Projeto");
            System.out.println("6- Listar");
            System.out.println("7- Deletar");
            System.out.println("8- Voltar ao Menu");
            System.out.println("9- Sair do Programa");
        } else {
            System.out.println("4- Listar");
            System.out.println("5- Deletar");
            System.out.println("6- Voltar ao Menu");
            System.out.println("7- Sair do Programa");
        }
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
                    case 4 -> {
                        if (entity.equals("Funcionário")) {
                            findEntityByDepartmentId();
                        } else {
                            listEntities(entity);
                        }
                    }
                    case 5 -> {
                        if (entity.equals("Funcionário")) {
                            findEntityByProjectId();
                        } else {
                            deleteEntityById(entity);
                        }
                    }
                    case 6 -> {
                        if (entity.equals("Funcionário")) {
                            listEntities(entity);
                        } else {
                            return;
                        }
                    }
                    case 7 -> {
                        if (entity.equals("Funcionário")) {
                            deleteEntityById(entity);
                        } else {
                            System.out.println("Saindo...");
                            System.exit(0);
                        }
                    }
                    case 8 -> {
                        if (entity.equals("Funcionário")) {
                            return;
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    case 9 -> {
                        if (entity.equals("Funcionário")) {
                            System.out.println("Saindo...");
                            System.exit(0);
                        } else {
                            System.out.println("Opção inválida!");
                        }
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
                case "Departamento" -> {
                    System.out.print("Nome do Departamento: ");
                    String nome = scanner.nextLine();
                    Departamento departamento = Departamento.builder().nome(nome).build();
                    departamentoDAO.save(departamento);
                    System.out.println("Departamento salvo com sucesso!");
                }
                case "Funcionário" -> {
                    System.out.print("Nome do Funcionario: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cargo do Funcionario: ");
                    String cargo = scanner.nextLine();
                    System.out.print("ID do Departamento: ");
                    Long departamentoId = Long.parseLong(scanner.nextLine());
                    System.out.print("ID do Projeto: ");
                    Long projetoId = Long.parseLong(scanner.nextLine());

                    Departamento departamento = departamentoDAO.findById(departamentoId);
                    Projeto projeto = projetoDAO.findById(projetoId);

                    if (departamento != null && projeto != null) {
                        Funcionario funcionario = Funcionario.builder()
                                .nome(nome)
                                .cargo(cargo)
                                .departamento(departamento)
                                .projeto(projeto)
                                .build();
                        funcionarioDAO.save(funcionario);
                        System.out.println("Funcionario salvo com sucesso!");
                    } else {
                        System.out.println("Departamento ou Projeto não encontrado!");
                    }
                }
                case "Projeto" -> {
                    System.out.print("Nome do Projeto: ");
                    String nome = scanner.nextLine();
                    Projeto projeto = Projeto.builder().nome(nome).build();
                    projetoDAO.save(projeto);
                    System.out.println("Projeto salvo com sucesso!");
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
            Long id = Long.parseLong(scanner.nextLine());

            switch (entity) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDAO.findById(id);
                    if (departamento != null) {
                        System.out.print("Novo nome do Departamento: ");
                        departamento.setNome(scanner.nextLine());
                        departamentoDAO.update(departamento);
                        System.out.println("Departamento atualizado com sucesso!");
                    } else {
                        System.out.println("Departamento não encontrado!");
                    }
                }
                case "Funcionário" -> {
                    Funcionario funcionario = funcionarioDAO.findById(id);
                    if (funcionario != null) {
                        System.out.print("Novo nome do Funcionario: ");
                        funcionario.setNome(scanner.nextLine());
                        System.out.print("Novo cargo do Funcionario: ");
                        funcionario.setCargo(scanner.nextLine());
                        System.out.print("ID do Departamento: ");
                        Long departamentoId = Long.parseLong(scanner.nextLine());
                        System.out.print("ID do Projeto: ");
                        Long projetoId = Long.parseLong(scanner.nextLine());

                        Departamento departamento = departamentoDAO.findById(departamentoId);
                        Projeto projeto = projetoDAO.findById(projetoId);

                        if (departamento != null && projeto != null) {
                            funcionario.setDepartamento(departamento);
                            funcionario.setProjeto(projeto);
                            funcionarioDAO.update(funcionario);
                            System.out.println("Funcionario atualizado com sucesso!");
                        } else {
                            System.out.println("Departamento ou Projeto não encontrado!");
                        }
                    } else {
                        System.out.println("Funcionario não encontrado!");
                    }
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDAO.findById(id);
                    if (projeto != null) {
                        System.out.print("Novo nome do Projeto: ");
                        projeto.setNome(scanner.nextLine());
                        projetoDAO.update(projeto);
                        System.out.println("Projeto atualizado com sucesso!");
                    } else {
                        System.out.println("Projeto não encontrado!");
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
            Long id = Long.parseLong(scanner.nextLine());

            switch (entity) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDAO.findById(id);
                    System.out.println(departamento != null ? departamento : "Departamento não encontrado!");
                }
                case "Funcionário" -> {
                    Funcionario funcionario = funcionarioDAO.findById(id);
                    System.out.println(funcionario != null ? funcionario : "Funcionario não encontrado!");
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDAO.findById(id);
                    System.out.println(projeto != null ? projeto : "Projeto não encontrado!");
                }
                default -> System.out.println("Entidade não suportada para busca.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar " + entity + ": " + e.getMessage());
        }
    }

    private void findEntityByDepartmentId() {
        try {
            System.out.print("ID do Departamento: ");
            Long departamentoId = Long.parseLong(scanner.nextLine());
            List<Funcionario> funcionarios = funcionarioDAO.findByDepartamento(departamentoId);
            funcionarios.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionarios por departamento: " + e.getMessage());
        }
    }

    private void findEntityByProjectId() {
        try {
            System.out.print("ID do Projeto: ");
            Long projetoId = Long.parseLong(scanner.nextLine());
            List<Funcionario> funcionarios = funcionarioDAO.findByProjeto(projetoId);
            funcionarios.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionarios por projeto: " + e.getMessage());
        }
    }

    private void listEntities(String entity) {
        try {
            switch (entity) {
                case "Departamento" -> {
                    List<Departamento> departamentos = departamentoDAO.findAll();
                    departamentos.forEach(System.out::println);
                }
                case "Funcionário" -> {
                    List<Funcionario> funcionarios = funcionarioDAO.findAll();
                    funcionarios.forEach(System.out::println);
                }
                case "Projeto" -> {
                    List<Projeto> projetos = projetoDAO.findAll();
                    projetos.forEach(System.out::println);
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
            Long id = Long.parseLong(scanner.nextLine());
            switch (entity) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDAO.findById(id);
                    if (departamento != null) {
                        departamentoDAO.delete(departamento);
                        System.out.println("Departamento deletado com sucesso!");
                    } else {
                        System.out.println("Departamento não encontrado!");
                    }
                }
                case "Funcionário" -> {
                    Funcionario funcionario = funcionarioDAO.findById(id);
                    if (funcionario != null) {
                        funcionarioDAO.delete(funcionario);
                        System.out.println("Funcionario deletado com sucesso!");
                    } else {
                        System.out.println("Funcionario não encontrado!");
                    }
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDAO.findById(id);
                    if (projeto != null) {
                        projetoDAO.delete(projeto);
                        System.out.println("Projeto deletado com sucesso!");
                    } else {
                        System.out.println("Projeto não encontrado!");
                    }
                }
                default -> System.out.println("Entidade não suportada para deleção.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar " + entity + ": " + e.getMessage());
        }
    }

}
