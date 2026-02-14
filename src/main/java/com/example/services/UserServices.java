package com.example.services;

import com.example.entity.Users;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServices {

    // This acts as our in-memory database table for Users
    private final Map<Integer, Users> userDatabase = new HashMap<>();

    // Method to save a user
    public void addUser(Users user) {
        userDatabase.put(user.getUserid(), user);
    }

    // Method to fetch a user
    public Users getUserById(int id) {
        return userDatabase.get(id);
    }
}