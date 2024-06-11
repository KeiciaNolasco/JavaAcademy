package academiajava.salessystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void listProduct() {
        for (Product product: products) {
            System.out.println(product.displayDetails());
        }
    }

    public List<Product> exportProductList() {
        return new ArrayList<>(products);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product: products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void generateTextFile(String file) throws ShoppingCartException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("item:\t\tQty:\t\tName:\t\tPrice:\t\tSubTotal:\n");
            int item = 1;
            for (Product product: products) {
                double subTotal = product.getPrice() * product.getQuantity();
                writer.write(item + "\t\t" + product.getQuantity() + "\t\t" + product.getName() + "\t\t" + product.getPrice() + "\t\t " + subTotal + "\n");
                item++;
            }
            writer.write("Total: " + calculateTotal());
        } catch (IOException e) {
            throw new ShoppingCartException("Error generating text file: " + file, e);
        }
    }

}
