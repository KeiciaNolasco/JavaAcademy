package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public static void insert(Endereco endereco) {
        String sql = "INSERT INTO enderecos (logradouro, tipo_log, complemento, cidade, uf, cep, numero, bairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getBairro());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    endereco.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting address failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting address", e);
        }
    }

    public static void update(Endereco endereco) {
        String sql = "UPDATE enderecos SET logradouro = ?, tipo_log = ?, complemento = ?, cidade = ?, uf = ?, cep = ?, numero = ?, bairro = ? WHERE cod_end = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getBairro());
            ps.setInt(9, endereco.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating address", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM enderecos WHERE cod_end = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting address", e);
        }
    }

    public static Endereco findById(int id) {
        String sql = "SELECT * FROM enderecos WHERE cod_end = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Endereco(rs.getInt("cod_end"), rs.getString("logradouro"), rs.getString("tipo_log"), rs.getString("complemento"),
                        rs.getString("cidade"), rs.getString("uf"), rs.getString("cep"), rs.getString("numero"), rs.getString("bairro"));
            } else {
                throw new NotFoundException("Address not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding address", e);
        }
    }

    public static List<Endereco> findAll() {
        String sql = "SELECT * FROM enderecos";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Endereco> enderecos = new ArrayList<>();
            while (rs.next()) {
                enderecos.add(new Endereco(rs.getInt("cod_end"), rs.getString("logradouro"), rs.getString("tipo_log"), rs.getString("complemento"),
                        rs.getString("cidade"), rs.getString("uf"), rs.getString("cep"), rs.getString("numero"), rs.getString("bairro")));
            }
            return enderecos;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all addresses", e);
        }
    }

}
