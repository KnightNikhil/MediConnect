package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.dto.PatientDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.Patient;

public interface PatientService {
    Patient getPatientById(Long id);

    PatientDto addNewPatient(PatientDto patientDto);
}
