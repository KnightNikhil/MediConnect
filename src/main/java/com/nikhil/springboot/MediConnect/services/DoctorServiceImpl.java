package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.BookingInventoryRequestDto;
import com.nikhil.springboot.MediConnect.dto.DoctorDto;
import com.nikhil.springboot.MediConnect.dto.Enums.BookingStatus;
import com.nikhil.springboot.MediConnect.dto.PatientConsultationRecordDto;
import com.nikhil.springboot.MediConnect.entity.BookingInventory;
import com.nikhil.springboot.MediConnect.entity.Doctor;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.entity.PatientConsultationRecord;
import com.nikhil.springboot.MediConnect.exception.ResourceNotFoundException;
import com.nikhil.springboot.MediConnect.repository.BookingInventoryRepository;
import com.nikhil.springboot.MediConnect.repository.DoctorRepository;
import com.nikhil.springboot.MediConnect.repository.PatientConsultationRecordRepository;
import com.nikhil.springboot.MediConnect.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientConsultationRecordRepository patientConsultationRecordRepository;

    @Autowired
    BookingInventoryRepository bookingInventoryRepository;

    private final PatientService patientService;

    public String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not found doctor with Id:: " + id));
    }

    @Override
    public DoctorDto addNewDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctor.setPassword(encodePassword(doctorDto.getPassword()));
        return modelMapper.map(doctorRepository.save(doctor) , DoctorDto.class);
    }


    @Override
    public PatientConsultationRecordDto addPatientConsultationRecord(PatientConsultationRecordDto patientConsultationRecordDto) {
        PatientConsultationRecord patientConsultationRecord = modelMapper.map(patientConsultationRecordDto, PatientConsultationRecord.class);
        patientConsultationRecord.setDoctor((Doctor) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Patient patient = patientService.getPatientById(patientConsultationRecordDto.getPatientId());
        patientConsultationRecord.setPatient(patient);
        patientConsultationRecord.setAge(CommonUtils.calculateAge(patient.getDateOfBirth()));
        patientConsultationRecord.setConsultancyDateTime(LocalDateTime.now());
        PatientConsultationRecord savedPatientConsultationRecord = patientConsultationRecordRepository.save(patientConsultationRecord);
        return modelMapper.map(savedPatientConsultationRecord, PatientConsultationRecordDto.class);
    }

    @Override
    public void createBookingInventory(BookingInventoryRequestDto bookingInventoryRequest) {

        List<BookingInventory> bookingInventories = new ArrayList<>();
        BookingInventory bookingInventory ;
        Doctor doctor = (Doctor) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        for( LocalDate date = bookingInventoryRequest.getFromDate(); date.isBefore(bookingInventoryRequest.getToDate().plusDays(1)); date = date.plusDays(1) ) {
            for(LocalTime time = bookingInventoryRequest.getFromTime(); time.isBefore(bookingInventoryRequest.getToTime()); time = time.plusMinutes(15) ) {
                    bookingInventory = new BookingInventory( doctor, date, time, BookingStatus.AVAILABLE);
                bookingInventories.add(bookingInventory);
            }
        }

        bookingInventoryRepository.saveAll(bookingInventories);


    }


}
