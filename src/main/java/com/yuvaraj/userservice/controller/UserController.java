package com.yuvaraj.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

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

    @GetMapping("/cpu")
    public String getUserProfile() {
        return "User Service - CPU";
    }

}