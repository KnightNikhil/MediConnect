package com.nikhil.springboot.MediConnect.controllers;


import com.nikhil.springboot.MediConnect.dto.DiagnosisReportDto;
import com.nikhil.springboot.MediConnect.services.DiagnosisCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosticCentre")
public class DiagnosticCentreController {

    @Autowired
    DiagnosisCentreService diagnosisCentreService;

    @PostMapping("/addDiagnosisReports")
    public ResponseEntity<DiagnosisReportDto> addDiagnosisReports(@RequestBody DiagnosisReportDto diagnosisReportDto){
        return ResponseEntity.ok(diagnosisCentreService.addDiagnosisReports(diagnosisReportDto));
    }

}
