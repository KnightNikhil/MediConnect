package com.nikhil.springboot.MediConnect.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

public class CommonUtils {

    public static Integer calculateAge(LocalDate dateOfBirth){
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
