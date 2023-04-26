package br.com.islink.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.islink.models.User;

public class UserDAO {
    
    private SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        executeInTransaction(session -> session.persist(user));
    }

    public void update(User user) {
        executeInTransaction(session -> session.update(user));
    }

    public void delete(User user) {
        executeInTransaction(session -> session.delete(user));
    }

    public User findById(Long id) {
        return executeWithSession(session -> session.get(User.class, id));
    }

    public List<User> findAll() {
        return executeWithSession(session -> session.createQuery("FROM User", User.class).list());
    }

    private void executeInTransaction(Consumer<Session> operation) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            operation.accept(session);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        
            throw ex;
        }
    }

    private <T> T executeWithSession(Function<Session, T> operation) {
        try (Session session = sessionFactory.openSession()) {
            return operation.apply(session);
        }
    }
}


