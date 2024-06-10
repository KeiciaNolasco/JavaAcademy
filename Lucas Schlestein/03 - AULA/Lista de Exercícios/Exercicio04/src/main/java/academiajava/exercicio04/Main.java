package academiajava.exercicio04;

import academiajava.exercicio04.entities.Patient;
import academiajava.exercicio04.services.CalculatorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Patient patient1 = new Patient(1, "Maria", 68.1, 1.80);
        Patient patient2 = new Patient(2, "João", 70.5, 1.80);
        Patient patient3 = new Patient(3, "Carlos", 82.7, 1.50);

        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);

        System.out.println("\nWelcome!");
        System.out.print("1-View the patient list;" + "\n2-Add new patient." + "\nEnter the number of the action you want to perform: ");
        int action = scanner.nextInt();
        scanner.nextLine();

        if (action == 1) {
            System.out.println("\nPatients list:\n");
            for (Patient patient : patients) {
                CalculatorService calculator = new CalculatorService(patient);
                double imc = calculator.calculateIMC();
                String diagnosis = calculator.diagnostic();
                System.out.printf("Patient: %s\nIMC: %.2f\nDiagnosis: %s\n\n", patient, imc, diagnosis);
            }
        }
        else if (action == 2) {
            System.out.print("\nEnter patient ID: ");
            int newId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\nEnter patient name: ");
            String newName = scanner.nextLine();
            System.out.print("\nEnter patient weight: ");
            String weightInput = scanner.nextLine().replace(",", ".");
            double newWeight = Double.parseDouble(weightInput);
            System.out.print("\nEnter patient height: ");
            String heightInput = scanner.nextLine().replace(",", ".");
            double newHeight = Double.parseDouble(heightInput);
            Patient newPatient = new Patient(newId, newName, newWeight, newHeight);
            patients.add(newPatient);
            System.out.println("\nPatients list:\n");
            for (Patient patient : patients) {
                CalculatorService calculator = new CalculatorService(patient);
                double imc = calculator.calculateIMC();
                String diagnosis = calculator.diagnostic();
                System.out.printf("Patient: %s\nIMC: %.2f\nDiagnosis: %s\n\n", patient, imc, diagnosis);
            }
        }
        else {
            System.out.println("Invalid action.");
        }

        scanner.close();
    }
}