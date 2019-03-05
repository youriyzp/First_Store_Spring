package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.model.Product;


import java.util.Date;
import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List<Product> getList();


    List<Product> findByPeriod(Date startDate, Date endDate);


    Product save(Product product);

    void delete(long id);
    Product editProduct(Product product);
    Product addProduct(Product product);




}
