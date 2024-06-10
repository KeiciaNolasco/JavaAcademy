package academiajava.exercicio04.services;

import academiajava.exercicio04.entities.Patient;

public class CalculatorService {

    private Patient patient;

    public CalculatorService() {
    }

    public CalculatorService(Patient patient) {
        this.patient = patient;
    }

    public double calculateIMC() {
        return patient.getWeight() / (patient.getHeight() * patient.getHeight());
    }

    public String diagnostic() {
        double imc = calculateIMC();
        if (imc < 16) {
            return "Very serious underweight!";
        } else if (imc >= 16 && imc < 17) {
            return "Serious underweight!";
        } else if (imc >= 17 && imc < 18.5) {
            return "Low weight!";
        } else if (imc >= 18.5 && imc < 25) {
            return "Normal weight!";
        } else if (imc >= 25 && imc < 30) {
            return "Overweight!";
        } else if (imc >= 30 && imc < 35) {
            return "Grade I obesity!";
        } else if (imc >= 35 && imc < 40) {
            return "Grade II obesity!";
        } else {
            return "Grade III obesity (morbid obesity)!";
        }
    }

}
