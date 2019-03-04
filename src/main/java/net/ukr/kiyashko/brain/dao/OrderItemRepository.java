package net.ukr.kiyashko.brain.dao;


import net.ukr.kiyashko.brain.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository // Помечаем класс как репозиторий
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    /**
     * Переопределение метода из родительского интерфейса,
     * для возможности возвращать List.
     */
    @Override
    List<OrderItem> findAll();

  //  List<OrderItem> findByPeriod(Date startDate, Date endDate);

   // void delete(long id);

   // List<OrderItem> getList();
}


