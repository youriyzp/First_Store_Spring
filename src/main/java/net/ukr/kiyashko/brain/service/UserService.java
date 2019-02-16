package net.ukr.kiyashko.brain.service;


import net.ukr.kiyashko.brain.model.User;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс для взаимодействия с репозиторием.
 */
public interface UserService {

   // List<User> findAll();

    List<User> getList();

    User findByEmail(String email);

    List<User> findByPeriod(Date startDate, Date endDate);

    User save(User user);

    User findByTelephon(int telephon);




}

