package com.nikhil.springboot.MediConnect.services;

import com.nikhil.springboot.MediConnect.repository.DiagnosisCentreRepository;
import com.nikhil.springboot.MediConnect.repository.DoctorRepository;
import com.nikhil.springboot.MediConnect.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// TODO:; try by removing loadUserByUsername call
public class UserService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiagnosisCentreRepository diagnosisCentreRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long id = Long.valueOf(username);

        Optional<? extends UserDetails> user =
                doctorRepository.findById(id)
                        .map(d -> (UserDetails) d)
                        .or(
                                () -> patientRepository.findById(id)
                                        .map(p -> (UserDetails) p)
                        )
                        .or(
                                () -> diagnosisCentreRepository.findById(id)
                                        .map(dc -> (UserDetails) dc)
                        );

        return user.orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));


    }
}
