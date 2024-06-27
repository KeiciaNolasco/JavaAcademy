package academiajava.jpa.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class SessionUtil {

    public static void inTransaction(Consumer<Session> action) {
        Session session = JPAUtil.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            action.accept(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static <R> R inTransactionWithResult(Function<Session, R> action) {
        Session session = JPAUtil.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            R result = action.apply(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
