package JPA.DAO;

import JPA.model.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DepartamentoDAO {

    Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
    SessionFactory factory = cfg.buildSessionFactory();
    List<Departamento> departamentos = new ArrayList<>();
    Departamento departamento;

    static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            work.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public List<Departamento> findAll() {
        inSession(factory, entityManager -> {
            departamentos = entityManager.createQuery("select d from Departamento d", Departamento.class).getResultList();
        });
        return departamentos;
    }

    public void save(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.persist(departamento);
        });
    }

    public void delete(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.remove(departamento);
        });
    }

    public Departamento findById(int id) {
        inSession(factory, entityManager -> {
            departamento = entityManager.find(Departamento.class, id);
        });
        return departamento;
    }

    public void update(Departamento departamento) {
        inSession(factory, entityManager -> {
            entityManager.merge(departamento);
        });
    }
}