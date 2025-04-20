package com.nikhil.springboot.MediConnect.controllers;

import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.services.AuthService;
import com.nikhil.springboot.MediConnect.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientsController {


    @Autowired
    PatientService patientService;



}
