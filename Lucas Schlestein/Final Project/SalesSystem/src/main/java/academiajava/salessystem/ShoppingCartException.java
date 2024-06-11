package academiajava.salessystem;

public class ShoppingCartException extends Exception  {

    public ShoppingCartException(String message) {
        super(message);
    }

    public ShoppingCartException(String message, Throwable cause) {
        super(message, cause);
    }

}
