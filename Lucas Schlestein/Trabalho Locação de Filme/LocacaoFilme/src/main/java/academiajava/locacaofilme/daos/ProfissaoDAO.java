package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Profissao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDAO {

    public static void insert(Profissao profissao) {
        String sql = "INSERT INTO profissoes (nome) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, profissao.getNome());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    profissao.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting profession failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting profession", e);
        }
    }

    public static void update(Profissao profissao) {
        String sql = "UPDATE profissoes SET nome = ? WHERE cod_prof = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, profissao.getNome());
            ps.setInt(2, profissao.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating profession", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM profissoes WHERE cod_prof = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting profession", e);
        }
    }

    public static Profissao findById(int id) {
        String sql = "SELECT * FROM profissoes WHERE cod_prof = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Profissao(rs.getInt("cod_prof"), rs.getString("nome"));
            } else {
                throw new NotFoundException("Profession not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding profession", e);
        }
    }

    public static List<Profissao> findAll() {
        String sql = "SELECT * FROM profissoes";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Profissao> profissoes = new ArrayList<>();
            while (rs.next()) {
                profissoes.add(new Profissao(rs.getInt("cod_prof"), rs.getString("nome")));
            }
            return profissoes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all professions", e);
        }
    }
}