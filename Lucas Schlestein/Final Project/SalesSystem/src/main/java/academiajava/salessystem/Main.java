package academiajava.salessystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ShoppingCart car1 = new ShoppingCart();
        car1.addProduct(new Electronic("Television", 7000.00, 1, 12));
        car1.addProduct(new Clothing("T-Shirt", 150.00, 1, "large", "blue"));
        car1.addProduct(new Food("Rice", 15.30, 1, LocalDate.parse("02/06/2025", formatter)));

        ShoppingCart car2 = new ShoppingCart();
        car2.addProduct(new Electronic("Computer", 3000.00, 2, 24));
        car2.addProduct(new Clothing("Socks", 20.00, 4, "Average", "black"));
        car2.addProduct(new Food("Tomato Sauce", 10.50, 2, LocalDate.parse("05/10/2025", formatter)));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nWelcome to the Sales System");

                System.out.print("\nSelect the option you want" +
                        "\n1- View shopping cart 1;" +
                        "\n2- View shopping cart 2;" +
                        "\n3- Save shopping carts in a \".txt\" file." +
                        "\nEnter the item number: ");
                int item = Integer.parseInt(scanner.nextLine());

                    if (item == 1) {
                        System.out.println("\nShopping Cart 1:");
                        car1.listProduct();
                        System.out.println("Total: " + car1.calculateTotal());
                    }
                    if (item == 2) {
                        System.out.println("\nShopping Cart 2:");
                        car2.listProduct();
                        System.out.println("Total: " + car2.calculateTotal());
                    }
                    if (item == 3) {
                        try {
                            car1.generateTextFile("ShoppingCart1.txt");
                            car2.generateTextFile("ShoppingCart2.txt");
                            System.out.println("\nText files created successfully!" + "\nYou can find it in the project root folder.");
                        } catch (ShoppingCartException e) {
                            System.err.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            catch(Exception e){
                    System.out.println("\nThe value entered does not correspond to a number!");
            }

        }

        scanner.close();

    }
}