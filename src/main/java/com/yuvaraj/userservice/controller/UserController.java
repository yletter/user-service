package com.yuvaraj.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public String getUsers() {
        return "User Service - List of Users";
    }

    @GetMapping("/time/{number}")
    public String getUserOrders(@PathVariable int number) {
        logger.info("Waiting for " + number + " seconds...");
        try {
            TimeUnit.SECONDS.sleep(number); // Sleeps for 10 minutes
        } catch (InterruptedException e) {
            logger.error("Sleep interrupted: " + e.getMessage());
        }
        logger.warn("Done waiting!");
        return "User Service - Time - " + number;
    }

    @GetMapping("/cpu/{number}")
    public String getCPU(@PathVariable int number) {
        logger.info("CPU for " + number + "...");
        CPU.main(number);
        return "User Service - CPU";
    }

    @GetMapping("/regex/{number}")
    public String getRegex(@PathVariable int number) {
        logger.info("Regex for " + number + "...");
        ArrayList<String> t = new ArrayList<String>(number);
        for (int i = 0; i < number; i++) {
            String text = regexCall();
            t.add(text);
        }
        return "User Service - Regex";
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

    public String regexCall() {
        String text = generateRandomString(30) + " " + generateRandomString(30) 
        + " " + generateRandomString(30);
        logger.info("The text: " + text);

        // Compile regex pattern
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

        // Create a matcher for the input text
        Matcher matcher = emailPattern.matcher(text);

        // Find and print all email addresses
        while (matcher.find()) {
            logger.info("Found email: " + matcher.group());
            text = text + " " + matcher.group();
        }
        return text;
    }

}