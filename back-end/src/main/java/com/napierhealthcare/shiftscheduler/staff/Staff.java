package com.napierhealthcare.shiftscheduler.staff;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity // for Hibernate
@Table  // Tables in database
public class Staff {
    // Map Staff class to a table in database
    @Id
    @SequenceGenerator(
            name = "staff_sequence",
            sequenceName = "staff_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "staff_sequence"
    )

    // Entities
    private Long staffId;
    private String staffName;
    private String email;
    private LocalDate dateOfBirth;
    private String specialization;
    private String workLocation;
    private String serviceType;
    @Transient
    private Integer age;

    public Staff() {
    }

    public Staff(Long staffId,
                 String staffName,
//                 Integer age,
                 String email,
                 LocalDate dateOfBirth,
                 String specialization,
                 String workLocation,
                 String serviceType) {
        this.staffId = staffId;
        this.staffName = staffName;
//        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
        this.workLocation = workLocation;
        this.serviceType = serviceType;
    }

    public Staff(String staffName,
//                 Integer age,
                 String email,
                 LocalDate dateOfBirth,
                 String specialization,
                 String workLocation,
                 String serviceType) {
        this.staffName = staffName;
//        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
        this.workLocation = workLocation;
        this.serviceType = serviceType;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", specialization='" + specialization + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
