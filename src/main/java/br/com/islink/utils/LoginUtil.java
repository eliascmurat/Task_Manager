package br.com.islink.utils;

import br.com.islink.models.User;

public class LoginUtil {

    private static LoginUtil instancia = null;
    private static User user;
    
    private LoginUtil() { }
    
    public static LoginUtil getInstancia() {
        if (instancia == null) {
            instancia = new LoginUtil();
        }
        
        return instancia;
    }

    public static void printLoginPage() {
        user = new User();
        user.setName(KeyBoardUtil.waitTypeText("Name: "));
        user.setPassword(KeyBoardUtil.waitTypeText("Password: "));

        if (KeyBoardUtil.waitConfirmOption("Precione [ENTER] para entrar...")) {
            signIn(user);
        }
    }

    public static void signIn(User user) {
        ConsoleUtil.clear();
        System.out.println("Welcome! " + user.getName());
        RouterUtil.loadMenuPage(user);
    }

    public static void signOut(User user) {
        ConsoleUtil.clear();
        System.out.println("Good Bye!" + user.getName());
        printLoginPage();
    }

}
