package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.DoctorDto;
import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.DoctorRepository;
import com.nikhil.springboot.MediConnect.repository.PatientConsultationRecordRepository;
import com.nikhil.springboot.MediConnect.utils.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientConsultationRecordRepository patientConsultationRecordRepository;

    @Autowired
    PatientService patientService;
    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not found doctor with Id:: " + id));
    }

    @Override
    public DoctorDto addNewDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctor.setPassword(encodePassword(doctorDto.getPassword()));
        return modelMapper.map(doctorRepository.save(doctor) , DoctorDto.class);
    }


    @Override
    public PatientConsultationRecordDto addPatientConsultationRecord(PatientConsultationRecordDto patientConsultationRecordDto) {
        PatientConsultationRecord patientConsultationRecord = modelMapper.map(patientConsultationRecordDto, PatientConsultationRecord.class);
        patientConsultationRecord.setDoctor((Doctor) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Patient patient = patientService.getPatientById(patientConsultationRecordDto.getPatientId());
        patientConsultationRecord.setPatient(patient);
        patientConsultationRecord.setAge(CommonUtils.calculateAge(patient.getDateOfBirth()));
        patientConsultationRecord.setConsultancyDateTime(LocalDateTime.now());
        PatientConsultationRecord savedPatientConsultationRecord = patientConsultationRecordRepository.save(patientConsultationRecord);
        return modelMapper.map(savedPatientConsultationRecord, PatientConsultationRecordDto.class);
    }


}
