package academiajava.exercicio02.entities;

import java.util.Objects;

public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private Integer registration;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer registration) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registration = registration;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(registration, student.registration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, registration);
    }

    @Override
    public String toString() {
        return "Student {" +
                "name: " + name + '\'' +
                ", age: " + age +
                ", registration: " + registration + '}';
    }

}
