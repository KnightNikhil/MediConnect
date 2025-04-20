package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
