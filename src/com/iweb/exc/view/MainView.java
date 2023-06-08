package com.iweb.exc.view;

import com.iweb.exc.Application;
import com.iweb.exc.controller.UserController;
import com.iweb.exc.pojo.User;
import com.iweb.exc.service.UserService;
import com.iweb.exc.util.Data;
import com.iweb.exc.util.Print;
import com.iweb.exc.util.StringUtil;

import java.util.Scanner;

/**
 * @author Guan
 * @date 2023/5/19 9:01
 */
public class MainView {
    private static Scanner sc = new Scanner(System.in);
    private static UserService userService = new UserService();

    public static void mainView() {
        Print.print("欢迎来到狗啃的系统");
        Print.print("请选择你想刚问的功能");
        Print.print("1.登录");
        Print.print("2.注册");
        String choose = sc.nextLine();
        //应该根据用户的输入的选择 跳转不到的页面
        //注意 需要控制异常输入的情况
        UserController.mainController(choose);
    }

    public static void loginView() {
        Print.print("请输入您的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        String randomConfirmCode = StringUtil.getRandomStr(4);
        Print.print("验证码为:" + randomConfirmCode);
        Print.print("请输入您的验证码");
        String inputConfirmCode = sc.nextLine();
        //调用业务类 进行登录的逻辑判断 根据业务类返回的boolean值结果决定
        //下一步如何实现
        //封装数据
        User inputUser = new User(inputUserName, inputPassword, null);
        userService.login(inputUser, randomConfirmCode, inputConfirmCode);

    }

    public static void userView() {
        Print.print("欢迎你,尊贵的用户,"+Application.currentUser.getUsername()+"请选择你要访问的功能");
        Print.print("1.查看用户信息");
        Print.print("2.修改用户信息");
        Print.print("3.退出登录");
        Print.print("4.注销用户");
        Print.print("5.返回主页面");
        String choose = sc.nextLine();
        UserController.userInfo(choose);
    }

    public static void registerView() {
        Print.print("请输入您的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        Print.print("请输入您的邮箱:");
        String inputEmail = sc.nextLine();
        //数据封装在User对象中
        User registerUser = new User(inputUserName, inputPassword, inputEmail);
        //将数据交给业务类的注册方法进行逻辑判断
        userService.register(registerUser);
    }

    public static void updateUser(){
        Print.print("输入修改之后的用户名:");
        String updateUsername = sc.nextLine();
        Print.print("输入修改之后的密码:");
        String updatePassword = sc.nextLine();
        Print.print("输入修改之后的邮箱:");
        String updateEmail = sc.nextLine();
        //确保修改之后的用户名和密码不能和已有用户重复 并且这个已有用户
        //不包括当前登录用户自己
        boolean flag = false;
        loop:
        for (User u: Data.getUserList()) {
            if(u== Application.currentUser){
                continue loop;
            }else {
                if(u.getUsername().equals(updateUsername)
                        ||u.getPassword().equals(updatePassword)){
                    flag = true;
                    break loop;
                }
            }
        }
        if(!flag){
            Application.currentUser.setUsername(updateUsername);
            Application.currentUser.setPassword(updatePassword);
            Application.currentUser.setEmail(updateEmail);
            MainView.userView();
        }else {
            Print.print("重新输入修改信息!");
            MainView.updateUser();
        }
    }


}
