package academiajava.exercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        User user1 = new User("Maria", "maria@gmail.com");
        users.add(user1);

        try {
            user1.recordData();

            System.out.println("\nWelcome to data registration");

            Scanner scanner = new Scanner(System.in);

            System.out.print("\nChoose the option you want" +
                    "\n1- Register the user name;" +
                    "\n2- Register the user’s name and e-mail;" +
                    "\n3- None of the options." +
                    "\nEnter the number of the item you want to run: ");
            int item = Integer.parseInt(scanner.nextLine());

            if (item == 1 || item == 2) {
                System.out.print("\nEnter the name of the user: ");
                String name2 = scanner.nextLine();

                if (item == 1) {
                    User user2 = new User(name2);
                    user2.recordData();
                    System.out.println("The data was saved in a .txt file with the user name!");
                }
                if (item == 2) {
                    System.out.print("Enter the e-mail of the user: ");
                    String email2 = scanner.nextLine();
                    User user2 = new User(name2, email2);
                    users.add(user2);
                    user2.recordData();
                    System.out.println("The data was saved in a .txt file with the user name!");
                }
            }
            else if (item == 3) {
                System.out.println(" ");
            }
            else {
                System.out.println("\nInvalid item!");
            }

            System.out.print("\nDo you want to read the data saved in the .txt file?" +
                    "\nEnter \"y\" (for yes) and \"n\" (for no): ");
            char option = scanner.nextLine().charAt(0);

                if (option == 'y') {
                    System.out.print("\nEnter the name of the user to read data: ");
                    String nameToRead = scanner.nextLine();
                    System.out.println("\nUsers");
                    User.readData(nameToRead);
                }
                else if (option == 'n') {
                    System.out.println("\nThank you, see you later!");
                }
                else {
                    System.out.println("\nInvalid option!");
                }

            scanner.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}