package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    public static void insert(Genero genero) {
        String sql = "INSERT INTO generos (nome) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, genero.getNome());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    genero.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting genre failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting genre", e);
        }
    }

    public static void update(Genero genero) {
        String sql = "UPDATE generos SET nome = ? WHERE cod_gen = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, genero.getNome());
            ps.setInt(2, genero.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating genre", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM generos WHERE cod_gen = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting genre", e);
        }
    }

    public static Genero findById(int id) {
        String sql = "SELECT * FROM generos WHERE cod_gen = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Genero(rs.getInt("cod_gen"), rs.getString("nome"));
            } else {
                throw new NotFoundException("Genre not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding genre", e);
        }
    }

    public static List<Genero> findAll() {
        String sql = "SELECT * FROM generos";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Genero> generos = new ArrayList<>();
            while (rs.next()) {
                generos.add(new Genero(rs.getInt("cod_gen"), rs.getString("nome")));
            }
            return generos;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all genres", e);
        }
    }
}
