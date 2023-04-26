package br.com.islink.views;

import org.hibernate.SessionFactory;

import br.com.islink.dao.UserDAO;
import br.com.islink.models.User;

public class Login {
    public void teste(SessionFactory sessionFactory, User user) {
        UserDAO userDAO = new UserDAO(sessionFactory);
        userDAO.save(user);

        System.out.println("successfully login");
    }
}
