package academiajava.exercicio03;

public class Employee extends Person {

    public String sector;
    public String office;
    public String function;

    public Employee(String name, Integer age, Integer phone, String sector, String office, String function) {
        super(name, age, phone);
        this.sector = sector;
        this.office = office;
        this.function = function;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nAge: " + getAge() +
                "\nPhone: " + getPhone() +
                "\nSector: " + sector +
                "\nOffice: " + office +
                "\nFunction: " + function;
    }

}
