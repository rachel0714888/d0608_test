package Ex1.util;

import com.iweb.exc.pojo.Product;
import com.iweb.exc.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Guan
 * @date 2023/5/19 8:55
 */
public class Data {
    private static List<User> userList;
    private static List<Product> productList;

    public static List<User> getUserList() {
        return userList;
    }
    static {
        init();
    }
    private static void init(){
        userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User("user"+i,"123456","user"+i+"@ikun.com"));
        }
        productList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            productList.add(new Ex1.pojo.Product(i,"product"+i,random.nextInt(100),random.nextInt(10)))
        }
    }
}
