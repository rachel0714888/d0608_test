package Ex2.Ex1.service;

import com.iweb.exc.Application;
import com.iweb.exc.pojo.User;
import com.iweb.exc.util.Data;
import com.iweb.exc.util.Print;
import com.iweb.exc.view.MainView;

import java.util.List;

/**
 * @author Guan
 * @date 2023/5/19 9:22
 */
public class UserService {
    public void register(User registerUser){
        //注册的逻辑 遍历用户集合 如果发现了重复用户名和密码 就让用户重新注册
        //如果没有发现 则userList存入这个新的对象
        List<User> userList = Data.getUserList();
        boolean flag = false;
        loop:
        for (User u:userList) {
            if(u.getEmail().equals(registerUser.getEmail())||
            u.getUsername().equals(registerUser.getUsername())){
                flag = true;
                break loop;
            }
        }
        if(!flag){
            userList.add(registerUser);
            Print.print("恭喜你,注册成功,即将跳转到主界面,请稍后...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainView.mainView();
        }else{
            Print.print("注册失败,请重新输入用户信息!");
            MainView.mainView();
        }
    }
    public void login(User inputUser, String randomConfirmCode, String inputConfirmCode) {
        if (!randomConfirmCode.equalsIgnoreCase(inputConfirmCode)) {
            Print.print("验证码输入错误,请重新登录!");
            MainView.loginView();
            return;
        } else {
            //进行用户的比较
            //遍历用户集合 如果能够找到对应的用户名和密码 则验证登录成功 进入后续页面
            //否则登录失败
            boolean success = false;
            //获取用户集合
            List<User> userList = Data.getUserList();
            loop:
            for (User u : userList) {
                if (u.equals(inputUser)) {
                    success = true;
                    //将所登录用户的对象的内存地址 存储到currentUser中
                    Application.currentUser = u;
                    break loop;
                }
            }
            if (success) {

                //进入到下一个页面
                MainView.userView();
            } else {
                //回到登录页面重新输入
                Print.print("输入有误,请重新输入!");
                MainView.loginView();
            }
        }
    }
}
