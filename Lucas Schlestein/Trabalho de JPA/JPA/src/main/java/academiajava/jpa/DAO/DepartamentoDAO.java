package academiajava.jpa.DAO;

import academiajava.jpa.util.SessionUtil;
import academiajava.jpa.model.Departamento;
import java.util.List;

public class DepartamentoDAO {

    public List<Departamento> findAll() {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList()
        );
    }

    public void save(Departamento departamento) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.persist(departamento);
        });
    }

    public void delete(Departamento departamento) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.remove(entityManager.contains(departamento) ? departamento : entityManager.merge(departamento));
        });
    }

    public Departamento findById(Long id) {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.find(Departamento.class, id)
        );
    }

    public void update(Departamento departamento) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.merge(departamento);
        });
    }

}
