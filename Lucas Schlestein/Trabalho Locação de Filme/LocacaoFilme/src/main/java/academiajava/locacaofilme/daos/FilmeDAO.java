package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Filme;
import academiajava.locacaofilme.models.Categoria;
import academiajava.locacaofilme.models.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public static void insert(Filme filme) {
        String sql = "INSERT INTO filmes (titulo_original, titulo, quantidade, fk_cod_cat, fk_cod_gen) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, filme.getTituloOriginal());
            ps.setString(2, filme.getTitulo());
            ps.setInt(3, filme.getQuantidade());
            ps.setInt(4, filme.getCategoria().getId());
            ps.setInt(5, filme.getGenero().getId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    filme.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting film failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting film", e);
        }
    }

    public static void update(Filme filme) {
        String sql = "UPDATE filmes SET titulo_original = ?, titulo = ?, quantidade = ?, fk_cod_cat = ?, fk_cod_gen = ? WHERE cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, filme.getTituloOriginal());
            ps.setString(2, filme.getTitulo());
            ps.setInt(3, filme.getQuantidade());
            ps.setInt(4, filme.getCategoria().getId());
            ps.setInt(5, filme.getGenero().getId());
            ps.setInt(6, filme.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating film", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM filmes WHERE cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting film", e);
        }
    }

    public static Filme findById(int id) {
        String sql = "SELECT f.*, c.cod_cat AS categoria_id, c.nome AS categoria_nome, c.valor AS categoria_valor, " +
                "g.cod_gen AS genero_id, g.nome AS genero_nome FROM filmes f " +
                "JOIN categorias c ON f.fk_cod_cat = c.cod_cat " +
                "JOIN generos g ON f.fk_cod_gen = g.cod_gen WHERE f.cod_filme = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("categoria_id"), rs.getString("categoria_nome"), rs.getBigDecimal("categoria_valor"));
                Genero genero = new Genero(rs.getInt("genero_id"), rs.getString("genero_nome"));
                return new Filme(rs.getInt("cod_filme"), rs.getString("titulo_original"), rs.getString("titulo"), rs.getInt("quantidade"), categoria, genero);
            } else {
                throw new NotFoundException("Film not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding film", e);
        }
    }

    public static List<Filme> findAll() {
        String sql = "SELECT f.*, c.cod_cat AS categoria_id, c.nome AS categoria_nome, c.valor AS categoria_valor, " +
                "g.cod_gen AS genero_id, g.nome AS genero_nome FROM filmes f " +
                "JOIN categorias c ON f.fk_cod_cat = c.cod_cat " +
                "JOIN generos g ON f.fk_cod_gen = g.cod_gen";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Filme> filmes = new ArrayList<>();
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("categoria_id"), rs.getString("categoria_nome"), rs.getBigDecimal("categoria_valor"));
                Genero genero = new Genero(rs.getInt("genero_id"), rs.getString("genero_nome"));
                filmes.add(new Filme(rs.getInt("cod_filme"), rs.getString("titulo_original"), rs.getString("titulo"), rs.getInt("quantidade"), categoria, genero));
            }
            return filmes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all films", e);
        }
    }

}
