package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.dao.ProductRepository;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.service.ProductService;
import net.ukr.kiyashko.brain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller // Помечаем класс как контроллер обрабатывающий REST запросы
@RequestMapping("/api/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    // Вводится (inject) из application.properties.
    @Value("${product.message}")
    private String message;

    @Value("${errorProduct.message}")
    private String errorMessage;

    @RequestMapping(value = {"Product"}, method = RequestMethod.GET)
    public String product(Model model) {

        model.addAttribute("message", message);
        return "product";
    }
// 3.0803.03.19 TODO next
//    @GetMapping(value = {"/list"})
//    public String personList(Model model) {
//
//        model.addAttribute("users", userService.getList());
//        return "list";
//    }
//
//    @GetMapping(value = {"/add"})
//    public String showAddPersonPage(Model model) {
//
//        UserForm userForm = new UserForm();
//        model.addAttribute("userForm", userForm);
//        return "add";
//    }
//
//    @PostMapping(value = {"/add"})
//    public String savePerson(Model model, @ModelAttribute("userForm") UserForm userForm) {
//
//        String login = userForm.getEmail();
//        String password = userForm.getPassword();
//
//        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
//            User newUser = new User();
//            newUser.setEmail(login);
//            newUser.setPassword(password);
//            newUser.setCreationDate(new Date());
//            userService.save(newUser);
//
//            return "redirect:/list";
//        }
//        model.addAttribute("errorProductMessage", errorMessage);
//        return "addProduct";
//    }

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private ProductRepository productRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/product")
    public ResponseEntity<List<Order>> AllProductRepository() {

        return (ResponseEntity<List<Order>>) productRepository.findAll();
    }
}
