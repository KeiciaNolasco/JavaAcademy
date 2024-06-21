package academiajava.locacaofilme.daos;

import academiajava.locacaofilme.configs.DatabaseConfig;
import academiajava.locacaofilme.exceptions.DatabaseException;
import academiajava.locacaofilme.models.Cliente;
import academiajava.locacaofilme.models.Dependente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {

    public static void insert(Dependente dependente) {
        String sql = "INSERT INTO dependentes (fk_cod_cli, fk_cod_dep, parentesco) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dependente.getCliente().getId());
            ps.setInt(2, dependente.getDependente().getId());
            ps.setString(3, dependente.getParentesco());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting dependent", e);
        }
    }

    public static void update(Dependente dependente) {
        String sql = "UPDATE dependentes SET parentesco = ? WHERE fk_cod_cli = ? AND fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dependente.getParentesco());
            ps.setInt(2, dependente.getCliente().getId());
            ps.setInt(3, dependente.getDependente().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error updating dependent", e);
        }
    }

    public static void deleteById(int dependenteId) {
        String sql = "DELETE FROM dependentes WHERE fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dependenteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting dependent", e);
        }
    }

    public static Dependente findById(int dependenteId) {
        String sql = "SELECT * FROM dependentes WHERE fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dependenteId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Dependente encontrado no banco de dados.");
                Cliente cliente = new ClienteDAO().findById(rs.getInt("fk_cod_cli"));
                Cliente dependenteCliente = new ClienteDAO().findById(rs.getInt("fk_cod_dep"));
                return new Dependente(cliente, dependenteCliente, rs.getString("parentesco"));
            } else {
                System.out.println("Dependente não encontrado.");
                throw new DatabaseException("Dependent not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Error finding dependent", e);
        }
    }

    public static List<Dependente> findAll() {
        String sql = "SELECT * FROM dependentes";
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            List<Dependente> dependentes = new ArrayList<>();
            while (rs.next()) {
                dependentes.add(new Dependente(new ClienteDAO().findById(rs.getInt("fk_cod_cli")),
                        new ClienteDAO().findById(rs.getInt("fk_cod_dep")),
                        rs.getString("parentesco")));
            }
            return dependentes;
        } catch (SQLException e) {
            throw new DatabaseException("Error finding all dependents", e);
        }
    }
}
