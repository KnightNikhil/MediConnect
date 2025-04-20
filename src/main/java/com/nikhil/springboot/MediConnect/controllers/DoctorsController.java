//package com.nikhil.springboot.MediConnect.controllers;
//
//import com.nikhil.springboot.MediConnect.repository.PatientDetailsRepo;
//import com.nikhil.springboot.MediConnect.repository.PatientsMedicalDetailsRepo;
//import com.nikhil.springboot.MediConnect.services.LoginAuthenticationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin
//public class DoctorsController {
//
//    @Autowired
//    LoginAuthenticationService loginAuthenticationService;
//
//    @Autowired
//    PatientDetailsRepo patientDetailsRepo;
//
//
//    @Autowired
//    PatientsMedicalDetailsRepo patientsMedicalDetailsRepo;
//
////    @RequestMapping(value="/doctorLogin", method = RequestMethod.POST)
////    public int doctorLogin(@RequestBody LoginFormEntity loginFormEntity){
////
////        return loginAuthenticationService.validateDoctorLogin(loginFormEntity);
////    }
//
//    @RequestMapping(value="/patientDetails", method = RequestMethod.POST)
//    public Optional<PatientDetails> patientDetails(@RequestBody int id){
//
//        return patientDetailsRepo.findById(id);
//    }
//
//    @RequestMapping(value="/patientHistory", method = RequestMethod.POST)
//    public List<PatientsMedicalDetails> patientHistory(@RequestBody int patientId){
//
//            return patientsMedicalDetailsRepo.findAllByPatientId(patientId);
//    }
//
//    @RequestMapping(value="/prescribePatient", method = RequestMethod.POST)
//    public PatientsMedicalDetails prescribePatient(@RequestBody PatientsMedicalDetails patientsMedicalDetails){
//
//        return patientsMedicalDetailsRepo.save(patientsMedicalDetails);
//    }
//
//}
