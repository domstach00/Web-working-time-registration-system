package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.User;
import com.example.webworkingtimeregistrationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.selectAllUsers();
    }
}
