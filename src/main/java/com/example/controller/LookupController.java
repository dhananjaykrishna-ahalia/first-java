package com.example.controller;

import com.example.entity.Hobby;
import com.example.entity.Users;
import com.example.services.HobbyServices;
import com.example.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allows React (port 3000) to talk to Spring Boot (usually port 8080)
public class LookupController {

    private final UserServices userServices;
    private final HobbyServices hobbyServices;

    // Injecting the services that hold our mock data
    public LookupController(UserServices userServices, HobbyServices hobbyServices) {
        this.userServices = userServices;
        this.hobbyServices = hobbyServices;
    }

    // --- ENDPOINT 1: Get User by ID ---
    // Example URL: http://localhost:8080/api/users/101
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Users user = userServices.getUserById(id);

        if (user != null) {
            return ResponseEntity.ok(user); // Returns 200 OK with all user fields in JSON
        } else {
            return ResponseEntity.notFound().build(); // Returns 404 if the ID doesn't exist
        }
    }

    // --- ENDPOINT 2: Get Hobby by Name ---
    // Example URL: http://localhost:8080/api/hobbies/coding
    @GetMapping("/hobbies/{name}")
    public ResponseEntity<Hobby> getHobbyByName(@PathVariable String name) {
        Hobby hobby = hobbyServices.getHobbyByName(name);

        if (hobby != null) {
            return ResponseEntity.ok(hobby); // Returns 200 OK with all hobby fields in JSON
        } else {
            return ResponseEntity.notFound().build(); // Returns 404 if the hobby name doesn't exist
        }
    }
}