package com.nikhil.springboot.MediConnect.dto;

import com.nikhil.springboot.MediConnect.entity.Enums.Roles;
import lombok.Data;

@Data
public class UserDto {

    private String id;
    private String password;
    private String name;
    private String email;
    private Roles role;
}
