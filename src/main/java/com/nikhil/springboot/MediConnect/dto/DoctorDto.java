package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import com.nikhil.springboot.MediConnect.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DoctorDto extends UserDto{

    private String specialization;
    private List<String> degrees;

}
