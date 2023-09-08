package com.gotcha.main.controller;

import com.gotcha.main.entity.User;
import com.gotcha.main.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User create(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }
}
