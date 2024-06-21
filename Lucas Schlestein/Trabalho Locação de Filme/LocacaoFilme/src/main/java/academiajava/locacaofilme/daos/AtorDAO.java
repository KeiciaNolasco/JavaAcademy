package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Ator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtorDAO {

    public static void insert(Ator ator) {
        String sql = "INSERT INTO atores (nome) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ator.getNome());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    ator.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting actor failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting actor", e);
        }
    }

    public static void update(Ator ator) {
        String sql = "UPDATE atores SET nome = ? WHERE cod_ator = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ator.getNome());
            ps.setInt(2, ator.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating actor", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM atores WHERE cod_ator = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting actor", e);
        }
    }

    public static Ator findById(int id) {
        String sql = "SELECT * FROM atores WHERE cod_ator = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ator(rs.getInt("cod_ator"), rs.getString("nome"));
            } else {
                throw new NotFoundException("Actor not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding actor", e);
        }
    }

    public static List<Ator> findAll() {
        String sql = "SELECT * FROM atores";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Ator> atores = new ArrayList<>();
            while (rs.next()) {
                atores.add(new Ator(rs.getInt("cod_ator"), rs.getString("nome")));
            }
            return atores;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all actors", e);
        }
    }
}