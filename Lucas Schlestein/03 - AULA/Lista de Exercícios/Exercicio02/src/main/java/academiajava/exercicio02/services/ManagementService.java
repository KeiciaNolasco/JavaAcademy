package academiajava.exercicio02.services;

import academiajava.exercicio02.entities.Administrator;
import academiajava.exercicio02.entities.Class;

import java.util.List;


public class ManagementService {

    public boolean authenticate(Administrator administrator, String input, String password) {
        return (input.equals(administrator.getEmail()) || input.equalsIgnoreCase(administrator.getName())) && password.equals(administrator.getPassword());
    }

    public void listStudents(List<Class> classes, String obj) {
        for (Class clazz : classes) {
            clazz.listStudents(obj);
        }
    }

    public void listStudents(List<Class> classes) {
        for (Class clazz : classes) {
            clazz.listStudents();
        }
    }


    public void listStudentsSeparately(List<Class> classes) {
        for (Class clazz : classes) {
            System.out.println("\nClass: " + clazz.getName() + " (" + clazz.getCode() + ")");
            clazz.listStudents();
        }
    }

}

