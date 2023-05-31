package br.com.islink.utils;

import java.io.Console;

import br.com.islink.views.Login;

public class ConsoleUtil {

    private static Console instance = null;

    private static final String TITLE = " _______ _______ _______ _     _      _______ _______ __   _ _______  ______ _______  ______\n    |    |_____| |______ |____/       |  |  | |_____| | \\  | |_____| |  ____ |______ |_____/\n    |    |     | ______| |    \\_      |  |  | |     | |  \\_| |     | |_____| |______ |    \\_";
    private static final int width = (TITLE.length() / 3) + 4;

    private ConsoleUtil() { }

    public static synchronized Console getInstance() {
        if (instance == null) {
            instance = System.console();
        }
        return instance;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printFrame() {
        printHorizontalBorder();
        printTitle();
    }

    public static void printHorizontalBorder() {
        String borderHorizon = "+" + "-".repeat(width - 1) + "+";
        System.out.println(borderHorizon);
    }

    public static void printVerticalBorder() {
        String borderVertical = "| " + " ".repeat(width - 3) + " |\n";
        System.out.print(borderVertical);
    }

    public static void printTitle() {
        System.out.println("| " + TITLE.substring(0, 92) + "  |");
        System.out.println("| " + TITLE.substring(93, 185) + "  |");
        System.out.println("| " + TITLE.substring(186, TITLE.length()) + "  |");
    }

    public static void printMessage(String message) {
        System.out.print("| " + message);
    }

    public static void printSpaces(int spaces) {
        System.out.print(" ".repeat(spaces));
        System.out.print("|\n");
    }

}