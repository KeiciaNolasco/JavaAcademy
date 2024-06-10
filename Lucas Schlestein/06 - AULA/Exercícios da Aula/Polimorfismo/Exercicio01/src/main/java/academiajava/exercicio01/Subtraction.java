package academiajava.exercicio01;

public class Subtraction extends Operation {

    public Subtraction(double a, double b) {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a - b;
        return result;
    }

}
