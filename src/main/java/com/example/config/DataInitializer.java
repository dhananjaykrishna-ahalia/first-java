package com.example.config;

import com.example.entity.Hobby;
import com.example.entity.Users;
import com.example.services.HobbyServices;
import com.example.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    // We inject both services here so we can add data to them
    @Bean
    public CommandLineRunner loadData(UserServices userServices, HobbyServices hobbyServices) {
        return args -> {

            // --- 1. Initialize 5 Mock Users ---
            userServices.addUser(new Users(101, "Admin", "System Administrator with full access."));
            userServices.addUser(new Users(102, "Editor", "Content Editor for publishing articles."));
            userServices.addUser(new Users(103, "Viewer", "Guest Viewer with read-only access."));
            userServices.addUser(new Users(104, "Moderator", "Community Moderator for reviewing comments."));
            userServices.addUser(new Users(105, "Analyst", "Data Analyst for viewing traffic reports."));
            userServices.addUser(new Users(106, "Contributor", "Content Contributor for submitting articles."));

            System.out.println("✅ 5 Mock Users successfully loaded into UserServices!");

            // --- 2. Initialize 5 Mock Hobbies ---
            hobbyServices.addHobby(new Hobby("Reading", "Reading reduces stress by up to 68% and improves focus."));
            hobbyServices.addHobby(new Hobby("Coding", "Coding builds logical thinking and problem-solving skills."));
            hobbyServices.addHobby(new Hobby("Gaming", "Video games can enhance hand-eye coordination and reflexes."));
            hobbyServices.addHobby(new Hobby("Cooking", "Cooking is an art that encourages creativity and mindfulness."));
            hobbyServices.addHobby(new Hobby("Gardening", "Gardening improves mood, reduces anxiety, and provides physical exercise."));
            hobbyServices.addHobby(new Hobby("Traveling", "Traveling broadens horizons, fosters cultural understanding, and creates lasting memories."));

            System.out.println("✅ 5 Mock Hobbies successfully loaded into HobbyServices!");
        };
    }
}