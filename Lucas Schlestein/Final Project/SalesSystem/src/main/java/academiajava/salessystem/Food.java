package academiajava.salessystem;

import java.time.LocalDate;

public class Food extends BaseProduct {

    private LocalDate expirationDate;

    public Food() {
    }

    public Food(String name, Double price, Integer quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getType() {
        return "Food";
    }

    @Override
    public String displayDetails() {
        return getType() + ": " + getName() + ", Price: " + getPrice() + " months, Quantity: " + getQuantity() + ", Expiration Date: " + getExpirationDate();
    }

}
