package Ex1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Guan
 * @date 2023/5/19 8:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String email;
    private int money;
    private List<Order> orderList;
//    private float money;
//    private List<Order> orderList;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.money = 0;
        this.orderList = null;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(o instanceof User){
            User anotherUser = (User)o;
            return username.equals(anotherUser.username)&&password.equals(anotherUser.password);
        }else {
            return false;
        }
    }

}
