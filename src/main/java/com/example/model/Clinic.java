package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class Clinic {
    @Id
    @SequenceGenerator(name = "clinicSequence", sequenceName = "clinicSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="clinicSequence")
    Long id;

    String name;
    String location;
    String phoneNumber;
}
