package br.com.islink.utils;

public class ConsoleUtil {
    
    private static final String TITULO = " _______ _______ _______ _     _      _______ _______ __   _ _______  ______ _______  ______\n    |    |_____| |______ |____/       |  |  | |_____| | \\  | |_____| |  ____ |______ |_____/\n    |    |     | ______| |    \\_      |  |  | |     | |  \\_| |     | |_____| |______ |    \\_";

    public static void clear() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   

    public static void initial() {
        System.out.print("\n" + TITULO + "\n");  
    }

}