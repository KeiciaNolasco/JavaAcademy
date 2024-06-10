package academiajava.exercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Maria", 1111, "1a");
        students.add(student1);

        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher1 = new Teacher("Lucas", 2222, "2b", 7000.00);
        teachers.add(teacher1);

        System.out.print("\nYou want to register" + "\n1- Student;" + "\n2- Teacher;" + "\n3- View the students and teachers already registered." + "\nEnter the option number: ");
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            System.out.println("\nStudent Registration");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("RG: ");
            Integer age = Integer.parseInt(scanner.nextLine());

            System.out.print("Matriculation: ");
            String matriculation = scanner.nextLine();

            Student student2 = new Student(name, age, matriculation);
            students.add(student2);

            System.out.print("\nRegistered Students");
            for (Student student : students) {
                student.presentData();
            }
        }
        else if (option == 2) {
            System.out.println("\nTeacher Registration");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("RG: ");
            Integer age = Integer.parseInt(scanner.nextLine());

            System.out.print("Matriculation: ");
            String matriculation = scanner.nextLine();

            System.out.print("Salary: ");
            Double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher2 = new Teacher(name, age, matriculation, salary);
            teachers.add(teacher2);

            System.out.print("\nRegistered Teacher");
            for (Teacher teacher : teachers) {
                teacher.presentData();
            }
        }
        else if (option == 3) {
            System.out.print("\nRegistered Students");
            for (Student student : students) {
                student.presentData();
            }

            System.out.print("\nRegistered Teacher");
            for (Teacher teacher : teachers) {
                teacher.presentData();
            }
        }
        else {
            System.out.println("\nInvalid option!");
        }

        scanner.close();

    }
}