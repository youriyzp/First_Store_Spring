package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.dao.OrderItemRepository;
import net.ukr.kiyashko.brain.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service // Помечаем класс как сервис (применяеться паттерн фасад).
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired // Иньектируем репозиторий в этот класс (Dependency Injection)
            OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

//    @Override
//    public List<OrderItem> getList() {
//        return orderItemRepository.getList();
//    }

    @Override
    public OrderItem findByEmail(String email) {
        return null;
    }

//    @Override
//    public List<OrderItem> findByPeriod(Date startDate, Date endDate) {
//        return orderItemRepository.findByPeriod(startDate, endDate);
//    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem findByTelephon(int telephon) {
        return null;
    }

//    @Override
//    public void delete(long id) {
//        orderItemRepository.delete(id);
//
//    }
//
//    @Override
//    public OrderItem editOrderItem(OrderItem orderItem) {
//        return orderItemRepository.save(orderItem);
//    }
//
//    @Override
//    public OrderItem addOrderItem(OrderItem orderItem) {
//        return orderItemRepository.save(orderItem);
//    }
//

}


