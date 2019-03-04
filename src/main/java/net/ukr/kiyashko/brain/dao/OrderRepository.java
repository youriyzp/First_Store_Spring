package net.ukr.kiyashko.brain.dao;

import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@Repository // Помечаем класс как репозиторий
public interface OrderRepository extends CrudRepository<Order, Long> {

    /**
     * Переопределение метода из родительского интерфейса,
     * для возможности возвращать List.
     */
    @Override
    List<Order> findAll();
    //List<Order> getList();

  //  Order findByEmail(String email);

    //List<Order> findByPeriod(Date startDate, Date endDate);

    Order save(Order order);

   // Order findByTelephon(int telephon);
   // void delete(long id);
//    Order editOrder(Order order);
//    Order addOrder(Order order);
    @Query("select u from User u where u.creationDate between :startDate and :endDate")
    Stream<User> findUsersByPeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


}


