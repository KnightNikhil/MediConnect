//package com.nikhil.springboot.MediConnect.controllers;
//
//import com.nikhil.springboot.MediConnect.entity.Doctor;
//import com.nikhil.springboot.MediConnect.repository.FetchDoctors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class StaticPages {
//
//    @Autowired
//    FetchDoctors fetchDoctors;
//
//    @RequestMapping("")
//    public String Homepage(){
//        return "Hello Home";
//    }
//
//    @RequestMapping("allDoctors")
//    public List<Doctor> getAllDoctors(){
//
//        List<Doctor> doctors = new ArrayList<>();
//        doctors = fetchDoctors.findAll();
//
//        return doctors;
//    }
//
//    @RequestMapping(value="findDoctorsBySpecializaion", method= RequestMethod.POST)
//    public List<Doctor> findDoctors(@RequestBody String searchSpecialization){
//
//        List<Doctor> doctors = new ArrayList<>();
//
//        doctors = fetchDoctors.findBySpecialization(searchSpecialization);
//
//        return doctors;
//    }
//
//
//    @RequestMapping("getAllSpecializations.json")
//    public List<String> getAllSpecializations(){
//
//        List<String> specilaizations = new ArrayList<>();
//        specilaizations = fetchDoctors.getAllSpecializations();
//
//        return specilaizations;
//    }
//
//}
