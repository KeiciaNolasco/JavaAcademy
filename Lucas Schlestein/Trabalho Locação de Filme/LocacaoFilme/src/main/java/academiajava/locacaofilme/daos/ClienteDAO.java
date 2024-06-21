package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Cliente;
import academiajava.locacaofilme.models.Profissao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static void insert(Cliente cliente) {
        String sql = "INSERT INTO clientes (cpf, nome, telefone, fk_cod_prof) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            if (cliente.getProfissao() != null) {
                ps.setInt(4, cliente.getProfissao().getId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting client failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting client", e);
        }
    }

    public static void update(Cliente cliente) {
        String sql = "UPDATE clientes SET cpf = ?, nome = ?, telefone = ?, fk_cod_prof = ? WHERE cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            if (cliente.getProfissao() != null) {
                ps.setInt(4, cliente.getProfissao().getId());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setInt(5, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating client", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM clientes WHERE cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting client", e);
        }
    }

    public static Cliente findById(int id) {
        String sql = "SELECT c.*, p.cod_prof AS profissao_id, p.nome AS profissao_nome FROM clientes c " +
                "LEFT JOIN profissoes p ON c.fk_cod_prof = p.cod_prof WHERE c.cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Profissao profissao = new Profissao(rs.getInt("profissao_id"), rs.getString("profissao_nome"));
                return new Cliente(rs.getInt("cod_cli"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), profissao);
            } else {
                throw new NotFoundException("Client not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding client", e);
        }
    }

    public static List<Cliente> findAll() {
        String sql = "SELECT c.*, p.cod_prof AS profissao_id, p.nome AS profissao_nome FROM clientes c " +
                "LEFT JOIN profissoes p ON c.fk_cod_prof = p.cod_prof";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Profissao profissao = new Profissao(rs.getInt("profissao_id"), rs.getString("profissao_nome"));
                clientes.add(new Cliente(rs.getInt("cod_cli"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"), profissao));
            }
            return clientes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all clients", e);
        }
    }
}
