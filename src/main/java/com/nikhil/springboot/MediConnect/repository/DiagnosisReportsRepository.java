package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisReportsRepository extends JpaRepository<DiagnosisReport, Long> {
}
