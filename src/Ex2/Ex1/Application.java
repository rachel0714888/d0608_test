package Ex2.Ex1;

import com.iweb.exc.pojo.User;
import com.iweb.exc.view.MainView;

/**
 * @auther Rachel
 * @date 2023/5/22 7:58
 */
public class Application {
    public static User currentUser = null;
    public static void main(String[] args) {
        MainView.mainView();
    }
}
