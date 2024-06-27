package academiajava.jpa.DAO;

import academiajava.jpa.util.SessionUtil;
import academiajava.jpa.model.Funcionario;
import java.util.List;

public class FuncionarioDAO {

    public List<Funcionario> findAll() {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList()
        );
    }

    public void save(Funcionario funcionario) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.persist(funcionario);
        });
    }

    public void delete(Funcionario funcionario) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.remove(entityManager.contains(funcionario) ? funcionario : entityManager.merge(funcionario));
        });
    }

    public Funcionario findById(Long id) {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.find(Funcionario.class, id)
        );
    }

    public void update(Funcionario funcionario) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.merge(funcionario);
        });
    }

    public List<Funcionario> findByDepartamento(Long departamentoId) {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.createQuery("FROM Funcionario f WHERE f.departamento.id = :departamentoId", Funcionario.class)
                        .setParameter("departamentoId", departamentoId).getResultList()
        );
    }

    public List<Funcionario> findByProjeto(Long projetoId) {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.createQuery("FROM Funcionario f WHERE f.projeto.id = :projetoId", Funcionario.class)
                        .setParameter("projetoId", projetoId).getResultList()
        );
    }

}
