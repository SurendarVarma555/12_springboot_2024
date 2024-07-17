package com.usertask.app.controller;

import com.usertask.app.playload.UserDto;
import com.usertask.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){

        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById (@PathVariable("id") Long id){
        UserDto userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

}
