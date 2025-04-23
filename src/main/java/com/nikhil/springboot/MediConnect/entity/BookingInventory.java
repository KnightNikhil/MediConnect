package com.nikhil.springboot.MediConnect.entity;

import com.nikhil.springboot.MediConnect.entity.Enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "booked_for_patient_id")
    private Patient patient;

    public BookingInventory(Doctor doctor, LocalDate date, LocalTime time, BookingStatus bookingStatus) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.bookingStatus = bookingStatus;
    }

}
