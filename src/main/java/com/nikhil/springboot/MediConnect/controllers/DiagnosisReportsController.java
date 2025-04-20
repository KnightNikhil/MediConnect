import com.fasterxml.jackson.databind.ObjectMapper;//package com.nikhil.springboot.MediConnect.controllers;
//
//import com.nikhil.springboot.MediConnect.entity.DiagnosisReport;
//import com.nikhil.springboot.MediConnect.dto.DiagnosisReportsInputBean;
//import com.nikhil.springboot.MediConnect.repository.DiagnosisReportsRepo;
//import com.nikhil.springboot.MediConnect.repository.PatientsMedicalDetailsRepo;
//import com.nikhil.springboot.MediConnect.services.S3Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//public class DiagnosisReportsController {
//
//    @Autowired
//    DiagnosisReportsRepo diagnosisReportsRepo;
//
//    @Autowired
//    S3Service s3Service;
//
//    @Autowired
//    PatientsMedicalDetailsRepo patientsMedicalDetailsRepo;
//
//    @RequestMapping(value="uploadDiagnosisReports", method = RequestMethod.POST)
//    @CrossOrigin(origins = "http://localhost:3000")
//    public String uploadDiagnosisReports(@RequestPart("document") MultipartFile document, @RequestPart("uploadDetails") String uploadDetails){
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
////            DiagnosisReport diagnosisReport = objectMapper.readValue(uploadDetails, DiagnosisReport.class);
////            diagnosisReport.setDocument(document.getBytes());
////            diagnosisReport.setDocumentName(document.getOriginalFilename());
////            diagnosisReport.setDate(new Date());
////            diagnosisReport.setDocumentUrlS3(s3Service.uploadFileToS3(document));
////
////
////            Optional<PatientsMedicalDetails> patientsMedicalDetails = patientsMedicalDetailsRepo.findById(diagnosisReport.getMedicalHistoryId());
////            diagnosisReport.setDoctorId(patientsMedicalDetails.get().getDoctorId());
////            diagnosisReport.setPatientId(patientsMedicalDetails.get().getPatientId());
////
////            diagnosisReportsRepo.save(diagnosisReport);
////            return "SUCCESS";
//
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        return "FAIL";
//    }
//
//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping(value="getDiagnosisReports", method = RequestMethod.POST)
//    public List<DiagnosisReport> getDiagnosisReports(@RequestBody DiagnosisReportsInputBean diagnosisReportsInputBean){
//        List<DiagnosisReport> diagnosisReports =  diagnosisReportsRepo.findByMedicalHistoryId(diagnosisReportsInputBean.getMedicalHistoryId());
//        try {
//            for (DiagnosisReport diagnosisReport : diagnosisReports){
//                diagnosisReport.setDocument(s3Service.downloadFileFromS3(diagnosisReport.getDocumentName()));
//            }
//        } catch (IOException e){
//        System.out.println(e);
//        }
//        return diagnosisReports;
//    }
//
//
//
//}
