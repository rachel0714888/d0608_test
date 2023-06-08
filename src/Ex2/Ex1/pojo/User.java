package Ex2.Ex1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
//    private float money;
//    private List<Order> orderList;

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
