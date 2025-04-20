package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface DiagnosisCentreRepository extends JpaRepository<DiagnosisCentre, Long> {
}
