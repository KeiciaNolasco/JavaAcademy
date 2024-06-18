package academiajava.exercicio01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "----";

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        System.out.println("Foram deletadas " + deleteUser(1) + "linhas");
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("select * from Users")) {
            System.out.println("Conectado com sucesso!");
            System.out.println("A query afetou " + insertUser(new User("Novo User", "user@mail.com")) + "Linhas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("userid"),rs.getString("name"),rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar ao banco de dados");
        }
        System.out.println(users);
    }

    public static int insertUser(User u) {
        String query = "INSERT INTO Users (name, email) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            System.out.println("Conectado com sucesso!");
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados");
        }
        return 0;
    }

    public static int deleteUser(int id) {
        String query = "DELETE FROM Users WHERE UserID = ?;";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateUser(User user) {
        String query = "UPDATE User SET Name = ?, Email=? WHERE UserID = ?;";
        try (Connection con = DriverManager.getConnection(url, this.user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getUserID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}