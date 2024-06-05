package com.alvaro.curso.springboot.app.springbootcrud.services;

import java.util.List;

import com.alvaro.curso.springboot.app.springbootcrud.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);

}
