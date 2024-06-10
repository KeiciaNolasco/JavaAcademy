package academiajava.exercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalVehicles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the vehicle manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter the vehicle model: ");
        String model = scanner.nextLine();

        Car car = new Car();
        car.configureData(manufacturer, model);

        System.out.print("\nEnter the brand of the motorcycle 01: ");
        String brand1 = scanner.nextLine();
        System.out.print("Enter the motorcycle 01 model: ");
        String model1 = scanner.nextLine();
        System.out.print("Enter the number of cylinders of the motorcycle 01: ");
        Integer cylinders1 = scanner.nextInt();

        Motorcycle motorcycle1 = new Motorcycle();
        motorcycle1.configureData(brand1, model1, cylinders1);

        scanner.nextLine();
        System.out.print("\nEnter the brand of the motorcycle 02: ");
        String brand2 = scanner.nextLine();
        System.out.print("Enter the motorcycle 02 model: ");
        String model2 = scanner.nextLine();
        System.out.print("Enter the number of cylinders of the motorcycle 02: ");
        Integer cylinders2 = scanner.nextInt();
        scanner.nextLine();

        Motorcycle motorcycle2 = new Motorcycle();
        motorcycle2.configureData(brand2, model2, cylinders2);

        car.displayData();
        motorcycle1.displayData();
        motorcycle2.displayData();

    }
}