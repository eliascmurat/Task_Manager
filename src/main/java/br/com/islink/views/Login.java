package br.com.islink.views;

import br.com.islink.utils.ConsoleUtil;

public class Login {

    private static boolean isLogged = false;

    public static void signIn() {
        while (!isLogged) {
            ConsoleUtil.printVerticalBorder();

            ConsoleUtil.printMessage("Nome: ");
            ConsoleUtil.printSpaces(88);
            ConsoleUtil.getInstance().format("\033[6;9H");
            String username = ConsoleUtil.getInstance().readLine();

            ConsoleUtil.printMessage("Senha: ");
            ConsoleUtil.printSpaces(87);
            ConsoleUtil.getInstance().format("\033[7;10H");
            char[] passwordArray = ConsoleUtil.getInstance().readPassword();
            
            String password = new String(passwordArray);
        
            if (isValidLogin(username, password)) {
                isLogged = true;
                ConsoleUtil.printVerticalBorder();
                ConsoleUtil.printMessage("Bem-vindo, " + username + "!");
                ConsoleUtil.printSpaces(82 - username.length());
            } else {
                ConsoleUtil.printVerticalBorder();
                ConsoleUtil.printMessage("Nome de usuário ou senha incorretos.");
                ConsoleUtil.printSpaces(58);
                ConsoleUtil.printHorizontalBorder();

                ConsoleUtil.getInstance().readLine();
                ConsoleUtil.clearConsole();
                ConsoleUtil.printFrame();
            }                
        }
    }

    private static boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }

    public static void signOut() {
        
    }

}
