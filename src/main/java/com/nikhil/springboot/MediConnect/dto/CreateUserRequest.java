package com.nikhil.springboot.MediConnect.dto;

import lombok.Data;
import java.util.Map;

@Data
public class CreateUserRequest {

    private String role;
    private Map<String, Object> data;

    // TODO:: lombok not working
}
