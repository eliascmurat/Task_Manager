package br.com.islink.utils;

import java.util.Scanner;

public class KeyBoardUtil {
    
    private static Scanner scanner;

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static String waitTypeText() {
        return scanner.next();
    }

    public static String waitTypeText(String message) {
        ConsoleUtil.printMessage(message);
        return waitTypeText();
    }

    public static int waitChooseOption() {
        return scanner.nextInt();
    }

    public static int waitChooseOption(String message) {
        ConsoleUtil.printMessage(message);
        return waitChooseOption();
    }

    public static boolean waitConfirmOption() {
        String isConfirm = scanner.nextLine();
        return isConfirm.isEmpty();
    }

    public static boolean waitConfirmOption(String message) {
        ConsoleUtil.printMessage(message);
        return waitConfirmOption();
    }

    public static void waitPressAnyKey() {
        scanner.nextLine();
        ConsoleUtil.clear();
    }

    public static void waitPressAnyKey(String message) {
        ConsoleUtil.printMessage(message);
        waitPressAnyKey();
    }

}
