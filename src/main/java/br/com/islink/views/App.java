package br.com.islink.views;

import org.hibernate.SessionFactory;

import br.com.islink.utils.ConsoleUtil;
import br.com.islink.utils.HibernateUtil;

public class App {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        openSessionFactory();
        
        ConsoleUtil.clearConsole();
        
        Login.signIn();

        // closeSessionFactory();
    }

    private static void openSessionFactory() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

}


