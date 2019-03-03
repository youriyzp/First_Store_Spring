package net.ukr.kiyashko.brain.controller;

import net.ukr.kiyashko.brain.controller.form.UserForm;
import net.ukr.kiyashko.brain.controller.validation.UserValidator;
import net.ukr.kiyashko.brain.model.User;
import net.ukr.kiyashko.brain.service.UserService;
import net.ukr.kiyashko.brain.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller // Помечаем класс как контроллер обрабатывающий роутинг для стр. авторизации
public class AuthController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/registration"})
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());

        return "registration";
    }

//    @GetMapping({"/registration_admin"})
//    public String registrationAdmin(Model model) {
//        model.addAttribute("userFormAdmin", new UserForm());
//
//        return "registrationAdmin";
//    }
//
//    @PostMapping(value = "/registration_admin")
//    public String registrationAdmin(@ModelAttribute("userFormAdnin") UserForm userFormAdmin, BindingResult bindingResult, Model model) {
//        userValidator.validate(userFormAdmin, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registrationAdmin";
//        }
        //User newUser = new User();
        //newUser.setEmail(userFormAdmin.getEmail());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
       // userFormAdmin.setPassword(encoder.encode(userFormAdmin.getPassword()));
//        userService.save(newUser);
//
//        securityService.autoLogin(userFormAdmin.getEmail(), userFormAdmin.getPassword());
//        return "redirect:/index";
//    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User newUser = new User();
        newUser.setEmail(userForm.getEmail());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(userForm.getPassword()));
        userService.save(newUser);

        securityService.autoLogin(userForm.getEmail(), userForm.getPassword());
        return "redirect:/index";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}
