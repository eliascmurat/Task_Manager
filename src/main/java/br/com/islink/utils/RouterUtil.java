package br.com.islink.utils;

import br.com.islink.models.User;
import br.com.islink.views.Menu;

public class RouterUtil {

    public static void loadMenuPage(User user) {
        Menu menu = new Menu(user);
    }

}
