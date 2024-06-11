package academiajava.salessystem;

public class Electronic extends BaseProduct {

    private Integer monthsGuaranty;

    public Electronic() {
    }

    public Electronic(String name, Double price, Integer quantity, Integer monthsGuaranty) {
        super(name, price, quantity);
        this.monthsGuaranty = monthsGuaranty;
    }

    public Integer getMonthsGuaranty() {
        return monthsGuaranty;
    }

    public void setMonthsWarranty(Integer monthsGuaranty) {
        this.monthsGuaranty = monthsGuaranty;
    }

    @Override
    public String getType() {
        return "Electronic";
    }

    @Override
    public String displayDetails() {
        return getType() + ": " + getName() + ", Price: " + getPrice() + ", Quantity: " + getQuantity() + ", Guaranty: " + getMonthsGuaranty() + " months";
    }

}
