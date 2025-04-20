package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
