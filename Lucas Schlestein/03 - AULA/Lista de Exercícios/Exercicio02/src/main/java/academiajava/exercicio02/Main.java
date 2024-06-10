package academiajava.exercicio02;

import academiajava.exercicio02.entities.Administrator;
import academiajava.exercicio02.entities.Class;
import academiajava.exercicio02.entities.Student;
import academiajava.exercicio02.services.ManagementService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(1, "Joao", 22, 1234);
        Student student2 = new Student(2, "Leonardo", 20, 1235);
        Student student3 = new Student(3, "Lucas", 21, 1236);
        Student student4 = new Student(4, "Fabricio", 19, 1237);
        Student student5 = new Student(5, "Maria", 23, 1238);

        Class classA = new Class(1, "Class A", "1A");
        Class classB = new Class(2, "Class B", "1B");
        List<Class> classes = new ArrayList<>();
        classes.add(classA);
        classes.add(classB);

        classA.addStudent(student1);
        classA.addStudent(student2);
        classA.addStudent(student3);
        classB.addStudent(student4);
        classB.addStudent(student5);

        Administrator administrator1 = new Administrator(1, "Keicia", "keicia@gmail.com", "123");
        Administrator administrator2 = new Administrator(2, "Lucas", "lucas@gmail.com", "123");

        List<Administrator> administrators = new ArrayList<>();
        administrators.add(administrator1);
        administrators.add(administrator2);

        ManagementService managementService = new ManagementService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your email or name: ");
        String input = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean authenticated = false;

        for (Administrator administrator : administrators) {
            if (managementService.authenticate(administrator, input, password)) {
                authenticated = true;
                System.out.println("\nAuthentication successful!");
                System.out.println("\nWelcome");
                System.out.print("1-Find student;" + "\n2-View the list of students by class;" + "\n3-Add new student to a class." + "\nEnter the number of the action you want to perform: ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    System.out.print("\nEnter the value to search for (id, name or registration): ");
                    String obj = scanner.nextLine();
                    managementService.listStudents(classes, obj);
                } else if (action == 2) {
                    managementService.listStudentsSeparately(classes);
                } else if (action == 3) {
                    System.out.print("\nEnter student ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nEnter student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("\nEnter student age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nEnter student registration: ");
                    int newRegistration = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(newId, newName, newAge, newRegistration);
                    System.out.print("\nEnter class (A or B): ");
                    String classChoice = scanner.nextLine();

                    if ("A".equalsIgnoreCase(classChoice)) {
                        classA.addStudent(newStudent);
                    } else if ("B".equalsIgnoreCase(classChoice)) {
                        classB.addStudent(newStudent);
                    } else {
                        System.out.println("Invalid class.");
                    }
                } else {
                    System.out.println("Invalid action.");
                }
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Authentication failed.");
        }

        scanner.close();
    }
}
