package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.dao.ProductRepository;
import net.ukr.kiyashko.brain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service // Помечаем класс как сервис (применяеться паттерн фасад).
public class ProductServiceImpl implements ProductService {

    @Autowired // Иньектируем репозиторий в этот класс (Dependency Injection)
            ProductRepository productRepository;

    @Override
    public List<Product> findAll(){return  productRepository.findAll();}
    @Override
    public List<Product> getList(){return productRepository.getList();}

    @Override
    public List<Product> findByPeriod(Date startDate, Date endDate) {
        return productRepository.findByPeriod(startDate, endDate);
    }

    @Override
    public Product save(Product product){return productRepository.save( product);}
    @Override
    public void delete(long id){productRepository.delete( id);

    }
    @Override
    public  Product editProduct(Product product){return productRepository.save(product);}

    @Override
    public Product addProduct(Product product) {
        Product savedProduct =  productRepository.save( product);

        return savedProduct;

    }

}


