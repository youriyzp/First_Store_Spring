package net.ukr.kiyashko.brain.controller;


import net.ukr.kiyashko.brain.controller.form.OrderForm;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.User;
import net.ukr.kiyashko.brain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/order")
public class OrderController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private OrderService orderService;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/order")
    public ResponseEntity<?> AllOrderRepository() {

        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = {"/order"})
    public String listOrder(Model model) {

        model.addAttribute("order", orderService.getList());
        return "order";
    }

    @GetMapping(value = {"/addOrder"})
    public String addOrder(Model model) {

        OrderForm orderForm = new OrderForm();
        model.addAttribute("productForm", orderForm);
        return "addOrder";
    }

    //
    @PostMapping(value = {"/addOrder"})
    public String saveOrder(Model model, @ModelAttribute("orderForm") OrderForm orderForm, Object errorMessage) {

        Long id = orderForm.getId();
        User users = orderForm.getUsers();
        Date last_order = orderForm.getLast_order();
        Double summ = orderForm.getSumm();

        if (id != null && users != null ) {
            Order newOrder = new Order();
            newOrder.setId(id);
            newOrder.setUser(users);
            newOrder.setLast_order(last_order);
            newOrder.setSumm(summ);
            orderService.save(newOrder);

            return "redirect:/order";
        }
        model.addAttribute("errorOrderItemMessage", errorMessage);
        return "addOrder";
    }

}



