package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.dao.OrderItemRepository;
import net.ukr.kiyashko.brain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/order/item")
public class OrderItemController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private OrderItemRepository orderItemRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/listOrderItem")
    public ResponseEntity<List<Order>> AllOrderItemRepository() {

        return (ResponseEntity<List<Order>>) orderItemRepository.findAll();
    }


}
