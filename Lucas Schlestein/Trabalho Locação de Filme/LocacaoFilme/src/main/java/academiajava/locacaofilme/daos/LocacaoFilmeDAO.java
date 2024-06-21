package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.models.LocacaoFilme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocacaoFilmeDAO {

    public static void insert(LocacaoFilme locacaoFilme) {
        String sql = "INSERT INTO locacoes_filmes (fk_cod_loc, fk_cod_filme, valor, num_dias, data_devol) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locacaoFilme.getLocacao().getId());
            ps.setInt(2, locacaoFilme.getFilme().getId());
            ps.setBigDecimal(3, locacaoFilme.getValor());
            ps.setInt(4, locacaoFilme.getNumeroDias());
            ps.setDate(5, new java.sql.Date(locacaoFilme.getDataDevolucao().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting rental film", e);
        }
    }

    public static void update(LocacaoFilme locacaoFilme) {
        String sql = "UPDATE locacoes_filmes SET valor = ?, num_dias = ?, data_devol = ? WHERE fk_cod_loc = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBigDecimal(1, locacaoFilme.getValor());
            ps.setInt(2, locacaoFilme.getNumeroDias());
            ps.setDate(3, new java.sql.Date(locacaoFilme.getDataDevolucao().getTime()));
            ps.setInt(4, locacaoFilme.getLocacao().getId());
            ps.setInt(5, locacaoFilme.getFilme().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating rental film", e);
        }
    }

    public static void deleteById(int locacaoId, int filmeId) {
        String sql = "DELETE FROM locacoes_filmes WHERE fk_cod_loc = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locacaoId);
            ps.setInt(2, filmeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting rental film", e);
        }
    }

    public static LocacaoFilme findById(int locacaoId, int filmeId) {
        String sql = "SELECT * FROM locacoes_filmes WHERE fk_cod_loc = ? AND fk_cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locacaoId);
            ps.setInt(2, filmeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LocacaoFilme(new LocacaoDAO().findById(rs.getInt("fk_cod_loc")),
                        new FilmeDAO().findById(rs.getInt("fk_cod_filme")),
                        rs.getBigDecimal("valor"),
                        rs.getInt("num_dias"),
                        rs.getDate("data_devol"));
            } else {
                throw new DatabaseException("Rental film not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding rental film", e);
        }
    }

    public static List<LocacaoFilme> findAll() {
        String sql = "SELECT * FROM locacoes_filmes";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<LocacaoFilme> locacaoFilmes = new ArrayList<>();
            while (rs.next()) {
                locacaoFilmes.add(new LocacaoFilme(new LocacaoDAO().findById(rs.getInt("fk_cod_loc")),
                        new FilmeDAO().findById(rs.getInt("fk_cod_filme")),
                        rs.getBigDecimal("valor"),
                        rs.getInt("num_dias"),
                        rs.getDate("data_devol")));
            }
            return locacaoFilmes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all rental films", e);
        }
    }
}
