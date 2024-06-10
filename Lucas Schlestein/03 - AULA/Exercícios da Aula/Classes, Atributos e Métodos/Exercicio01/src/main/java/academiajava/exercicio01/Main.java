package academiajava.exercicio01;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.age = 18;
        person2.age = 25;
        person3.age = 23;

        System.out.println("Person 1's age is: " + person1.age);
        System.out.println("Person 2's age is: " + person2.age);
        System.out.println("Person 3's age is: " + person3.age);

    }
}