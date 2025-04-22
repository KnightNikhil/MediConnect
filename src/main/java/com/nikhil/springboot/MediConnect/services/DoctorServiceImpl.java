package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.DoctorDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.User;
import com.nikhil.springboot.MediConnect.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DoctorRepository doctorRepository;

    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return null;
    }

    @Override
    public DoctorDto addNewDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctor.setPassword(encodePassword(doctorDto.getPassword()));
        return modelMapper.map(doctorRepository.save(doctor) , DoctorDto.class);
    }



}
