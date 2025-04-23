package com.nikhil.springboot.MediConnect.entity;

import com.nikhil.springboot.MediConnect.entity.Enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@MappedSuperclass
public abstract class User implements UserDetails {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public abstract Long getId();

    public abstract void setId(Long id);
}
