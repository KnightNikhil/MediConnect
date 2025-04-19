package com.nikhil.springboot.MediConnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "unique_patient doctor_time",
                columnNames = {"patient_id", "doctor_id", "date_time"}
        )
)
public class PatientHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String clinicalDiagnosis;

    private List<DiagnosisReport> diagnosisReports;

    @Embedded
    private List<MedicinePrescription> medicinePrescriptionList;


}
