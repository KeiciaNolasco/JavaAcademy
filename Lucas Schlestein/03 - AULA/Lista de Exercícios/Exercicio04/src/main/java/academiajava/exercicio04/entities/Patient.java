package academiajava.exercicio04.entities;

import java.util.Objects;

public class Patient {

    private Integer id;
    private String name;
    private Double weight;
    private Double height;

    public Patient() {
    }

    public Patient(Integer id, String name, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name + '\'' +
                ", weight: " + weight +
                ", height: " + height;
    }

}
