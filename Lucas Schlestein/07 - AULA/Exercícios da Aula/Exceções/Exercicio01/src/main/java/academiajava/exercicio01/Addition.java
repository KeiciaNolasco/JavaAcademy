package academiajava.exercicio01;

public class Addition extends Operation {

    public Addition(double a, double b) {
        super(a, b);
    }

    @Override
    public Double calculate() {
        result = a + b;
        return result;
    }

}
