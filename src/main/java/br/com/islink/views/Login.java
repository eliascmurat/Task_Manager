package br.com.islink.views;

import br.com.islink.utils.ConsoleUtil;

public class Login {

    private static boolean isLogged = false;

    public static void signIn() {
        String username = "";
        String password = "";

        while (!isLogged) {
            ConsoleUtil.printVerticalBorder();

            ConsoleUtil.printMessage("Nome: ");
            ConsoleUtil.printSpaces(88);

            ConsoleUtil.printMessage("Senha: ");
            ConsoleUtil.printSpaces(87);

            ConsoleUtil.printHorizontalBorder();

            ConsoleUtil.getInstance().format("\033[6;9H");
            username = ConsoleUtil.getInstance().readLine();

            ConsoleUtil.getInstance().format("\033[7;10H");
            char[] passwordArray = ConsoleUtil.getInstance().readPassword();
            
            password = new String(passwordArray);
            
            if (isValidLogin(username, password)) {
                isLogged = true;
                ConsoleUtil.printMessage("Bem-vindo, " + username + "!");
                ConsoleUtil.printSpaces(82 - username.length());
            } else {
                ConsoleUtil.getInstance().format("\033[8;1H");
                ConsoleUtil.printMessage("Nome de usuário ou senha incorretos! Pressione [Enter] para tentar novamente...");
                ConsoleUtil.printSpaces(15);
                ConsoleUtil.printHorizontalBorder();
                ConsoleUtil.getInstance().readLine();

                ConsoleUtil.clearConsole();
                ConsoleUtil.getInstance().format("\033[1;1H");
                ConsoleUtil.printFrame();
            }                
        }
    }
    
    public static void signOut() {
        ConsoleUtil.clearConsole();
        ConsoleUtil.printFrame();
    }

    private static boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("123456");
    }

}
