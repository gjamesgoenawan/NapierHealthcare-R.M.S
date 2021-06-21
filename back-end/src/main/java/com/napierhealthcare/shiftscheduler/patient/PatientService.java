package com.napierhealthcare.shiftscheduler.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Service Layer
@Service // allow this to be a Spring Bean (@Component / @Service - more specific)
public class PatientService {

    private final com.napierhealthcare.shiftscheduler.patient.PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public List<com.napierhealthcare.shiftscheduler.patient.Patient> getPatients() {

        // Get data from Database
        return patientRepository.findAll();


//        return List.of(
//                new Patient(
//                        1L,
//                        "Mariam",
//                        21,
//                        "mariam.jamal@gmail.com",
//                        LocalDate.of(2000, Month.JANUARY, 5),
//                        "Dentistry",
//                        "Jurong",
//                        "Local"
//                )
//        );
    }

    public void addNewPatient(com.napierhealthcare.shiftscheduler.patient.Patient patient) {
        Optional<com.napierhealthcare.shiftscheduler.patient.Patient> patientOptional = patientRepository
                                        .findPatientByEmail((patient.getEmail()));

        if(patientOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }
        patientRepository.save(patient);

//        System.out.println(patient);
    }

    public void deletePatient(Long patientId) {
//        patientRepository.findById(patientId);
        boolean exists = patientRepository.existsById(patientId);
        if (!exists) {
            throw new IllegalStateException(
                    "Patient with id " + patientId + " does not exists."
            );
        }
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public void updatePatient(Long patientId, // Business Logic
                            String patientName,
                            String email) {
        com.napierhealthcare.shiftscheduler.patient.Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException(
                        "Patient with id " + patientId + " does not exist."
                ));
        if (patientName != null &&
                patientName.length() > 0 &&
                !Objects.equals(patient.getPatientName(), patientName)) {
            patient.setPatientName(patientName);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(patient.getEmail(), email)) {
            // Check if email is taken or not
            Optional<Patient> patientOptional = patientRepository
                    .findPatientByEmail(email);
            if (patientOptional.isPresent()) {
                throw new IllegalStateException("Email taken.");
            }
            // set the new email
            patient.setEmail(email);
        }
    }
}
