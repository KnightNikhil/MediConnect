package com.nikhil.springboot.MediConnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

@Embeddable
@Getter
@Setter
public class MedicinePrescription {

    private String medicine;

    private Integer timesADay;

    private Boolean morning;

    private Boolean afternoon;

    private Boolean evening;

    private Boolean night;

    private Integer numberOfDays;

}
