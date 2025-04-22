package com.nikhil.springboot.MediConnect.security;

import com.nikhil.springboot.MediConnect.entity.User;
import com.nikhil.springboot.MediConnect.services.DiagnosisCentreService;
import com.nikhil.springboot.MediConnect.services.DoctorService;
import com.nikhil.springboot.MediConnect.services.PatientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Configuration
@Slf4j
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    DiagnosisCentreService diagnosisCentreService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            // get header token
            String headerToken = request.getHeader("Authorization").split("Bearer ")[1];


            //get user from token
            User user = jwtService.getUserIdAndRoleFromToken(headerToken);
            Long id = user.getId();

            UserDetails userDetails;
            userDetails = switch (user.getRole()) {
                case PATIENT -> patientService.getPatientById(id);
                case DOCTOR -> doctorService.getDoctorById(id);
                case DIAGNOSIS_CENTRE -> diagnosisCentreService.getDiagnosisCentreById(id);
                default -> throw new RuntimeException();
                    // throw invalid role error
            };

            // All of your entities (Doctor, Patient, etc.) implement UserDetails.
            // So when you write:
            // UserDetails user = doctorRepository.findById(id).orElseThrow();
            // You’re NOT restricting it to the User base class — you’re saying:
            // 👉 “This object must implement the UserDetails interface.”
            //
            // But Spring doesn’t care if it’s a Doctor, Patient, or DiagnosisCentre — as long as it implements UserDetails, it’s happy.
            //
            // And since you never downcast to User, you’re free to retain all the real class features:


            // Scenario
            // What You Can Access
            // User user = new Doctor()
            // Only fields/methods from User (base class)… common,  specific
            // UserDetails user = new Doctor()
            // Only fields from UserDetails, BUT you can still cast to Doctor
            // Doctor doctor = new Doctor()
            // Full access to everything Doctor has

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }
        catch (Exception e){
            System.out.println("Exception:: ");
        }

        filterChain.doFilter(request, response);
        // move to next filter in securityFilterChain
    }



}
