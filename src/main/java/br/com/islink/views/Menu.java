package br.com.islink.views;

import br.com.islink.utils.ConsoleUtil;

public class Menu {

    public static void printMenu() {
        ConsoleUtil.printVerticalBorder();
        ConsoleUtil.printVerticalBorder();

        String text = "| Selecione uma opção: ";

        System.out.print(text);
        System.out.print(" ".repeat(text.length() + 50));
        System.out.println("|");

        String[] options = {
            "[1] - Opção 1", 
            "[2] - Opção 2", 
            "[3] - Opção 3",
            "[0] - Sair"
        };

        for (String option : options) {
            if (option.equals("[0] - Sair")) {
                ConsoleUtil.printVerticalBorder();
            }
            
            System.out.print("| " + option);
            System.out.println("|");
        }
    }

}
