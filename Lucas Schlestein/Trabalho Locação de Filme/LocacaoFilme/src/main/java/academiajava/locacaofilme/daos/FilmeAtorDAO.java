package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.models.FilmeAtor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeAtorDAO {

    public static void insert(FilmeAtor filmeAtor) {
        String sql = "INSERT INTO filmes_atores (fk_cod_ator, fk_cod_filme, ator, diretor) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, filmeAtor.getAtor().getId());
            ps.setInt(2, filmeAtor.getFilme().getId());
            ps.setString(3, filmeAtor.getIsAtor() ? "S" : "N");
            ps.setString(4, filmeAtor.getIsDiretor() ? "S" : "N");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting film actor", e);
        }
    }

    public static void update(FilmeAtor filmeAtor) {
        String sql = "UPDATE filmes_atores SET ator = ?, diretor = ? WHERE fk_cod_ator = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, filmeAtor.getIsAtor() ? "S" : "N");
            ps.setString(2, filmeAtor.getIsDiretor() ? "S" : "N");
            ps.setInt(3, filmeAtor.getAtor().getId());
            ps.setInt(4, filmeAtor.getFilme().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating film actor", e);
        }
    }

    public static void deleteById(int atorId, int filmeId) {
        String sql = "DELETE FROM filmes_atores WHERE fk_cod_ator = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, atorId);
            ps.setInt(2, filmeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting film actor", e);
        }
    }

    public static FilmeAtor findById(int atorId, int filmeId) {
        String sql = "SELECT * FROM filmes_atores WHERE fk_cod_ator = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, atorId);
            ps.setInt(2, filmeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new FilmeAtor(new AtorDAO().findById(rs.getInt("fk_cod_ator")),
                        new FilmeDAO().findById(rs.getInt("fk_cod_filme")),
                        "S".equals(rs.getString("ator")),
                        "S".equals(rs.getString("diretor")));
            } else {
                throw new DatabaseException("Film actor not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding film actor", e);
        }
    }

    public static List<FilmeAtor> findAll() {
        String sql = "SELECT * FROM filmes_atores";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<FilmeAtor> filmeAtores = new ArrayList<>();
            while (rs.next()) {
                filmeAtores.add(new FilmeAtor(new AtorDAO().findById(rs.getInt("fk_cod_ator")),
                        new FilmeDAO().findById(rs.getInt("fk_cod_filme")),
                        "S".equals(rs.getString("ator")),
                        "S".equals(rs.getString("diretor"))));
            }
            return filmeAtores;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all film actors", e);
        }
    }
}
