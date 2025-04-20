//package com.nikhil.springboot.MediConnect.services;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//
//@Configuration
//public class AwsS3Config {
//
//    @Bean
//    public S3Client s3Client() {
//        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(
//                "AKIARZDBHUESSIUMUMGS",
//                "Q23iEXNFe1soSspXVKMchHa6EHDCWb3lHFcFx72w"
//        );
//        return S3Client.builder()
//                .region(Region.AP_SOUTH_1)
//                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
//                .build();
//    }
//}
//
