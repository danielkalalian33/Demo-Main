package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Data
@Entity
public class History {
    @Id
    @SequenceGenerator(name = "historySequence", sequenceName = "historySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="historySequence")
    Long id;

    Date visitDate;
    String doctorComment;

    Long patientId;
}
