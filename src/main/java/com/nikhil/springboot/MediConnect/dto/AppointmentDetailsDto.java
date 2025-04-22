package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.dto.Enums.BookingStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentDetailsDto {

    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Long patientId;
    private Long doctorId;
    private BookingStatus bookingStatus;
}
