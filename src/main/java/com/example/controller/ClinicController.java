package com.example.controller;

import com.example.model.Appointment;
import com.example.model.History;
import com.example.service.AppointmentService;
import com.example.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clinic")
public class ClinicController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    HistoryService historyService;

    @GetMapping("/reviewAppointmentsById/{appointmentId}")
    public Optional<Appointment> reviewAppointmentsById(@RequestParam("appointmentId") Long appointmentId) {

        Optional<Appointment> appointment = appointmentService.reviewAppointmentsById(appointmentId);
        if(appointment.isPresent())
        {
            return appointment;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
    }

    @GetMapping("/listAllTodayAppointments")
    public List<Appointment> listAllTodayAppointments() {

        return appointmentService.listAllTodayAppointments();
    }

    @GetMapping("/listAllAppointmentsByPatient/{patientId}")
    public List<Appointment> listAllAppointmentsByPatient(@RequestParam("patientId") Long patientId) {

        return appointmentService.listAllAppointmentsByPatient(patientId);
    }

    @GetMapping("/listAllAppointmentsByDate/{date}")
    public List<Appointment> listAllAppointmentsByDate(@RequestParam("date") Date date) {

        return appointmentService.listAllAppointmentsByDate(date);
    }

    @PostMapping("/addNewAppointment")
    public Appointment addNewAppointment(@RequestBody Appointment appointment) {

        return appointmentService.addNewAppointment(appointment);
    }

    @PutMapping("/cancelAppointment/{appointmentId}")
    public Appointment cancelAppointment(@RequestParam("appointmentId") Long appointmentId, @RequestBody String cancellationReason) {
        if(!cancellationReason.equals("No show") && !cancellationReason.equals("based on patient request") && !cancellationReason.equals("Physician apology"))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong Cancellation Reason");
        }

        return appointmentService.cancelAppointment(appointmentId, cancellationReason);
    }

    @GetMapping("/listAllPatientHistory/{patientId}")
    public List<History> listAllPatientHistory(@RequestParam("patientId") Long patientId) {

        return historyService.listAllPatientHistory(patientId);
    }
}
