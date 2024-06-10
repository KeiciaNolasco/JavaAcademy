package academiajava.exercicio02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User {

    private String name;
    private String email;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void recordData() throws IOException {
        String file = this.name + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Name: " + this.name + "\n");
            if (this.email != null) {
                writer.write("Email: " + this.email + "\n");
            }
        }
    }

    public static void readData(String name) throws IOException {
        String file = name + ".txt";
        Path path = Paths.get(file);
        Files.lines(path).forEach(System.out::println);
    }

}
