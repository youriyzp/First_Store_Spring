package net.ukr.kiyashko.brain.dao;



import net.ukr.kiyashko.brain.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@Repository // Помечаем класс как репозиторий
public interface OrderItemRepository  extends CrudRepository<OrderItem, Long> {

    /**
     * Переопределение метода из родительского интерфейса,
     * для возможности возвращать List.
     */
    @Override
    List<OrderItem> findAll();

    /**
     * Метод для поиска пользователя по email
     * Это так называемый "волшебный метод", т к называется по шаблону.
     * Для него будет автоматически создан запрос: select u from User u where email = ?
     */
    OrderItem findByEmail(String email);

    /**
     * Метод для поиска пользователей созданных за период времени.
     * Для него описан HQL запрос в @Query
     */
    @Query("select u from User u where u.creationDate between :startDate and :endDate")
    Stream<OrderItem> findUsersByPeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}


