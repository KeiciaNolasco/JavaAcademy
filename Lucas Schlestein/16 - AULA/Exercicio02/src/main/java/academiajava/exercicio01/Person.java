package academiajava.exercicio01;

public class Person {
    private int personid;
    private String name;
    private String email;

    public Person(int personid, String name, String email) {
        this.personid = personid;
        this.name = name;
        this.email = email;
    }

    public Person(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Person() {
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personid=" + personid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}