package net.ukr.kiyashko.brain.controller;


import net.ukr.kiyashko.brain.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/order")
public class OrderController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private OrderRepository orderRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/order")
    public ResponseEntity<?> AllOrderRepository() {

        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
//    @GetMapping(value = "/list")
//    public ResponseEntity<List<Order>>  AllOrderRepository() {
//
//        return orderRepository.findByEmail(String email);
//
//    }

}



