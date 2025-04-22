package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;

import java.util.List;

public interface PatientConsultationRecordService {
    PatientConsultationRecord getPatientConsultationRecordById(Long id);

    List<PatientConsultationRecordDto> getPatientConsultationRecordByPatientId(Long patientId);
}
