package academiajava.exercicio04;

public class Teacher extends Person {

    public String matriculation;
    public Double salary;

    public Teacher(String name, Integer RG, String matriculation, Double salary) {
        super(name, RG);
        this.matriculation = matriculation;
        this.salary = salary;
    }

    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public void presentData() {
        super.presentData();
        System.out.print("\nMatriculation: " + matriculation + "\nSalary: " + salary + "\n");
    }

}
