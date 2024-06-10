package academiajava.exercicio01;

public class Operation {

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

    public Double calculate() {
        return result;
    };

}
