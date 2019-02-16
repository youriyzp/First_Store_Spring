package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.dao.ProductRepository;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/product")
public class ProductController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private ProductRepository productRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/list")
    public ResponseEntity<List<Order>> AllProductRepository() {

        return (ResponseEntity<List<Order>>) productRepository.findAll();
    }
}
