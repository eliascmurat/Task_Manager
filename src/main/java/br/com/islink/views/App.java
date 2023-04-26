package br.com.islink.views;

import org.hibernate.SessionFactory;

import br.com.islink.models.User;
import br.com.islink.utils.ConsoleUtil;
import br.com.islink.utils.HibernateUtil;

public class App {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        openSessionFactory();
        
        ConsoleUtil.clear();
        ConsoleUtil.initial();

        User user = new User();
        user.setName("Elias");
        user.setPassword("123456");

        Login login = new Login();
        login.teste(sessionFactory, user);

        closeSessionFactory();
    }

    private static void openSessionFactory() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

}
