package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.DoctorDto;
import com.nikhil.springboot.MediConnect.dto.PatientDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public PatientDto addNewPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        return modelMapper.map(patientRepository.save(patient) , PatientDto.class);
    }
}
