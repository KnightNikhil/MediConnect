package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.dto.DiagnosisCentreDto;
import com.nikhil.springboot.MediConnect.dto.DiagnosisReportDto;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.DiagnosisCentre;

public interface DiagnosisCentreService {

    DiagnosisCentre getDiagnosisCentreById(Long id) ;

    DiagnosisCentreDto addNewDiagnosisCentre(DiagnosisCentreDto createUserRequest);

    DiagnosisReportDto addDiagnosisReports(DiagnosisReportDto diagnosisReportDto);
}
