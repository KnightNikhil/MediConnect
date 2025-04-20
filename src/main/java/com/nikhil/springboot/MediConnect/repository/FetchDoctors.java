//package com.nikhil.springboot.MediConnect.repository;
//
//import com.nikhil.springboot.MediConnect.entity.Doctor;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface FetchDoctors extends JpaRepository<Doctor, Integer> {
//
//    List<Doctor> findBySpecialization(String specialization);
//
//    @Query("select specialization from Doctors")
//    List<String> getAllSpecializations();
//}
