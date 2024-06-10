package academiajava.exercicio02;

public class Discipline {
    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.name = "Lucas Schlestein";

        Laboratory laboratory = new Laboratory();
        laboratory.locus = "Sala 2";

        System.out.println("The teacher's name is: " + teacher.name);
        System.out.println("The class location is: " + laboratory.locus);

    }
}