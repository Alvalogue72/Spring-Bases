package com.alvaro.curso.springboot.webapp.springbootweb.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alvaro.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Álvaro", "López");
        user.setEmail("alvaro@gmail.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    } 
    /* public String details(Map<String, Object> model) {
        model.put("title", "Hola Mundo Spring Boot");
        model.put("name", "Álvaro");
        model.put("lastname", "López");
        return "details";
    } */

    @GetMapping("/list")
    public String list(ModelMap model) {

        /* List<User> users = Arrays.asList(
            new User("Pepa", "Gonzalez"),
            new User("Lalo", "Perez", "lalo@gmail.com"),
            new User("Juanita", "Doe", "juana@gmail.com"),
            new User("Alvaro", "Doe")); */

        model.addAttribute("title", "Listado de usuarios");
        // model.addAttribute("users", users);
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel() {

       return Arrays.asList(
            new User("Pepa", "Gonzalez"),
            new User("Lalo", "Perez", "lalo@gmail.com"),
            new User("Juanita", "Doe", "juana@gmail.com"),
            new User("Alvaro", "Doe"));

    }
    
}
