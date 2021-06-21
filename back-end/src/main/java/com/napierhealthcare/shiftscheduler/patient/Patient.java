package com.napierhealthcare.shiftscheduler.patient;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity // for Hibernate
@Table  // Tables in database
public class Patient {
    // Map patient class to a table in database
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )

    // Entities
    private Long patientId;
    private String patientName;
    private String email;
    private LocalDate dateOfBirth;
    private String patientAddress;
    private String serviceNeeded;
    @Transient
    private Integer age;

    public Patient() {
    }


    public Patient(String patientName,
                   String email,
                   LocalDate dateOfBirth,
                   String patientAddress,
                   String serviceNeeded,
                   Integer age) {
        this.patientName = patientName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.serviceNeeded = serviceNeeded;
        this.age = age;
    }

    public Patient(Long patientId,
                   String patientName,
                   String email,
                   LocalDate dateOfBirth,
                   String patientAddress,
                   String serviceNeeded,
                   Integer age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.serviceNeeded = serviceNeeded;
        this.age = age;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getServiceNeeded() {
        return serviceNeeded;
    }

    public void setServiceNeeded(String serviceNeeded) {
        this.serviceNeeded = serviceNeeded;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", patientAddress='" + patientAddress + '\'' +
                ", serviceNeeded='" + serviceNeeded + '\'' +
                ", age=" + age +
                '}';
    }
}
