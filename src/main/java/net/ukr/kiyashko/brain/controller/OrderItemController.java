package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.controller.form.OrderItemForm;
import net.ukr.kiyashko.brain.controller.form.ProductForm;
import net.ukr.kiyashko.brain.dao.OrderItemRepository;
import net.ukr.kiyashko.brain.dao.ProductRepository;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.OrderItem;
import net.ukr.kiyashko.brain.model.Product;
import net.ukr.kiyashko.brain.model.enums.UnitEnum;
import net.ukr.kiyashko.brain.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/orderItem")
public class OrderItemController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private OrderItemService orderItemService;
    @Value("${orderItemMessage.message}")
    private String message;

    @Value("$errorOrderItemMessage.message}")
    private String errorMessage;

    @RequestMapping(value = {"OrderItem"}, method = RequestMethod.GET)
    public String orderItem(Model model) {

        model.addAttribute("messageOrderItem", message);
        return "orderItem";
    }
    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/listOrderItem")
    public ResponseEntity<List<Order>> AllOrderItemRepository() {

        return (ResponseEntity<List<Order>>) orderItemService.findAll();
    }
//    @GetMapping(value = {"/listOrderItem"})
//    public String listOrderItem(Model model) {
//
//        model.addAttribute("orderItem",  orderItemService.getList());
//        return "listOrderItem";
//    }

    @GetMapping(value = {"/addListOrderItem"})
    public String showddListOrderItemPage(Model model) {

        OrderItemForm orderItemForm = new OrderItemForm();
        model.addAttribute("orderItemForm", orderItemForm);
        return "addListOrderItem";
    }

    //
    @PostMapping(value = {"/addListOrderItem"})
    public String saveorderItem(Model model, @ModelAttribute("orderItemForm") OrderItemForm orderItemForm) {

        Long id_orderItemForm = orderItemForm.getId();
        Product name_product = orderItemForm.getProduct();
        int count=orderItemForm.getCount();
//почему не работает проверка на пустое поле && count.isEmpty()
        if (count != 0 && count > 0 ) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setId(id_orderItemForm);
            newOrderItem.setProduct(name_product);
            newOrderItem.setCount(count);


            return "redirect:/listOrderItem";
        }
        model.addAttribute("errorOrderItemMessage", errorMessage);
        return "addListOrderItem";
    }




}
