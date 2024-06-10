package academiajava.exercicio03;

import academiajava.exercicio03.entities.Client;
import academiajava.exercicio03.entities.Product;
import academiajava.exercicio03.entities.ShoppingCart;
import academiajava.exercicio03.services.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Mouse Gamer", 60.00, 2);
        Product product2 = new Product(2, "Teclado Mecânico", 100.00, 1);
        Product product3 = new Product(3, "Monitor 24", 1000.00, 1);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        Client client1 = new Client(1, "Lucas", 111111111, "lucas@gmail.com", "123");
        Client client2 = new Client(2, "Keicia", 222222222, "keicia@gmail.com", "123");

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        ClientService clientService = new ClientService();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter your email or name: ");
        String input = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean authenticated = false;

        for (Client client : clients) {
            if (clientService.authenticate(client, input, password)) {
                authenticated = true;
                System.out.println("\nAuthentication successful!");
                System.out.println("\nWelcome");
                System.out.print("1-List of products in the shopping cart;" + "\n2-Add product to shopping cart." + "\nEnter the number of the action you want to perform: ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    cart.listProducts();
                }
                else if (action == 2) {
                    System.out.print("Enter the product ID or name: ");
                    String productInput = scanner.nextLine();

                    Product selectedProduct = null;
                    for (Product product : cart.getProducts()) {
                        if (productInput.equalsIgnoreCase(product.getName()) || productInput.equals(String.valueOf(product.getId()))) {
                            selectedProduct = product;
                            break;
                        }
                    }

                    if (selectedProduct != null) {
                        System.out.print("Enter the quantity: ");
                        int quantity = scanner.nextInt();
                        selectedProduct.setQuantity(selectedProduct.getQuantity() + quantity);
                        System.out.println("Product added to cart.");
                        cart.listProducts();
                    }
                    else {
                        System.out.println("Product not found.");
                    }
                }
                else {
                    System.out.println("Invalid action.");
                }
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Authentication failed.");
        }

        scanner.close();

    }

}