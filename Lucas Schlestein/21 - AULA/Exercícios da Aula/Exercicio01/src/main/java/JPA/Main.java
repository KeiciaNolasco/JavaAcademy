package JPA;

import JPA.model.Departamento;
import JPA.model.Funcionario;
import JPA.DAO.DepartamentoDAO;
import JPA.DAO.FuncionarioDAO;

public class Main {
    public static void main(String[] args) {

        // Inicializa os DAOs
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        // Cria e salva um departamento
        Departamento departamento = Departamento.builder()
                .nome("Expedição")
                .build();
        departamentoDAO.save(departamento);

        // Recupera o departamento salvo
        Departamento departamentoSalvo = departamentoDAO.findById(departamento.getId());

        // Cria e salva um funcionário
        Funcionario funcionario = Funcionario.builder()
                .nome("Lucas")
                .salario(1000.0)
                .departamento(departamentoSalvo)
                .build();
        funcionarioDAO.save(funcionario);

        // Recupera todos os funcionários
        var funcionarios = funcionarioDAO.findAll();
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        // Atualiza o funcionário
        funcionario.setSalario(1200.0);
        funcionarioDAO.update(funcionario);

        // Deleta o funcionário
        funcionarioDAO.delete(funcionario);

        // Recupera todos os departamentos
        var departamentos = departamentoDAO.findAll();
        for (Departamento d : departamentos) {
            System.out.println(d);
        }
    }
}