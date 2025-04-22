package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientConsultationRecordRepository extends JpaRepository<PatientConsultationRecord, Long> {
    List<PatientConsultationRecord> findAllByPatientId(Long patientId);
}
