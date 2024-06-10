package academiajava.exercicio02.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Class {

    private Integer id;
    private String name;
    private String code;

    private List<Student> students = new ArrayList<>();

    public Class() {
    }

    public Class(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(id, aClass.id) && Objects.equals(name, aClass.name) && Objects.equals(code, aClass.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void listStudents(String obj) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(obj) ||
                    student.getRegistration().toString().equalsIgnoreCase(obj) ||
                    student.getId().toString().equalsIgnoreCase(obj)) {
                System.out.println(student);
            }
        }
    }

}
