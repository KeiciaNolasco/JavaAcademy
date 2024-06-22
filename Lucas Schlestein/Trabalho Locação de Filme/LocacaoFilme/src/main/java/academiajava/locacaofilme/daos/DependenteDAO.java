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

    public static void update(int dependenteId, String novoParentesco) {
        String sql = "UPDATE dependentes SET parentesco = ? WHERE fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, novoParentesco);
            ps.setInt(2, dependenteId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new DatabaseException("Dependent with ID " + dependenteId + " not found for update");
            }
            System.out.println("Dependent with ID " + dependenteId + " updated successfully");
        } catch (SQLException e) {
            throw new DatabaseException("Error updating dependent with ID " + dependenteId, e);
        }
    }

    public static void deleteById(int dependenteId) {
        String sql = "DELETE FROM dependentes WHERE fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dependenteId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new DatabaseException("Dependent with ID " + dependenteId + " not found for deletion");
            }
            System.out.println("Dependent with ID " + dependenteId + " successfully deleted");
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting dependent with ID " + dependenteId, e);
        }
    }

    public static Dependente findById(int dependenteId) {
        String sql = "SELECT * FROM dependentes WHERE fk_cod_dep = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dependenteId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dependente(
                        new ClienteDAO().findById(rs.getInt("fk_cod_cli")),
                        new ClienteDAO().findById(rs.getInt("fk_cod_dep")),
                        rs.getString("parentesco")
                );
            } else {
                throw new DatabaseException("Dependent with ID " + dependenteId + " not found");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error when searching for dependent with ID " + dependenteId, e);
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
