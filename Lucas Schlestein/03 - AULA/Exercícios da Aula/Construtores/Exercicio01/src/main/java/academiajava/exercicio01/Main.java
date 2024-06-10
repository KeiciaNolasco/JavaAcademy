package academiajava.exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the person's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the person's age: ");
        Integer age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nWhat type of constructor do you want to use to instantiate the Person class:");
        System.out.print("\n1- Builder with name;" + "\n2- Aged builder;" + "\n3- Builder with name and age." + "\nEnter the item number: ");
        int item = scanner.nextInt();
        scanner.nextLine();

        if (item == 1) {
            Person person = new Person(name);
            System.out.println(person);
        }
        else if (item == 2) {
            Person person = new Person(age);
            System.out.println(person);
        }
        else if (item == 3) {
            Person person = new Person(name, age);
            System.out.println(person);
        }
        else {
            Person person = new Person();
            System.out.println(person);
        }

    }
}