package academiajava.exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the calculator");

        System.out.print("\nWhat type of operation do you want to perform:" + "\n1- Addition;" + "\n2- Subtraction;" + "\n3- Multiplication;" + "\n4- Division;" + "\n5- All operations." + "\nEnter the item number: ");
        int item = Integer.parseInt(scanner.nextLine());

        System.out.print("\nEnter the first number: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the second number: ");
        double b = Double.parseDouble(scanner.nextLine());

        if (item == 1) {
            Operation addition = new Addition(a, b);
            System.out.println(addition.toString());
        }
        else if (item == 2) {
            Operation subtraction = new Subtraction(a, b);
            System.out.println(subtraction.toString());
        }
        else if (item == 3) {
            Operation multiplication = new Multiplication(a, b);
            System.out.println(multiplication.toString());
        }
        else if (item == 4) {
            Operation division = new Division(a, b);
            System.out.println(division.toString());
        }
        else if (item == 5) {
            Operation[] operations = {
                    new Addition(a, b),
                    new Subtraction(a, b),
                    new Multiplication(a, b),
                    new Division(a, b)
            };

            for (Operation operation : operations) {
                System.out.print(operation);
            }
        }

    }
}