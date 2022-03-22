package com.example.onlinekutubxona.controller;

import com.example.onlinekutubxona.dto.UserDto;
import com.example.onlinekutubxona.entity.Users;
import com.example.onlinekutubxona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute UserDto userDto) {
        Users users = userService.hasPhone(userDto.getPhone());
        if (users == null || !users.getPassword().equals(userDto.getPassword())) {
            return "index";
        }
        if (users.getIsAdmin()) {
            return "admin_page";
        }
        return "user_page";
    }
}
