package academiajava.exercicio01;

public class User {

    private int userID;
    private String name;
    private String email;

    public User() {
    }

    public User(String nome, String email) {
        this.name = nome;
        this.email = email;
    }

    public User(int userID, String nome, String email) {
        this.userID = userID;
        this.name = nome;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}'+"\n";
    }
}
