package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.OrderItem;


import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> findAll();

    List<Order> getList();

    Order findByEmail(String email);

    List<Order> findByPeriod(Date startDate, Date endDate);
    //List<OrderItem> findById();

    Order save(Order order);

    Order findByTelephon(int telephon);
    void delete(long id);
    Order editOrder(Order order);
    Order addOrder(Order order);


}
