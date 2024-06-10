package academiajava.exercicio01;

public class Person {

    public String name;
    public Integer age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if (name != null && age == null) {
            return "\nThe person's name is: " + name;
        }
        else if (name == null && age != null) {
            return "\nThe person's age is: " + age;
        }
        else if (name != null && age != null) {
            return "\nThe person's name is: " + name + "\nThe person's age is: " + age;
        }
        return "\nPerson class does not contain data";
    }

}