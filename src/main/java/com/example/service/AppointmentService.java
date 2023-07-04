package com.example.service;

import com.example.model.Appointment;
import com.example.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> listAllTodayAppointments() {
        return appointmentRepository.findByAppointmentDate(new Date());
    }

    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Long appointmentId, String cancellationReason) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        if(appointment.isPresent())
        {
            appointment.get().setIsCanceled(true);
            appointment.get().setCancellationReason(cancellationReason);
        }
        return appointmentRepository.save(appointment.get());
    }

    public Optional<Appointment> reviewAppointmentsById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public List<Appointment> listAllAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> listAllAppointmentsByDate(Date date) {
        return appointmentRepository.findByAppointmentDate(date);
    }
}
