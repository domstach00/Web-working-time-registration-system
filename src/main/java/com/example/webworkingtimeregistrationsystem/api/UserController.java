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
    public boolean insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @GetMapping("all")
    public List<User> selectUsers(){
        return userService.selectUsers();
    }

    @GetMapping
    public User selectUser(@RequestParam int id) {
        return this.userService.selectUser(id);
    }

    @GetMapping("email")
    public User selectUser(@RequestParam String email) {
        return this.userService.selectUser(email);
    }

    @GetMapping("login")
    public User selectUser(@RequestParam String email,
                           @RequestParam String password) {
        return this.userService.selectUser(email, password);
    }

    @PostMapping("update")
    public boolean updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }
}
