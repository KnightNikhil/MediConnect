package com.nikhil.springboot.MediConnect.entity;

import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User {

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private List<String> degrees;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(Roles.DOCTOR.name()) -- this dos not works bcoz it is expecting list of granted authorities not string or enum
        return List.of(new SimpleGrantedAuthority("ROLE_"+ Roles.DOCTOR.name()));
    }



}
