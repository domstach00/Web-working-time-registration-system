package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.Login;
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
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<User> selectUsers(){
        return userService.selectUsers();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public User selectUser(@RequestParam int id) {
        return this.userService.selectUser(id);
    }

    @GetMapping("email")
    @CrossOrigin(origins = "http://localhost:8080")
    public User selectUser(@RequestParam String email) {
        return this.userService.selectUser(email);
    }

    @PostMapping("login")
    @CrossOrigin(origins = "http://localhost:8080")
    public User selectUser(@RequestBody Login login) {
        return this.userService.selectUser(login.getEmail(), login.getPassword());
    }

    @PostMapping("update")
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }
}
