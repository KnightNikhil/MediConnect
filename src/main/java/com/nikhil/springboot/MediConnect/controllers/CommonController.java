package com.nikhil.springboot.MediConnect.controllers;

import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import com.nikhil.springboot.MediConnect.services.PatientConsultationRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {

    @Autowired
    PatientConsultationRecordService patientConsultationRecordService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/getPatientConsultationRecordById/{id}")
    public ResponseEntity<PatientConsultationRecordDto> getPatientConsultationRecordById(@PathVariable Long id){
        return ResponseEntity.ok(modelMapper.map(patientConsultationRecordService.getPatientConsultationRecordById(id), PatientConsultationRecordDto.class));
    }

    @GetMapping("/getPatientConsultationRecordByPatientId/{patientId}")
    public ResponseEntity<List<PatientConsultationRecordDto>> getPatientConsultationRecordByPatientId(@PathVariable Long patientId){
        return ResponseEntity.ok(patientConsultationRecordService.getPatientConsultationRecordByPatientId(patientId));
    }

}
