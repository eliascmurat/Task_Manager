package br.com.islink.views;

import java.util.Objects;

import br.com.islink.models.User;
import br.com.islink.utils.KeyBoardUtil;
import br.com.islink.utils.LoginUtil;

public class Menu {
    
    private User user;

    public Menu(User user) {
        this.user = user;

        if (!Objects.isNull(user)) {
            this.navigateMenu();
        }
    }
    
    public void printMenu() {
        System.out.println("Selecione uma opção:");
        System.out.println("[1] - Opção 1");
        System.out.println("[2] - Opção 2");
        System.out.println("[3] - Opção 3");
        System.out.println("\n");
        System.out.println("[0] - Sair");
        System.out.println("\n");
        System.out.print("Digite sua opção: ");
    }

    public void navigateMenu() {
        int option;

        do {
            printMenu();
            option = KeyBoardUtil.waitChooseOption();
            
            switch (option) {
                case 1:
                    System.out.println("Opção 1 selecionada.");
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada.");
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada.");
                    break;
                case 0:
                    LoginUtil.signOut(user);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }

}
