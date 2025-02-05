package com.yuvaraj.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.security.SecureRandom;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers() {
        return "User Service - List of Users";
    }

    @GetMapping("/time/{number}")
    public String getUserOrders(@PathVariable int number) {
        System.out.println("Waiting for " + number + " seconds...");
        try {
            TimeUnit.SECONDS.sleep(number); // Sleeps for 10 minutes
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
        System.out.println("Done waiting!");
        return "User Service - Time - " + number;
    }

    @GetMapping("/cpu/{number}")
    public String getUserProfile(@PathVariable int number) {
        for (int i = 0; i < number; i++) {
            regexCall();
        }
        return "User Service - CPU";
    }

    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 @.";
    private final SecureRandom RANDOM = new SecureRandom();

    public String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public void regexCall() {
        String text = generateRandomString(100);

        // Compile regex pattern
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        // Create a matcher for the input text
        Matcher matcher = emailPattern.matcher(text);

        // Find and print all email addresses
        while (matcher.find()) {
            System.out.println("Found email: " + matcher.group());
        }
    }

}