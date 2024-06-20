package academiajava.exercicio01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> listPersons = new ArrayList<>();
        Database.getConnection();
       //listPersons = Database.getAllPersons();
       // for (Person person : listPersons) {
        // System.out.println(person);
        // }

        System.out.println(Database.getPerson(2));
        int lines;
        Database.updatePerson(new Person(2,"updatedPerson","updatedPerson@mail.com"));
        //lines = Database.deletePerson(1);// remove uma pessoa por id
        lines = Database.insertPerson(new Person("Paul 2", "paul2@mail.com"));
        //System.out.println("Lines changed: "+lines);
        Database.disconnect();
    }

}