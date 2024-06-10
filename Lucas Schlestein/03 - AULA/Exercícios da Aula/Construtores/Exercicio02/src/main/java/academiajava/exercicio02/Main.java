package academiajava.exercicio02;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {

        Student student1 = new Student("Maria", 111);
        System.out.println("\nThe student's name is: " + student1.getName() + "\nThe student's registration is: " + student1.getRegistration());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Student student2 = new Student(sdf.parse("05/06/1992"));
        System.out.println("\nThe student's date of birth is: " + sdf.format(student2.getBirth()));

        Student student3 = new Student("Maria", sdf.parse("05/06/1992"), 2022);
        System.out.println("\nThe student's name is: " + student3.getName() + "\nThe student's date of birth is: " + sdf.format(student2.getBirth()) + "\nThe year the student started college is: " + student3.getYear());

    }
}