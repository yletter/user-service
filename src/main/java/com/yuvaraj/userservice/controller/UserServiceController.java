package com.yuvaraj.userservice.controller;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers() {
        return "User Service - List of Users";
    }
}
