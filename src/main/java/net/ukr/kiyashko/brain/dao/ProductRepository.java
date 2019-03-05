package net.ukr.kiyashko.brain.dao;

import net.ukr.kiyashko.brain.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@Repository // Помечаем класс как репозиторий
public interface ProductRepository extends CrudRepository<Product, Long> {



    /**
     * Переопределение метода из родительского интерфейса,
     * для возможности возвращать List.
     */
    @Override
    List<Product> findAll();

    List<Product> getList();

   List<Product> findByPeriod(Date startDate, Date endDate);

    Product save(Product product);
    void delete(long id);
    Product editProduct(Product product);
    Product addProduct(Product product);
}






