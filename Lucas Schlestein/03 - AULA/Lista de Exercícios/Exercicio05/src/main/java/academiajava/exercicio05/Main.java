package academiajava.exercicio05;

import academiajava.exercicio05.entities.Person;
import academiajava.exercicio05.services.IncomeTax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(1, "Lucas", 5700.00);
        Person person2 = new Person(2, "Maria", 7000.00);
        Person person3 = new Person(3, "João", 8600.00);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        IncomeTax incomeTax1 = new IncomeTax(person1);
        IncomeTax incomeTax2 = new IncomeTax(person2);
        IncomeTax incomeTax3 = new IncomeTax(person3);

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);

        System.out.println("\nWelcome!");
        System.out.print("1-View the list of people and their respective income taxes;" + "\n2-Add a person and calculate their income tax." + "\nEnter the number of the action you want to perform: ");
        int action = scanner.nextInt();
        scanner.nextLine();

        if (action == 1) {
            System.out.println("\nPeople list:\n");
            for (Person person : people) {
                IncomeTax incomeTax = new IncomeTax(person);
                incomeTax.print();
            }
        }
        else if (action == 2) {
            System.out.print("\nEnter person ID: ");
            int newId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\nEnter person name: ");
            String newName = scanner.nextLine();
            System.out.print("\nEnter person salary: ");
            String weightInput = scanner.nextLine().replace(",", ".");
            double newSalary = Double.parseDouble(weightInput);
            Person newPerson = new Person(newId, newName, newSalary);
            people.add(newPerson);
            System.out.println("\nPeople list:\n");
            for (Person person : people) {
                IncomeTax incomeTax = new IncomeTax(person);
                incomeTax.print();
            }
        }
        else {
            System.out.println("Invalid action.");
        }

        scanner.close();
    }
}