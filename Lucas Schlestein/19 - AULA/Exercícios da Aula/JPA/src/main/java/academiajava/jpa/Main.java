package academiajava.jpa;

import academiajava.jpa.DAO.DepartamentoDAO;
import academiajava.jpa.DAO.FuncionarioDAO;
import academiajava.jpa.DAO.ProjetoDAO;
import academiajava.jpa.initializer.DatabaseInitializer;
import academiajava.jpa.util.Menu;

public class Main {
    public static void main(String[] args) {

        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        boolean isDatabaseEmpty = departamentoDAO.findAll().isEmpty() &&
                funcionarioDAO.findAll().isEmpty() &&
                projetoDAO.findAll().isEmpty();

        if (isDatabaseEmpty) {
            DatabaseInitializer databaseInitializer = new DatabaseInitializer();
            databaseInitializer.populateDatabase();
            System.out.println("\nBANCO DE DADOS POPULADO!");
        } else {
            System.out.println("\nBANCO DE DADOS FOI POPULADO ANTERIORMENTE!");
        }

        Menu menu = new Menu();
        menu.show();
    }

}
