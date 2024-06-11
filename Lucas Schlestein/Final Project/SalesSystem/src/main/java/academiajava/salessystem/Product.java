package academiajava.salessystem;

public interface Product {

    String getType();
    String getName();
    Double getPrice();
    Integer getQuantity();

    void setName(String name);
    void setPrice(Double price);
    void setQuantity(Integer quantity);

    String displayDetails();

}
