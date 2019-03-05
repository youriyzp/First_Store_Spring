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

    @RequestMapping(value = {"product"}, method = RequestMethod.GET)
    public String product(Model model) {

        model.addAttribute("message", message);
        return "product";
    }

    @GetMapping(value = {"/listProduct"})
    public String listProduct(Model model) {

        model.addAttribute("product", productService.getList());
        return "listProduct";
    }

    @GetMapping(value = {"/add"})
    public String addProduct(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);
        return "addProduct";
    }

    //
    @PostMapping(value = {"/add"})
    public String saveProduct(Model model, @ModelAttribute("productForm") ProductForm productForm) {

        String name_product = productForm.getName_product();
        Double price_product = productForm.getPrice();
        UnitEnum unitEnum = productForm.getUnit();

        if (name_product != null && !name_product.isEmpty() && price_product != null && !price_product.isNaN()) {
            Product newProduct = new Product();
            newProduct.setName_product(name_product);
            newProduct.setPrice(price_product);
            newProduct.setUnit(unitEnum);
            productService.save(newProduct);

            return "redirect:/listProduct";
        }
        model.addAttribute("errorProductMessage", errorMessage);
        return "addProduct";
    }


//    @GetMapping(value = "/product")
//    public ResponseEntity<List<Product>> productService() {
//
//        return ResponseEntity List<Product> productService.findAll();
//    }
}
