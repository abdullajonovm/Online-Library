package com.example.onlinekutubxona.controller;

import com.example.onlinekutubxona.dto.UserDto;
import com.example.onlinekutubxona.entity.Users;
import com.example.onlinekutubxona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userlar")
    public String userList(Model model){
        List<Users> usersList = userService.getAll();
        model.addAttribute("user_list", usersList);
        return "user_list";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        Users byId = userService.getById(id);
        model.addAttribute("user", byId);
        return "edit_user_page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model,Users users){
        userService.edit(id, users);
        return "redirect:/user/userlar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delet(id);
        return "redirect:/user/userlar";
    }

    @GetMapping("/save")
    public String savePage(Model model){
        UserDto users = new UserDto();
        model.addAttribute("user", users);
        return "user_save_page";
    }

    @PostMapping("/save")
    public String save(UserDto userDto){
        userService.save(userDto);
        return "user_page";
    }
}
