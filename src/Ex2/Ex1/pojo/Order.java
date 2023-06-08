package Ex2.Ex1.pojo;

import com.iweb.exc.pojo.OrderDetail;

import java.util.List;

/**
 * 雪碧 1
 * @author Guan
 * @date 2023/5/19 13:39
 */
public class Order {
    private int id;
    private String orderCode;
    private String deliveryAddress;
    private List<OrderDetail> orderDetailList;
}
