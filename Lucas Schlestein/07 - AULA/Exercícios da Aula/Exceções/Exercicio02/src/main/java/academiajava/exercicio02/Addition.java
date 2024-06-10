package academiajava.exercicio02;

public class Addition extends Operation {

    public Addition(double a, double b) throws ZeroOperatorsException {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a + b;
        return result;
    }

}
