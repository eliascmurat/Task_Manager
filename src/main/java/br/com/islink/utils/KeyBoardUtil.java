package br.com.islink.utils;

import java.util.Scanner;

public class KeyBoardUtil {
    
    private static Scanner scanner;

    public static void waitPressAnyKey() {
        scanner.nextLine();
    }

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        scanner.close();
    }

}
