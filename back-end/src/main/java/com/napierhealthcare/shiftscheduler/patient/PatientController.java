package com.napierhealthcare.shiftscheduler.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // API Layer
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final com.napierhealthcare.shiftscheduler.patient.PatientService patientService;

    @Autowired // automatically autowire PatientService, instantiate patientService
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<com.napierhealthcare.shiftscheduler.patient.Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient) { // Get the RequestBody and map onto the Patient
        patientService.addNewPatient(patient); // Add new patient
    }

    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @GetMapping("/test")
    public String testRoute() {
        return "This is a test route";
    }

    @PutMapping(path = "{patientId}")
    public void updatePatient(
            @PathVariable("patientId") Long patientId,
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) String email) {
        patientService.updatePatient(patientId, patientName, email);
    }
}
