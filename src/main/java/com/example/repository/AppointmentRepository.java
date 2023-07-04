package com.example.repository;

import com.example.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(Date date);

    List<Appointment> findByPatientId(Long patientId);
}
