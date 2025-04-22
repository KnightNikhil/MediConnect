package com.nikhil.springboot.MediConnect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "unique_patient_doctor_time",
                columnNames = {"patient_id", "doctor_id", "consultancy_date_time"}
        )
)
@NoArgsConstructor
@AllArgsConstructor
public class PatientConsultationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    // this name is for PatientHistory table , not referencing patient table, by default it takes id only
    // referencedColumnName is used for any other unique  field of the other entity eg referencedColumnName = "email"
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime consultancyDateTime;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String clinicalDiagnosis;

    //TODO ??
    @OneToMany(mappedBy = "patientConsultationRecord", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DiagnosisReport> diagnosisReports;

//    @Embedded
    @ElementCollection
    @CollectionTable(
            name = "medicine_prescriptions",
            joinColumns = @JoinColumn(name = "patient_consultation_record_id")
    )
    private List<MedicinePrescription> medicinePrescriptionList;


}
