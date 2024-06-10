package academiajava.exercicio01;

public abstract class Operation {

    protected double a;
    protected double b;
    protected double result;

    public Operation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public abstract Double calculate();

    @Override
    public String toString() {
        return "\n Operation Result: " + calculate();
    }
}
