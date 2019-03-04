package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.model.OrderItem;
import net.ukr.kiyashko.brain.model.Product;

import java.util.Date;
import java.util.List;

public interface OrderItemService {
    List<OrderItem> findAll();

   // List<OrderItem> getList();

    OrderItem findByEmail(String email);

   // List<OrderItem> findByPeriod(Date startDate, Date endDate);

    OrderItem save(OrderItem orderItem);

    OrderItem findByTelephon(int telephon);



//    void delete(long id);
//    OrderItem editOrderItem(OrderItem orderItem);
//    OrderItem addOrderItem(OrderItem orderItem);

}
