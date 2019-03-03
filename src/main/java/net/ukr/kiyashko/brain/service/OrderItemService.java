package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.model.Order;

import java.util.Date;
import java.util.List;

public interface OrderItemService {
    List<Order> findAll();

    List<Order> getList();

    Order findByEmail(String email);

    List<Order> findByPeriod(Date startDate, Date endDate);

    Order save(Order order);

    Order findByTelephon(int telephon);



}
