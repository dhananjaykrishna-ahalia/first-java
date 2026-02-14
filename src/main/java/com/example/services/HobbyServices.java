package com.example.services;

import com.example.entity.Hobby;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HobbyServices {

    // This acts as our in-memory database table for Hobbies
    private final Map<String, Hobby> hobbyDatabase = new HashMap<>();

    // Method to save a hobby
    public void addHobby(Hobby hobby) {
        // Storing by lowercase name so it's easier to search later
        hobbyDatabase.put(hobby.getHobbyName().toLowerCase(), hobby);
    }

    // Method to fetch a hobby
    public Hobby getHobbyByName(String name) {
        return hobbyDatabase.get(name.toLowerCase());
    }
}