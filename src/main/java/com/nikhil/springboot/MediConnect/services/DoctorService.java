package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.entity.Doctor;

public interface DoctorService {
    Doctor getDoctorById(Long id);

    DoctorDto addNewDoctor(DoctorDto doctorDto);

    PatientConsultationRecordDto addPatientConsultationRecord(PatientConsultationRecordDto patientConsultationRecordDto);

    void createBookingInventory(BookingInventoryRequestDto bookingInventoryRequest);
}
