package com.connor.demo.controller;


import com.connor.demo.model.User;
import com.connor.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }


    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> login(//
                        @RequestBody User user) {
        return new ResponseEntity<>(userService.logIn(user), HttpStatus.OK);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody User user) {
        return userService.signUp(user);
    }

}