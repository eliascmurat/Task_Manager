package br.com.islink.views;

import org.hibernate.SessionFactory;

import br.com.islink.models.User;
import br.com.islink.utils.ConsoleUtil;
import br.com.islink.utils.HibernateUtil;
import br.com.islink.utils.KeyBoardUtil;

public class App {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        openSessionFactory();

        ConsoleUtil.clear();
        ConsoleUtil.printTitle();
        
        KeyBoardUtil.openScanner();
        System.out.println("> Precione [ENTER] para fazer o login");
        
        KeyBoardUtil.waitPressAnyKey();
        ConsoleUtil.clear();
        
        User user = new User();
        user.setName("Elias");
        user.setBiography("Os sonhos das pessoas nunca tem fim.");
        Login login = new Login();
        login.signIn(user);

        System.out.println("> Precione [ENTER] para sair");
        KeyBoardUtil.waitPressAnyKey();
        
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
