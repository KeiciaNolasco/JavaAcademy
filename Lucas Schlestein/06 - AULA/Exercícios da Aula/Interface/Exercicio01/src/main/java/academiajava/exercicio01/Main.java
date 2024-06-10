package academiajava.exercicio01;

import java.util.Scanner;

public class Main extends Message {

    @Override
    public void displayMessageA() {
        System.out.println("\nMessage A: Take good care of animals.");
    }

    @Override
    public void displayMessageB(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nType a message to preserve the planet: ");
        String messageB = scanner.nextLine();

        Main main = new Main();
        main.displayMessageA();
        main.displayMessageB("Message B: " + messageB);
    }

}