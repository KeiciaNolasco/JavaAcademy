package academiajava.exercicio02;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DateTimeException {

        DateTimeFormatter datef = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter hourf = DateTimeFormatter.ofPattern("HH:mm");

        List<Professional> professionals = new ArrayList<>();
        Professional professional1 = new Professional("Business dinner", LocalDate.parse("02-07-2024", datef), LocalTime.parse("19:00", hourf));
        professionals.add(professional1);

        List<Personal> personals = new ArrayList<>();
        Personal personal1 = new Personal("Coffee with the wife", LocalDate.parse("01-07-2024", datef), LocalTime.parse("08:00", hourf));
        personals.add(personal1);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nSelect the desired option" + "\n1- Add Professional Commitment;" + "\n2- Add Personal Commitment;" + "\n3- View the list of appointments." + "\nEnter the item number: ");
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            System.out.println("\nProfessional Commitment Registration");

            System.out.print("\nEnter the name of the professional commitment: ");
            String namePro2 = scanner.nextLine();

            System.out.print("Enter the date of the professional commitment (DD-MM-YYYY): ");
            LocalDate datePro2 = LocalDate.parse(scanner.nextLine(), datef);

            System.out.print("Enter the time of the professional commitment (HH:MM): ");
            LocalTime hourPro2 = LocalTime.parse(scanner.nextLine(), hourf);

            Professional professional2 = new Professional(namePro2, datePro2, hourPro2);
            professionals.add(professional2);

            for (Professional professional : professionals) {
               professional.displayCommitment();
           }
        }
       else if (option == 2) {
            System.out.print("\nEnter the name of the personal commitment: ");
            String namePer2 = scanner.nextLine();

            System.out.print("Enter the date of the personal commitment (DD-MM-YYYY): ");
            LocalDate datePer2 = LocalDate.parse(scanner.nextLine(), datef);

            System.out.print("Enter the time of the personal commitment (HH:MM): ");
            LocalTime hourPer2 = LocalTime.parse(scanner.nextLine(), hourf);

            Personal personal2 = new Personal(namePer2, datePer2, hourPer2);
            personals.add(personal2);

            for (Personal personal : personals) {
                personal.displayCommitment();
            }
       }
       else if (option == 3) {
           for (Professional professional : professionals) {
               professional.displayCommitment();
           }

           for (Personal personal : personals) {
               personal.displayCommitment();
           }
        }

    }

}