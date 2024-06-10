package academiajava.exercicio03;

public class Car {

    public String manufacturer;
    public String model;

    public Car() {
    }

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void  configureData(String manufacturerCar, String modelCar) {
        manufacturer = manufacturerCar;
        model = modelCar;
    }

    public void  displayData() {
        System.out.println("Car data: " + manufacturer + " " + model);
    }

}
