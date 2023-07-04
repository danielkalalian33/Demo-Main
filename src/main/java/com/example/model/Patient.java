package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Patient {
    @Id
    @SequenceGenerator(name = "patientSequence", sequenceName = "patientSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="patientSequence")
    Long id;

    String name;
    Date dateOfBirth;
    String email;
    String phoneNumber;
    List<History> historyList;
}
