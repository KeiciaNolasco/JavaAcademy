package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.models.ClienteEndereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteEnderecoDAO {

    public static void insert(ClienteEndereco clienteEndereco) {
        String sql = "INSERT INTO clientes_enderecos (fk_cod_end, fk_cod_cli) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, clienteEndereco.getEndereco().getId());
            ps.setInt(2, clienteEndereco.getCliente().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting client address", e);
        }
    }

    public static void update(ClienteEndereco clienteEndereco) {
        String sql = "UPDATE clientes_enderecos SET fk_cod_end = ?, fk_cod_cli = ? WHERE fk_cod_end = ? AND fk_cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, clienteEndereco.getEndereco().getId());
            ps.setInt(2, clienteEndereco.getCliente().getId());
            ps.setInt(3, clienteEndereco.getEndereco().getId());
            ps.setInt(4, clienteEndereco.getCliente().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating client address", e);
        }
    }

    public static void deleteById(int enderecoId, int clienteId) {
        String sql = "DELETE FROM clientes_enderecos WHERE fk_cod_end = ? AND fk_cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, enderecoId);
            ps.setInt(2, clienteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting client address", e);
        }
    }

    public static ClienteEndereco findById(int enderecoId, int clienteId) {
        String sql = "SELECT * FROM clientes_enderecos WHERE fk_cod_end = ? AND fk_cod_cli = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, enderecoId);
            ps.setInt(2, clienteId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ClienteEndereco(new EnderecoDAO().findById(rs.getInt("fk_cod_end")),
                        new ClienteDAO().findById(rs.getInt("fk_cod_cli")));
            } else {
                throw new DatabaseException("Client address not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding client address", e);
        }
    }

    public static List<ClienteEndereco> findAll() {
        String sql = "SELECT * FROM clientes_enderecos";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<ClienteEndereco> clienteEnderecos = new ArrayList<>();
            while (rs.next()) {
                clienteEnderecos.add(new ClienteEndereco(new EnderecoDAO().findById(rs.getInt("fk_cod_end")),
                        new ClienteDAO().findById(rs.getInt("fk_cod_cli"))));
            }
            return clienteEnderecos;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all client addresses", e);
        }
    }
}
