package com.nikhil.springboot.MediConnect.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_consultation_record_id", nullable = false)
    private PatientConsultationRecord patientConsultationRecord;

    @ManyToOne
    @JoinColumn(name = "diagnosis_centre_id", nullable = false)
    private DiagnosisCentre diagnosisCentre;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String documentName;

    @Column(name = "document_url_s3", nullable = false)
    private String documentUrlS3;

}
