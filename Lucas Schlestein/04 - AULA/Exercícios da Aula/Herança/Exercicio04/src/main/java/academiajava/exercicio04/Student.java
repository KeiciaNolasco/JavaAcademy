package academiajava.exercicio04;

public class Student extends Person {

    public String matriculation;

    public Student(String name, Integer RG, String matriculation) {
        super(name, RG);
        this.matriculation = matriculation;
    }

    public String getMatriculation() {
        return matriculation;
    }

    public void setMatriculation(String matriculation) {
        this.matriculation = matriculation;
    }

    @Override
    public void presentData() {
        super.presentData();
        System.out.print("\nMatriculation: " + matriculation + "\n");
    }

}
