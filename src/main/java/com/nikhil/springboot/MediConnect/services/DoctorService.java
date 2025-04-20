package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.DoctorDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.Doctor;

public interface DoctorService {
    Doctor getDoctorById(Long id);

    DoctorDto addNewDoctor(DoctorDto doctorDto);
}
