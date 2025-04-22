package com.nikhil.springboot.MediConnect.dto;


import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import lombok.*;

import java.time.LocalDate;

@Data
public class DiagnosisReportDto {

    private Long id;
    private Long patientConsultationRecordId;
    private DiagnosisCentre diagnosisCentre;
    private LocalDate date;
    private String documentName;
    private String documentUrlS3;

}
