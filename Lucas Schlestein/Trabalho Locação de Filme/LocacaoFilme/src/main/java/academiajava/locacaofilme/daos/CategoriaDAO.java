package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public static void insert(Categoria categoria) {
        String sql = "INSERT INTO categorias (nome, valor) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, categoria.getNome());
            ps.setBigDecimal(2, categoria.getValor());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting category failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting category", e);
        }
    }

    public static void update(Categoria categoria) {
        String sql = "UPDATE categorias SET nome = ?, valor = ? WHERE cod_cat = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, categoria.getNome());
            ps.setBigDecimal(2, categoria.getValor());
            ps.setInt(3, categoria.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating category", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM categorias WHERE cod_cat = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting category", e);
        }
    }

    public static Categoria findById(int id) {
        String sql = "SELECT * FROM categorias WHERE cod_cat = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Categoria(rs.getInt("cod_cat"), rs.getString("nome"), rs.getBigDecimal("valor"));
            } else {
                throw new NotFoundException("Category not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding category", e);
        }
    }

    public static List<Categoria> findAll() {
        String sql = "SELECT * FROM categorias";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Categoria> categorias = new ArrayList<>();
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt("cod_cat"), rs.getString("nome"), rs.getBigDecimal("valor")));
            }
            return categorias;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all categories", e);
        }
    }
}
