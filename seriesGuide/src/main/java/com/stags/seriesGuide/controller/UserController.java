package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.entity.User;
import com.stags.seriesGuide.models.UserRequest;
import com.stags.seriesGuide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public User addUser(@RequestBody UserRequest user){
        return service.saveUser(user);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return service.getUserById(id);
    }

}
