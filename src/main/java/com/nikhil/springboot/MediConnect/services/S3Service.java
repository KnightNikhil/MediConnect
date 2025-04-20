//package com.nikhil.springboot.MediConnect.services;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import software.amazon.awssdk.core.ResponseInputStream;
//import software.amazon.awssdk.core.sync.RequestBody;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.GetObjectRequest;
//import software.amazon.awssdk.services.s3.model.GetObjectResponse;
//import software.amazon.awssdk.services.s3.model.PutObjectRequest;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.nio.file.Paths;
//
//@Service
//public class S3Service {
//
//    private final S3Client s3Client;
//
//    public S3Service(S3Client s3Client) {
//        this.s3Client = s3Client;
//    }
//
//    public String uploadFileToS3(MultipartFile file) throws IOException {
//        // Implementation for file upload remains the same
//        String key = Paths.get(file.getOriginalFilename()).getFileName().toString();
//
//        String bucketname = "mediconnect-diagnosis-reports";
//        s3Client.putObject(PutObjectRequest.builder()
//                        .bucket(bucketname)
//                        .key(key)
//                        .build(),
//                RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
//
//        String objectUrl = "https://" + bucketname + ".s3." + Region.AP_SOUTH_1 + ".amazonaws.com/" + key;
//
//        return objectUrl;
//    }
//
//    // Method to download file from S3 and save it locally
//    public byte[] downloadFileFromS3(String key) throws IOException {
//        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
//                .bucket("mediconnect-diagnosis-reports")
//                .key(key)
//                .build();
//
//        ResponseInputStream<GetObjectResponse> s3ObjectResponse = s3Client.getObject(getObjectRequest);
//
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];  // Buffer to hold chunks of data
//        int length;
//
//        while ((length = s3ObjectResponse.read(buffer)) != -1) {
//            byteArrayOutputStream.write(buffer, 0, length);
//        }
//
//        byte[] doc =byteArrayOutputStream.toByteArray();
//
//        s3ObjectResponse.close();
//
//        return doc;
//    }
//}