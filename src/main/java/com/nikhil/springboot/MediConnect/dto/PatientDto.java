package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {

    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Roles role;

}
