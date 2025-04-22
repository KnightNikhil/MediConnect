package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.PatientConsultationRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class PatientConsultationRecordServiceImpl implements PatientConsultationRecordService {

    @Autowired
    PatientConsultationRecordRepository patientConsultationRecordRepository;

    @Autowired
    ModelMapper modelMapper;

    public PatientConsultationRecord getPatientConsultationRecordById(Long id) {
        return patientConsultationRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Consultation not found wth id::"+id));
    }

    @Override
    public List<PatientConsultationRecordDto> getPatientConsultationRecordByPatientId(Long patientId) {
        List<PatientConsultationRecord> patientConsultationRecords =  patientConsultationRecordRepository.findAllByPatientId(patientId);
        return patientConsultationRecords.stream().map(
                patientConsultationRecord -> modelMapper.map(patientConsultationRecord, PatientConsultationRecordDto.class))
                .toList();
    }
}
