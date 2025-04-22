package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(Long id);

    PatientDto addNewPatient(PatientDto patientDto);

    List<PatientConsultationRecordDto> getPatientConsultationRecordBy();

    AppointmentDetailsDto bookDoctorAppointment(AppointmentDetailsDto appointmentDetailsDto);
}
