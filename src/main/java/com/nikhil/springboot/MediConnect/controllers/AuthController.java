package com.nikhil.springboot.MediConnect.controllers;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping(value = "/signUp")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest createUserRequest){
        return new ResponseEntity<>(authService.signUp(createUserRequest), HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.login(userDto));
    }


}
