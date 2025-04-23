package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.entity.Enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto extends UserDto {

    private LocalDate dateOfBirth;
    private Gender gender;

}
