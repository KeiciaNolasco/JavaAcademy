package academiajava.exercicio05.services;

import academiajava.exercicio05.entities.Person;

public class IncomeTax {

    private Person person;

    public IncomeTax() {
    }

    public IncomeTax(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double calculate() {
        double salary = person.getSalary();
        int range = IncomeTaxBand.getRange(salary);
        double tax = 0;

        switch (range) {
            case 1:
                tax = 0;
                break;
            case 2:
                tax = (salary - 2112) * 0.075;
                break;
            case 3:
                tax = (2826.66 - 2112) * 0.075 + (salary - 2826.66) * 0.15;
                break;
            case 4:
                tax = (2826.66 - 2112) * 0.075 + (3751.06 - 2826.66) * 0.15 + (salary - 3751.06) * 0.225;
                break;
            case 5:
                tax = (2826.66 - 2112) * 0.075 + (3751.06 - 2826.66) * 0.15 + (4664.68 - 3751.06) * 0.225 + (salary- 4664.68) * 0.275;
                break;
        }
        return tax;
    }

    public void print() {
        double tax = calculate();
        int range = IncomeTaxBand.getRange(person.getSalary());
        System.out.printf("%s your salary is R$ %.2f, your tax bracket is %d nd the amount of income tax to be paid is: R$ %.2f%n",
                person.getName(), person.getSalary(), range, tax);
    }

}
