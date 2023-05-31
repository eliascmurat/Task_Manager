package br.com.islink.views;

import java.util.HashMap;
import java.util.Map;

import br.com.islink.utils.ConsoleUtil;

public class Login {

    private static boolean isLogged = false;
    private static String username;
    private static String password;

    public static void signIn() {
        while (!isLogged) {
            printLogin();
            clearCredentials();
            var userCredentials = getCredentials();
            
            if (isValidCredentials(userCredentials)) {
                printLoginSuccessfullyMessage();
                isLogged = true;
            } else {
                printLoginFailureMessage();
            }                
        }
    }
    
    public static void signOut() {
        ConsoleUtil.clearConsole();
        ConsoleUtil.printFrame();
    }

    private static void printLogin() {
        ConsoleUtil.getInstance().format("\033[1;1H");
        ConsoleUtil.printFrame();
        ConsoleUtil.printHorizontalBorder();

        ConsoleUtil.printMessage("Nome: ");
        ConsoleUtil.printSpaces(88);

        ConsoleUtil.printMessage("Senha: ");
        ConsoleUtil.printSpaces(87);

        ConsoleUtil.printHorizontalBorder();
    }

    private static Map<String, String> getCredentials() {
        ConsoleUtil.getInstance().format("\033[6;9H");
        username = ConsoleUtil.getInstance().readLine();

        ConsoleUtil.getInstance().format("\033[7;10H");
        char[] passwordArray = ConsoleUtil.getInstance().readPassword();
        password = new String(passwordArray);

        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("username", username);
        userCredentials.put("password", password);

        return userCredentials;
    }

    private static void clearCredentials() {
        username = "";
        password = "";
    }

    private static boolean isValidCredentials(Map<String, String> userCredentials) {
        String username = userCredentials.get("username");
        String password = userCredentials.get("password");

        return username.equals("admin") && password.equals("123456");
    }

    private static void printLoginSuccessfullyMessage() {
        ConsoleUtil.printHorizontalBorder();
        ConsoleUtil.printMessage("Bem-vindo, " + username + "!");
        ConsoleUtil.printSpaces(82 - username.length());
        ConsoleUtil.printHorizontalBorder();
    }

    private static void printLoginFailureMessage() {
        ConsoleUtil.printVerticalBorder();
        ConsoleUtil.printMessage("Nome de usuário ou senha incorretos! Tente novamente...");
        ConsoleUtil.printSpaces(39);
        ConsoleUtil.printHorizontalBorder();
    }

}
