package academiajava.jpa.DAO;

import academiajava.jpa.util.SessionUtil;
import academiajava.jpa.model.Projeto;
import java.util.List;

public class ProjetoDAO {

    public List<Projeto> findAll() {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.createQuery("SELECT p FROM Projeto p", Projeto.class).getResultList()
        );
    }

    public void save(Projeto projeto) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.persist(projeto);
        });
    }

    public void delete(Projeto projeto) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.remove(entityManager.contains(projeto) ? projeto : entityManager.merge(projeto));
        });
    }

    public Projeto findById(Long id) {
        return SessionUtil.inTransactionWithResult(entityManager ->
                entityManager.find(Projeto.class, id)
        );
    }

    public void update(Projeto projeto) {
        SessionUtil.inTransaction(entityManager -> {
            entityManager.merge(projeto);
        });
    }

}
