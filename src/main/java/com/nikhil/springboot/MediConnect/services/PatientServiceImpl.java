package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.*;
import com.nikhil.springboot.MediConnect.entity.Enums.BookingStatus;
import com.nikhil.springboot.MediConnect.entity.BookingInventory;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.BookingInventoryRepository;
import com.nikhil.springboot.MediConnect.repository.DoctorRepository;
import com.nikhil.springboot.MediConnect.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientConsultationRecordService patientConsultationRecordService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BookingInventoryRepository bookingInventoryRepository;

    private final DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find patient with Id:: " + id));
    }

    @Override
    public PatientDto addNewPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        patient.setPassword(encodePassword(patientDto.getPassword()));
        return modelMapper.map(patientRepository.save(patient) , PatientDto.class);
    }

    @Override
    public List<PatientConsultationRecordDto> getPatientConsultationRecordBy() {
        return patientConsultationRecordService.getPatientConsultationRecordByPatientId(((Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @Override
    public AppointmentDetailsDto bookDoctorAppointment(AppointmentDetailsDto appointmentDetailsDto) {

        Patient patient = (Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // TODO:: circular dependency, else use doctorService
        Doctor doctor = doctorRepository.findById(appointmentDetailsDto.getDoctorId()).orElseThrow(() -> new ResourceNotFoundException("Doctor with id not found "+ appointmentDetailsDto.getDoctorId()));
        BookingInventory bookingInventory = bookingInventoryRepository.findByDoctorAndDateAndTime(doctor, appointmentDetailsDto.getDate(), appointmentDetailsDto.getTime());
        if(!bookingInventory.getBookingStatus().equals(BookingStatus.CONFIRMED)) {
            bookingInventory.setPatient(patient);
            bookingInventory.setBookingStatus(BookingStatus.CONFIRMED);
        }
        return modelMapper.map(bookingInventoryRepository.save(bookingInventory), AppointmentDetailsDto.class);
    }

    @Override
    public AppointmentDetailsDto cancelDoctorAppointment(AppointmentDetailsDto appointmentDetailsDto) {

        Patient patient = (Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // TODO:: circular dependency, else use doctorService
        Doctor doctor = doctorRepository.findById(appointmentDetailsDto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with id not found "+ appointmentDetailsDto.getDoctorId()));
        BookingInventory bookingInventory = bookingInventoryRepository.findByDoctorAndDateAndTime(
                doctor, appointmentDetailsDto.getDate(), appointmentDetailsDto.getTime());

        if (patient.getId().equals(bookingInventory.getPatient().getId()))
        {
            bookingInventory.setPatient(null);
            bookingInventory.setBookingStatus(BookingStatus.CANCELLED);
        }

        return modelMapper.map(bookingInventoryRepository.save(bookingInventory), AppointmentDetailsDto.class);
    }

    @Override
    public List<AppointmentDetailsDto> findAllAppointments() {
        return
                bookingInventoryRepository.findAllByPatient((Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                        .stream()
                        .map(inventory -> modelMapper.map(inventory, AppointmentDetailsDto.class))
                        .toList();

    }
}
