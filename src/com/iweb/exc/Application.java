package com.iweb.exc;

import com.iweb.exc.pojo.User;
import com.iweb.exc.view.MainView;

/**
 * @author Guan
 * @date 2023/5/19 9:37
 */
public class Application {
    public static User currentUser = null;
    public static void main(String[] args) {
        MainView.mainView();
    }
}
