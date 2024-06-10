package academiajava.exercicio02;

import java.time.LocalDate;
import java.time.LocalTime;

public class Professional extends Commitment implements CommitmentInterface {

    public Professional(String name, LocalDate date, LocalTime hour) {
        super(name, date, hour);
    }

    @Override
    public void displayCommitment() {
        System.out.println("\nCommitment details" + "\nType: Professional Commitment" + toString());
    }

}
