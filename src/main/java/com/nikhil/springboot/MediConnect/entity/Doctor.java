package com.nikhil.springboot.MediConnect.entity;

import com.nikhil.springboot.MediConnect.entity.Enums.Gender;
import com.nikhil.springboot.MediConnect.entity.Enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User {

    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private List<String> degrees;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(Roles.DOCTOR.name()) -- this dos not works bcoz it is expecting list of granted authorities not string or enum
        return List.of(new SimpleGrantedAuthority("ROLE_"+ Roles.DOCTOR.name()));
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id =id;
    }

}
