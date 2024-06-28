package academiajava.jpa.dao;

import academiajava.jpa.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;

public abstract class GenericDAO<T> {

    private final Class<T> entityClass;

    protected GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void persist(T entity) {
        executeInsideTransaction(session -> session.save(entity));
    }

    public void update(T entity) {
        executeInsideTransaction(session -> session.update(entity));
    }

    public void delete(T entity) {
        executeInsideTransaction(session -> session.delete(entity));
    }

    public T findById(int id) {
        try (Session session = JPAUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        }
    }

    public List<T> findAll() {
        try (Session session = JPAUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getName(), entityClass).list();
        }
    }

    private void executeInsideTransaction(Consumer<Session> action) {
        Transaction transaction = null;
        try (Session session = JPAUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            action.accept(session);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

}
