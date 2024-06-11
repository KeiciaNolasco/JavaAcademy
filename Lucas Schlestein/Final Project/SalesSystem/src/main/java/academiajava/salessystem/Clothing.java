package academiajava.salessystem;

public class Clothing extends BaseProduct {

    private String size;
    private String color;

    public Clothing() {
    }

    public Clothing(String name, Double price, Integer quantity, String size, String color) {
        super(name, price, quantity);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getType() {
        return "Clothing";
    }

    @Override
    public String displayDetails() {
        return getType() + ": " + getName() + ", Price: " + getPrice() + " months, Quantity: " + getQuantity() + ", Size: " + getSize() + ", Color: " + getColor();
    }

}
