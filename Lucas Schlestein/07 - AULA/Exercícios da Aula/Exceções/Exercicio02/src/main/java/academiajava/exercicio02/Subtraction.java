package academiajava.exercicio02;

public class Subtraction extends Operation {

    public Subtraction(double a, double b) throws ZeroOperatorsException {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a - b;
        return result;
    }

}
