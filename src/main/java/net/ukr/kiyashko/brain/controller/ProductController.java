package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.controller.form.ProductForm;
import net.ukr.kiyashko.brain.dao.ProductRepository;
import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.Product;
import net.ukr.kiyashko.brain.model.enums.UnitEnum;
import net.ukr.kiyashko.brain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = {"/listproduct"})
    public String personList(Model model) {

        model.addAttribute("product", productService.getList());
        return "listproduct";
    }

    @GetMapping(value = {"/addproduct"})
    public String showAddPersonPage(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);
        return "addproduct";
    }

    //
    @PostMapping(value = {"/addproduct"})
    public String saveProduct(Model model, @ModelAttribute("productForm") ProductForm productForm) {

        String name_product = productForm.getName_product();
        Double price_product = productForm.getPrice();
        UnitEnum unitEnum = productForm.getUnit();

        if (name_product != null && !name_product.isEmpty() && price_product != null && !price_product.isNaN()) {
            Product newProduct = new Product();
            newProduct.setName_product(name_product);
            newProduct.setPrice(price_product);
            productService.save(newProduct);

            return "redirect:/listproduct";
        }
        model.addAttribute("errorProductMessage", errorMessage);
        return "addProduct";
    }

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private ProductRepository productRepository;

    // Обработчик для запроса GET http://{host:port}/list
    @GetMapping(value = "/product")
    public ResponseEntity<List<Order>> AllProductRepository() {

        return (ResponseEntity<List<Order>>) productRepository.findAll();
    }
}
