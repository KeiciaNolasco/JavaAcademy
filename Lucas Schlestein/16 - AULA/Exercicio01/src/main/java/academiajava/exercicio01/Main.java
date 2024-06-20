package academiajava.exercicio01;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        //Database.getAllPerson();

        //int lines;
        //lines = Database.updatePerson(1, "Paul Doe", "paul@gmail.com");
        //lines = Database.deletePerson(2);
        //System.out.println("Lines changed: " + lines);
        Database.getAllPerson();
        Database.closeConnection();
    }
}