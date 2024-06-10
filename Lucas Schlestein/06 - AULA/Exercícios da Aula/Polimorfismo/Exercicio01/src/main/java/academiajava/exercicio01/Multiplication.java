package academiajava.exercicio01;

public class Multiplication extends Operation {

    public Multiplication(double a, double b) {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a * b;
        return result;
    }

}
