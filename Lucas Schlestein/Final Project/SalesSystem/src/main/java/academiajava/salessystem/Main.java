package academiajava.salessystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Configurando o formatador de data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Inicializando carrinhos de compras com produtos
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(new Electronic("Television", 5000.00, 1, 12));
        cart1.addProduct(new Clothing("T-Shirt", 150.00, 1, "large", "blue"));
        cart1.addProduct(new Food("Rice", 15.30, 1, LocalDate.parse("02/06/2025", formatter)));

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(new Electronic("Computer", 3000.00, 2, 24));
        cart2.addProduct(new Clothing("Socks", 20.00, 4, "Average", "black"));
        cart2.addProduct(new Food("Tomato Sauce", 10.50, 2, LocalDate.parse("05/10/2025", formatter)));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nWelcome to the Sales System");

                System.out.print("\nSelect the option you want" +
                        "\n1- View shopping cart 1;" +
                        "\n2- View shopping cart 2;" +
                        "\n3- Add new Product;" +
                        "\n4- Remove a product;" +
                        "\n5- Save shopping carts in a \".txt\" file;" +
                        "\n6- Log out of the system." +
                        "\nEnter the item number: ");
                int item = Integer.parseInt(scanner.nextLine());

                switch (item) {
                    case 1:
                        System.out.println("\nShopping Cart 1:");
                        cart1.listProduct();
                        System.out.println("Total: " + cart1.calculateTotal());
                        break;
                    case 2:
                        System.out.println("\nShopping Cart 2:");
                        cart2.listProduct();
                        System.out.println("Total: " + cart2.calculateTotal());
                        break;
                    case 3:
                        System.out.print("\nOption not yet available in the system!");
                        break;
                    case 4:
                        System.out.print("\nOption not yet available in the system!");
                        break;
                    case 5:
                        try {
                            cart1.generateTextFile("ShoppingCart1.txt");
                            cart2.generateTextFile("ShoppingCart2.txt");
                            System.out.println("\nText files created successfully!" + "\nYou can find them in the project root folder.");
                        } catch (ShoppingCartException e) {
                            System.err.println(e.getMessage());
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        System.out.println("\nLogging out...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid option! Please enter a valid number.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nThe value entered does not correspond to a number!");
            }
        }
    }
}