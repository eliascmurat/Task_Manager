package br.com.islink.views;

import org.hibernate.SessionFactory;

import br.com.islink.utils.ConsoleUtil;
import br.com.islink.utils.HibernateUtil;
import br.com.islink.utils.KeyBoardUtil;
import br.com.islink.utils.LoginUtil;

public class App {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Initialize Session
        openSessionFactory();
        KeyBoardUtil.openScanner();
        
        ConsoleUtil.clear();
        ConsoleUtil.printTitle();
        KeyBoardUtil.waitPressAnyKey("> Precione [ENTER] para iniciar");

        // Login Session
        LoginUtil.printLoginPage();

        // Close Session
        KeyBoardUtil.waitPressAnyKey("> Precione [ENTER] para sair");
        KeyBoardUtil.closeScanner();
        closeSessionFactory();
    }

    private static void openSessionFactory() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
    }

}
