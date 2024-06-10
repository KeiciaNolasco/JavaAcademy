package academiajava.exercicio02;

public class Multiplication extends Operation {

    public Multiplication(double a, double b) throws ZeroOperatorsException {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a * b;
        return result;
    }

}
