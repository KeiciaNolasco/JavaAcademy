package academiajava.exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEmployee Registration " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            Integer age = Integer.parseInt(scanner.nextLine());

            System.out.print("Phone: ");
            Integer phone = Integer.parseInt(scanner.nextLine());

            System.out.print("Sector: ");
            String sector = scanner.nextLine();

            System.out.print("Office: ");
            String office = scanner.nextLine();

            System.out.print("Function: ");
            String function = scanner.nextLine();

            Employee employee = new Employee(name, age, phone, sector, office, function);
            employees.add(employee);
        }

        System.out.print("\nRegistered Employees");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        scanner.close();

    }
}