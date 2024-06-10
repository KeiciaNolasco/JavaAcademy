package academiajava.exercicio04;

public class Person {

    public String name;
    public Integer RG;

    public Person(String name, Integer RG) {
        this.name = name;
        this.RG = RG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRG() {
        return RG;
    }

    public void setRG(Integer RG) {
        this.RG = RG;
    }

    public void presentData() {
        System.out.print("\nName: " + name + "\nRG: " + RG);
    }

}
