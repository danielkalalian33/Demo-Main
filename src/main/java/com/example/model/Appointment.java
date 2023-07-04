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
public class Appointment {
    @Id
    @SequenceGenerator(name = "appointmentSequence", sequenceName = "appointmentSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="appointmentSequence")
    Long id;

    Date appointmentDate;
    Boolean isCanceled;
    String cancellationReason;
    Long patientId;
}
