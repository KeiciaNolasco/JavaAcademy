package academiajava.exercicio02;

public class Division extends Operation {

    public Division(double a, double b) throws ZeroOperatorsException {
        super(a, b);
    }

    @Override
    public Double calculate() {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero operation is not allowed!");
        }
        result = a / b;
        return result;
    }

}
