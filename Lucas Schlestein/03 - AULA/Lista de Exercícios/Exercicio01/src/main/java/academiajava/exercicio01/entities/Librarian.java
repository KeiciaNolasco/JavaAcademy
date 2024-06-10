package academiajava.exercicio01.entities;

import java.util.Objects;

public class Librarian {

    private Integer id;
    private String name;
    private String email;
    private String password;

    public Librarian() {
    }

    public Librarian(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Librarian librarian = (Librarian) obj;
        return Objects.equals(id, librarian.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
