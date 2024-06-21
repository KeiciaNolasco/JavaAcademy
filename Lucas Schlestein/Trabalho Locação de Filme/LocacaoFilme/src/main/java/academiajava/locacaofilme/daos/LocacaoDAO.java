package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.exceptions.NotFoundException;
import academiajava.locacaofilme.models.Locacao;
import academiajava.locacaofilme.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO {

    public static void insert(Locacao locacao) {
        String sql = "INSERT INTO locacoes (data_loc, desconto, multa, sub_total, fk_cod_cli) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new java.sql.Date(locacao.getDataLocacao().getTime()));
            ps.setBigDecimal(2, locacao.getDesconto());
            ps.setBigDecimal(3, locacao.getMulta());
            ps.setBigDecimal(4, locacao.getSubTotal());
            ps.setInt(5, locacao.getCliente().getId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    locacao.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting rental failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting rental", e);
        }
    }

    public static void update(Locacao locacao) {
        String sql = "UPDATE locacoes SET data_loc = ?, desconto = ?, multa = ?, sub_total = ?, fk_cod_cli = ? WHERE cod_loc = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(locacao.getDataLocacao().getTime()));
            ps.setBigDecimal(2, locacao.getDesconto());
            ps.setBigDecimal(3, locacao.getMulta());
            ps.setBigDecimal(4, locacao.getSubTotal());
            ps.setInt(5, locacao.getCliente().getId());
            ps.setInt(6, locacao.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating rental", e);
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM locacoes WHERE cod_loc = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting rental", e);
        }
    }

    public static Locacao findById(int id) {
        String sql = "SELECT l.*, c.cod_cli AS cliente_id, c.cpf AS cliente_cpf, c.nome AS cliente_nome, c.telefone AS cliente_telefone FROM locacoes l " +
                "JOIN clientes c ON l.fk_cod_cli = c.cod_cli WHERE l.cod_loc = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("cliente_id"), rs.getString("cliente_cpf"), rs.getString("cliente_nome"), rs.getString("cliente_telefone"), null);
                return new Locacao(rs.getInt("cod_loc"), rs.getDate("data_loc"), rs.getBigDecimal("desconto"), rs.getBigDecimal("multa"), rs.getBigDecimal("sub_total"), cliente);
            } else {
                throw new NotFoundException("Rental not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding rental", e);
        }
    }

    public static List<Locacao> findAll() {
        String sql = "SELECT l.*, c.cod_cli AS cliente_id, c.cpf AS cliente_cpf, c.nome AS cliente_nome, c.telefone AS cliente_telefone FROM locacoes l " +
                "JOIN clientes c ON l.fk_cod_cli = c.cod_cli";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Locacao> locacoes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("cliente_id"), rs.getString("cliente_cpf"), rs.getString("cliente_nome"), rs.getString("cliente_telefone"), null);
                locacoes.add(new Locacao(rs.getInt("cod_loc"), rs.getDate("data_loc"), rs.getBigDecimal("desconto"), rs.getBigDecimal("multa"), rs.getBigDecimal("sub_total"), cliente));
            }
            return locacoes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all rentals", e);
        }
    }
}