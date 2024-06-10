package academiajava.exercicio02;

import java.util.Date;

public class Student {

    public String name;
    public Integer registration;
    public Date birth;
    public Integer year;


    public Student(String name, Integer registration) {
        this.name = name;
        this.registration = registration;
    }

    public Student(Date birth) {
        this.birth = birth;
    }

    public Student(String name, Date birth, Integer year) {
        this.name = name;
        this.birth = birth;
        this.year = year;
    }

    public Student(String name, Integer registration, Date birth, Integer year) {
        this.name = name;
        this.registration = registration;
        this.birth = birth;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
