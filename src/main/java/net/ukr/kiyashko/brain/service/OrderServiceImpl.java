package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.dao.OrderRepository;
import net.ukr.kiyashko.brain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service // Помечаем класс как сервис (применяеться паттерн фасад).
public class OrderServiceImpl implements OrderService {

    @Autowired // Иньектируем репозиторий в этот класс (Dependency Injection)
            OrderRepository orderRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

//    @Override
//    public List<Order> getList() {
//        return orderRepository.getList();
//    }

//    @Override
//    public Order findByEmail(String email) {
//        return orderRepository.findByEmail(email);
//    }

//    @Override
//    public List<Order> findByPeriod(Date startDate, Date endDate) {
//        return orderRepository.findByPeriod(startDate,endDate);
//    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

//    @Override
//    public Order findByTelephon(int telephon) {
//        return orderRepository.findByTelephon(telephon);
//    }
//
//    @Override
//    public void delete(long id) { orderRepository.delete(id);
//
//    }

//    @Override
//    public Order editOrder(Order order) {
//        return orderRepository.editOrder(order);
//    }
//
//    @Override
//    public Order addOrder(Order order) {
//        return orderRepository.addOrder(order);
//    }
}


