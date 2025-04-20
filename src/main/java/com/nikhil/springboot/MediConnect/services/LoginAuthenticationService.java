//package com.nikhil.springboot.MediConnect.services;
//
//import com.nikhil.springboot.MediConnect.repository.PatientDetailsRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Calendar;
//
//@Service
//public class LoginAuthenticationService {
//
//
//    @Autowired
//    PatientDetailsRepo patientDetailsRepo;
//
////    public int validateDoctorLogin(LoginFormEntity loginFormEntity) {
////        UserDto loginEntity = fetchDoctorsDetails.findByUsername(loginFormEntity.getUsername()).getFirst();
////        if (loginFormEntity.getPassword().equals(loginEntity.getPassword()))
////            return loginEntity.getId();
////        else
////            return -1;
////    }
//
//    public PatientDetails validatePatientLogin(String username, String password){
//        PatientDetails patientDetails = patientDetailsRepo.findByUsername(username).getFirst();
//        if(patientDetails!=null && patientDetails.getPassword()!=null &&
//            patientDetails.getPassword().equals(password)){
//            Calendar birthCalendar = Calendar.getInstance();
//            birthCalendar.setTime(patientDetails.getDateOfBirth());
//            Calendar today = Calendar.getInstance();
//            int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR) > 0 ? today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR) : -1;
//            if (today.get(Calendar.DAY_OF_YEAR) > birthCalendar.get(Calendar.DAY_OF_YEAR))
//                age--;
//            return patientDetails;
//        }
//        return null;
//    }
//}
