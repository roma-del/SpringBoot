package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void edit(User user);
    void delete(Long id);
    List<User> findAll();
    User findById(Long id);
}
