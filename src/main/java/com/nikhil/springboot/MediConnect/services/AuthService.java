package com.nikhil.springboot.MediConnect.services;

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

    public DoctorDto signUpDoctor(DoctorDto doctorDto){
        return doctorService.addNewDoctor(doctorDto);
    }

    public UserDto loginPatient(UserDto userDto){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getId(), userDto.getPassword()
        ));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return modelMapper.map(userDetails, UserDto.class);
    }


    public Object signUp(CreateUserRequest createUserRequest) {

        Object user =
        switch (createUserRequest.getRole().toUpperCase()){
            case "DOCTOR" -> doctorService.addNewDoctor((DoctorDto) createUserRequest.getData().get("details"));
            case "PATIENT" -> patientService.addNewPatient((PatientDto) createUserRequest.getData().get("details"));
            case "DIAGNOSIS_CENTRE" -> diagnosisCentreService.addNewDiagnosisCentre((DiagnosisCentreDto) createUserRequest.getData().get("details"));
            default -> throw new RuntimeException("No valid role");
        };
        return user;
    }

}
