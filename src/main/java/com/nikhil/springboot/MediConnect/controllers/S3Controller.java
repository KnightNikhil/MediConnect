//package com.nikhil.springboot.MediConnect.controllers;
//
//import com.nikhil.springboot.MediConnect.services.S3Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//public class S3Controller {
//
//    @Autowired
//    S3Service s3Service;
//
//    @GetMapping("/downloadS3")
//    public ResponseEntity<String> downloadFileS3(@RequestParam String key){
//
//            try {
//            s3Service.downloadFileFromS3(key);
//                return ResponseEntity.ok("File downloaded successfully!");
//            }
//            catch (IOException e){
//                System.out.println(e);
//                return ResponseEntity.status(500).body("Failed to download file: " + e.getMessage());
//            }
//
//
//
//    }
//
//    @PostMapping("/uploadS3")
//    public ResponseEntity<String> uploadFileS3(@RequestParam("file") MultipartFile file) {
//        try {
//            String fileKey = s3Service.uploadFileToS3(file );
//            return ResponseEntity.ok("File uploaded successfully with key: " + fileKey);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
//        }
//    }
//}
