package academiajava.exercicio02;

import java.time.LocalDate;
import java.time.LocalTime;

public class Personal extends Commitment implements CommitmentInterface {

    public Personal(String name, LocalDate date, LocalTime hour) {
        super(name, date, hour);
    }

    @Override
    public void displayCommitment() {
        System.out.println("\nCommitment details" + "\nType: Personal Commitment" + toString());
    }

}
