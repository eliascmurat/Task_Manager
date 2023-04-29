package br.com.islink.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    public List<User> findAll() {
        return executeWithSession(session -> session.createQuery("FROM User", User.class).list());
    }

    public User findById(Long id) {
        return executeWithSession(session -> session.get(User.class, id));
    }

    public void update(User user) {
        executeInTransaction(session -> session.update(user));
    }

    public void delete(User user) {
        executeInTransaction(session -> session.delete(user));
    }
    
    public User login(String name, String password) {
        return executeWithSession(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> root = criteria.from(User.class);

            criteria.select(root);
            criteria.where(builder.and(builder.equal(root.get("name"), name), builder.equal(root.get("password"), password)));
            
            TypedQuery<User> query = session.createQuery(criteria);
            
            try {
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        });
    }    

    private void executeInTransaction(Consumer<Session> operation) {
        Transaction transaction = null;
        Session session = null;
    
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            operation.accept(session);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private <T> T executeWithSession(Function<Session, T> operation) {
        try (Session session = sessionFactory.openSession()) {
            return operation.apply(session);
        }
    }

}
