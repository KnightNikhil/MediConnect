package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.entity.DiagnosisReport;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.MedicinePrescription;
import com.nikhil.springboot.MediConnect.entity.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PatientConsultationRecordDto {

    private Long id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private Integer age;


    private Long patientId;
    private Double weight;
    private String symptoms;
    private String clinicalDiagnosis;
    private List<DiagnosisReportDto> diagnosisReports;
    private List<MedicinePrescription> medicinePrescriptionList;

}
