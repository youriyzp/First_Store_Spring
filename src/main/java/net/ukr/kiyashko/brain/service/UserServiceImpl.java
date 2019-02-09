package net.ukr.kiyashko.brain.service;

import net.ukr.kiyashko.brain.dao.UserRepository;
import net.ukr.kiyashko.brain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service // Помечаем класс как сервис (применяеться паттерн фасад).
public class UserServiceImpl implements UserService {

    @Autowired // Иньектируем репозиторий в этот класс (Dependency Injection)
            UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByPeriod(Date startDate, Date endDate) {
        return userRepository.findUsersByPeriod(startDate, endDate).collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}

