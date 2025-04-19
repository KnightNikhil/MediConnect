package com.nikhil.springboot.MediConnect.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DiagnosisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_history_id", nullable = false)
    private PatientHistory patientHistory;

    @ManyToOne
    @JoinColumn(name = "diagnosis_centre_id", nullable = false)
    private DiagnosisCentre diagnosisCentre;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String documentName;

    @Column(name = "document_url_s3", nullable = false)
    private String documentUrlS3;

}
