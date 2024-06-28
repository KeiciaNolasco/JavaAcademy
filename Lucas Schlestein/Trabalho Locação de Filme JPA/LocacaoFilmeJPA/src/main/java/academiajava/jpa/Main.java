package academiajava.jpa;

import academiajava.jpa.util.DatabaseInitializer;
import academiajava.jpa.util.Menu;
import academiajava.jpa.util.JPAUtil;

public class Main {
    public static void main(String[] args) {

        try {
            DatabaseInitializer databaseInitializer = new DatabaseInitializer();
            databaseInitializer.initialize();

            Menu menu = new Menu();
            menu.show();
        }
        finally {
            JPAUtil.shutdown();
        }

    }

}
