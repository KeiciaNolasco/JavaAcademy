package academiajava.exercicio02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Commitment {

    private String name;
    private LocalDate date;
    private LocalTime hour;

    public Commitment(String name, LocalDate date, LocalTime hour) {
        this.name = name;
        this.date = date;
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter hourf = DateTimeFormatter.ofPattern("HH:mm");
        return "\nName: " + name + "\nDate: " + date.format(datef) + "\nHour: " + hour.format(hourf);
    }

}
