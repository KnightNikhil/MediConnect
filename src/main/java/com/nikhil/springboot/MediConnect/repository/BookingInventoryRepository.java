package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.BookingInventory;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingInventoryRepository extends JpaRepository<BookingInventory, Long> {
    List<BookingInventory> findAllByPatient(Patient patient);

    BookingInventory findByDoctorAndDateAndTime(Doctor doctor, LocalDate date, LocalTime time);
}
