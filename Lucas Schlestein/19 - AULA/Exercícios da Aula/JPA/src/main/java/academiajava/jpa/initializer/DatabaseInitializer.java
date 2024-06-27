package academiajava.jpa.initializer;

import academiajava.jpa.DAO.DepartamentoDAO;
import academiajava.jpa.DAO.FuncionarioDAO;
import academiajava.jpa.DAO.ProjetoDAO;
import academiajava.jpa.model.Departamento;
import academiajava.jpa.model.Funcionario;
import academiajava.jpa.model.Projeto;

public class DatabaseInitializer {

    public static void populateDatabase() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        Departamento deptTI = Departamento.builder().nome("Tecnologia da Informação").build();
        Departamento deptRH = Departamento.builder().nome("Recursos Humanos").build();
        departamentoDAO.save(deptTI);
        departamentoDAO.save(deptRH);

        Projeto projJ = Projeto.builder().nome("Projeto JPA").build();
        Projeto projH = Projeto.builder().nome("Projeto Hibernate").build();
        projetoDAO.save(projJ);
        projetoDAO.save(projH);

        Funcionario funcionario1 = Funcionario.builder()
                .nome("João Silva")
                .cargo("Desenvolvedor")
                .departamento(deptTI)
                .projeto(projJ)
                .build();

        Funcionario funcionario2 = Funcionario.builder()
                .nome("Maria Souza")
                .cargo("Analista de RH")
                .departamento(deptRH)
                .projeto(projH)
                .build();

        funcionarioDAO.save(funcionario1);
        funcionarioDAO.save(funcionario2);
    }

}
