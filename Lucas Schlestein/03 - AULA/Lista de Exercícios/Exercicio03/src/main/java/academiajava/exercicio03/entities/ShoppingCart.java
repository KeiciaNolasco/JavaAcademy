package academiajava.exercicio03.entities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double getTotal() {
        return products.stream().mapToDouble(Product::getAmount).sum();
    }

    public void listProducts() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("\nProducts:");
        products.forEach(System.out::println);
        System.out.println("Total: " + nf.format(getTotal()));
    }

}
