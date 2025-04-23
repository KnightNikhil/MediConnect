package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.entity.Enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DoctorDto extends UserDto{

    private LocalDate dateOfBirth;
    private Gender gender;
    private String specialization;
    private List<String> degrees;

}
