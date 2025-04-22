package com.nikhil.springboot.MediConnect.controllers;

import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorsController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/addPatientConsultationRecord")
    public ResponseEntity<PatientConsultationRecordDto> addPatientConsultationRecord(@RequestBody PatientConsultationRecordDto patientConsultationRecordDto){
        return ResponseEntity.ok(doctorService.addPatientConsultationRecord(patientConsultationRecordDto));
    }

}

