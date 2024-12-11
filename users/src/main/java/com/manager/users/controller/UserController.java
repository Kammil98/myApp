package com.manager.users.controller;

import com.manager.users.entity.UserModel;
import com.manager.users.entity.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<UserModel> getUsers() {
        return (List<UserModel>) userRepository.findAll();
    }

    @PostMapping("/save")
    void saveUser(@RequestBody UserModel user) {
        userRepository.save(user);
    }
}
