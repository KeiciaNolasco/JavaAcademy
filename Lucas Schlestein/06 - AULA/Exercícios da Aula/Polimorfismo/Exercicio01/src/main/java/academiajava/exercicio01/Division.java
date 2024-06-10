package academiajava.exercicio01;

public class Division extends Operation {

    public Division(double a, double b) {
        super(a, b);
    }

    @Override
    public Double calculate() {
        if (b != 0) {
            result = a / b;
        } else {
            throw new ArithmeticException("Divide by zero operation is not allowed!");
        }
        return result;
    }

}
