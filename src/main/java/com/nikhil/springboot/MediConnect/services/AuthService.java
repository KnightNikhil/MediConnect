package com.nikhil.springboot.MediConnect.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.entity.User;
import com.nikhil.springboot.MediConnect.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JwtService jwtService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DiagnosisCentreService diagnosisCentreService;

    @Autowired
    ObjectMapper objectMapper;

    public DoctorDto signUpDoctor(DoctorDto doctorDto){
        return doctorService.addNewDoctor(doctorDto);
    }

    public String login(UserDto userDto){


        //this is going to internally call loadByUsername created by us and validate the credentials
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getId(), userDto.getPassword()
        ));

//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return jwtService.createJwtToken(userDto);

    }


    public Object signUp(CreateUserRequest createUserRequest) {

        Object user =
        switch (createUserRequest.getRole().toUpperCase()){
            case "DOCTOR" -> doctorService.addNewDoctor(objectMapper.convertValue(createUserRequest.getData(), DoctorDto.class)) ;
            case "PATIENT" -> patientService.addNewPatient( objectMapper.convertValue(createUserRequest.getData(), PatientDto.class)) ;
            case "DIAGNOSIS_CENTRE" -> diagnosisCentreService.addNewDiagnosisCentre(objectMapper.convertValue(createUserRequest.getData(), DiagnosisCentreDto.class)) ;
            default -> throw new RuntimeException("No valid role");
        };
        return user;
    }

}
