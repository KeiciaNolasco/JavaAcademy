package academiajava.exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your type: ");
        String type = scanner.nextLine();

        Person person = new Person(name, age, type);

        System.out.println("\nPerson Information");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Type: " + person.getType());

        System.out.print("\nInformation about the " + type + " of Animal reported:");
        System.out.println("\n-" + person.walk() + "\n-" + person.walking());

        scanner.close();

    }
}