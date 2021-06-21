package com.napierhealthcare.shiftscheduler.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Responsible for Data Access
public interface PatientRepository
        extends JpaRepository<com.napierhealthcare.shiftscheduler.patient.Patient, Long> {

//  SELECT * FROM patient WHERE email = "???"
    @Query("SELECT s FROM Staff s WHERE s.email=?1") // Patient is class
    Optional<com.napierhealthcare.shiftscheduler.patient.Patient> findPatientByEmail(String email);
}
