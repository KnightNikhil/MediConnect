package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;
import com.nikhil.springboot.MediConnect.entity.DiagnosisReport;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.DiagnosisCentreRepository;
import com.nikhil.springboot.MediConnect.repository.DiagnosisReportsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiagnosisCentreServiceImpl implements DiagnosisCentreService {


    @Autowired
    DiagnosisCentreRepository diagnosisCentreRepository;

    @Autowired
    DiagnosisReportsRepository diagnosisReportsRepository;

    @Autowired
    PatientConsultationRecordService patientConsultationRecordService;

    @Autowired
    ModelMapper modelMapper;


    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public DiagnosisCentre getDiagnosisCentreById(Long id) {
        return diagnosisCentreRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Could not found diagnosis centre by id:: "+ id));
    }

    @Override
    public DiagnosisCentreDto addNewDiagnosisCentre(DiagnosisCentreDto diagnosisCentreDto) {
        DiagnosisCentre diagnosisCentre = modelMapper.map(diagnosisCentreDto, DiagnosisCentre.class);
        diagnosisCentre.setPassword(encodePassword(diagnosisCentreDto.getPassword()));
        return modelMapper.map(diagnosisCentreRepository.save(diagnosisCentre) , DiagnosisCentreDto.class);
    }

    @Override
    public DiagnosisReportDto addDiagnosisReports(DiagnosisReportDto diagnosisReportDto) {
        DiagnosisReport diagnosisReport = modelMapper.map(diagnosisReportDto, DiagnosisReport.class);
        DiagnosisCentre diagnosisCentre = (DiagnosisCentre) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        diagnosisReport.setDateTime(LocalDateTime.now());
        diagnosisReport.setDiagnosisCentre(diagnosisCentre);
        diagnosisReport.setPatientConsultationRecord(patientConsultationRecordService.getPatientConsultationRecordById(diagnosisReportDto.getPatientConsultationRecordId()));
        diagnosisReportsRepository.save(diagnosisReport);
        return modelMapper.map(diagnosisReport, DiagnosisReportDto.class);
    }
}
