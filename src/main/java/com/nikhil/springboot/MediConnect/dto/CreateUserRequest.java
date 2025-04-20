package com.nikhil.springboot.MediConnect.dto;

import lombok.Data;
import java.util.Map;

@Data
public class CreateUserRequest {

    private String role;
    private Map<String, Object> data;

    // TODO:: lombok not working


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
