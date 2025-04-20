package com.nikhil.springboot.MediConnect.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

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
