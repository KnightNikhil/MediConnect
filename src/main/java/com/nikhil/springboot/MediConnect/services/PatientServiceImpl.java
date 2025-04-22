package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.PatientConsultationRecordRepository;
import com.nikhil.springboot.MediConnect.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientConsultationRecordService patientConsultationRecordService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find patient with Id:: " + id));
    }

    @Override
    public PatientDto addNewPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        patient.setPassword(encodePassword(patientDto.getPassword()));
        return modelMapper.map(patientRepository.save(patient) , PatientDto.class);
    }

    @Override
    public List<PatientConsultationRecordDto> getPatientConsultationRecordBy() {
        return patientConsultationRecordService.getPatientConsultationRecordByPatientId(((Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
