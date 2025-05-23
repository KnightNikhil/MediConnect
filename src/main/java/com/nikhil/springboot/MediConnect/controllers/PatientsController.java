package com.nikhil.springboot.MediConnect.controllers;

import com.nikhil.springboot.MediConnect.dto.AppointmentDetailsDto;
import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.dto.CreateUserRequest;
import com.nikhil.springboot.MediConnect.services.AuthService;
import com.nikhil.springboot.MediConnect.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientsController {


    @Autowired
    PatientService patientService;

    @GetMapping("/getPatientConsultationRecord")
    public ResponseEntity<List<PatientConsultationRecordDto>> getPatientConsultationRecord(){
        return ResponseEntity.ok(patientService.getPatientConsultationRecordBy());
    }

    @PostMapping("/bookAppointment")
    public ResponseEntity<AppointmentDetailsDto> bookDoctorAppointment(@RequestBody AppointmentDetailsDto appointmentDetailsDto){
        return ResponseEntity.ok(patientService.bookDoctorAppointment(appointmentDetailsDto));
    }

    @PostMapping("/cancelAppointment")
    public ResponseEntity<AppointmentDetailsDto> cancelDoctorAppointment(@RequestBody AppointmentDetailsDto appointmentDetailsDto){
        return ResponseEntity.ok(patientService.cancelDoctorAppointment(appointmentDetailsDto));
    }

    @GetMapping("/findAllAppointments")
    public ResponseEntity<List<AppointmentDetailsDto>> findAllAppointments(){
        return ResponseEntity.ok(patientService.findAllAppointments());
    }

}
