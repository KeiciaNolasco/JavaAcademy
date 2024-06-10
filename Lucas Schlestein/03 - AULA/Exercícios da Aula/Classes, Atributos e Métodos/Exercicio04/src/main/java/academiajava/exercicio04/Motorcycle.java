package academiajava.exercicio04;

public class Motorcycle {

    public String brand;
    public  String model;
    public  Integer cylinder;

    public Motorcycle() {
    }

    public Motorcycle(String brand, String model, Integer cylinder) {
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public void configureData(String motorcycleBrand, String motorcycleModel, Integer motorcycleCylinder) {
       brand = motorcycleBrand;
       model = motorcycleModel;
       cylinder = motorcycleCylinder;
    }

    public void displayData() {
        System.out.println("\nMotorcycle data: " + brand + " " + model + " " + cylinder);
    }

}
