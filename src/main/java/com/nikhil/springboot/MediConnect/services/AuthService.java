package com.nikhil.springboot.MediConnect.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.springboot.MediConnect.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    ModelMapper modelMapper;

//    @Autowired
//    JwtService jwtService;

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

    public UserDto loginPatient(UserDto userDto){

//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                userDto.getId(), userDto.getPassword()
//        ));
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

//        return modelMapper.map(userDetails, UserDto.class);

        return null;
    }



    public Object signUp(CreateUserRequest createUserRequest) {

        Object user =
        switch (createUserRequest.getRole().toUpperCase()){
            case "DOCTOR" -> doctorService.addNewDoctor(objectMapper.convertValue(createUserRequest.getData(), DoctorDto.class));
            case "PATIENT" -> patientService.addNewPatient((PatientDto) createUserRequest.getData());
            case "DIAGNOSIS_CENTRE" -> diagnosisCentreService.addNewDiagnosisCentre((DiagnosisCentreDto) createUserRequest.getData());
            default -> throw new RuntimeException("No valid role");
        };
        return user;
    }

}
