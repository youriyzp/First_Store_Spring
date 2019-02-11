package net.ukr.kiyashko.brain.controller;


import net.ukr.kiyashko.brain.dao.OrderRepository;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api")
public class OrderController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private OrderRepository orderRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/list")
    public ResponseEntity<List<Order>>  AllOrderRepository() {

        return (ResponseEntity<List<Order>>) orderRepository.findAll();
    }
//    @GetMapping(value = "/list")
//    public ResponseEntity<List<Order>>  AllOrderRepository() {
//
//        return orderRepository.findByEmail(String email);
//
//    }

}



