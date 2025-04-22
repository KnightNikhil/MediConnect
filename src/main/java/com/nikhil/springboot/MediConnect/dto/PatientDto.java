package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.dto.Enums.Gender;
import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto extends UserDto {

    private LocalDate dateOfBirth;
    private Gender gender;

}
