package Ex1.controller;

import com.iweb.exc.Application;
import com.iweb.exc.util.Data;
import com.iweb.exc.util.Print;
import com.iweb.exc.view.MainView;

/**
 * @author Guan
 * @date 2023/5/19 9:14
 */
public class UserController {
    public static void mainController(String choose) {
        switch (choose) {
            case "1":
                //跳转到登录视图
                MainView.loginView();
                break;
            case "2":
                //跳转到注册视图
                MainView.registerView();
                break;
            default:
                Print.print("输入异常,请重新输入");
                MainView.mainView();
        }
    }

    public static void userInfo(String choose) {
        switch (choose) {
            case "1":
                Print.print("用户信息如下:");
                Print.print(Application.currentUser.toString());
                MainView.userView();
                break;
            case "2":
                Print.print("即将跳转修改用户信息界面...");
                MainView.updateUser();
                break;
            case "3":
                //清空currentUser 返回主页面
                Application.currentUser = null;
                MainView.mainView();
                break;
            case "4":
                Data.getUserList().remove(Application.currentUser);
                Application.currentUser = null;
                MainView.mainView();
                break;
            case "5":
                Print.print("正在返回主页面...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MainView.mainView();
                break;
            default:
        }
    }
}
