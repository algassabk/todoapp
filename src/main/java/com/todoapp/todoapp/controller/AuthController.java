package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/users")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "LOGIN HIT";
    }
}
