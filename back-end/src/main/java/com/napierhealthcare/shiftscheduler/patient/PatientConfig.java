package com.napierhealthcare.shiftscheduler.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfig { // Spring Bean

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository) { // connect to repository
        return args -> {
            com.napierhealthcare.shiftscheduler.patient.Patient mariam = new com.napierhealthcare.shiftscheduler.patient.Patient(
                    1L,
                    "Julie",
                    "July.May@gmail.com",
                    LocalDate.of(1990, Month.JULY, 4),
                    "#13-33, Jurong West 221, 629482, Singapore",
                    "Treatment",
                    33
            );

//            return "Patient{" +
//                    "patientId=" + patientId +
//                    ", patientName='" + patientName + '\'' +
//                    ", email='" + email + '\'' +
//                    ", dateOfBirth=" + dateOfBirth +
//                    ", patientAddress='" + patientAddress + '\'' +
//                    ", serviceNeeded='" + serviceNeeded + '\'' +
//                    ", age=" + age +
//                    '}';


            com.napierhealthcare.shiftscheduler.patient.Patient alex = new Patient(
                    1L,
                    "Alex",
                    "Alex.Ketchum@gmail.com",
                    LocalDate.of(1997, Month.FEBRUARY, 17),
                    "#05-75, Clementi Ridge 495A, 639205, Singapore",
                    "Leg Casking",
                    24
            );

            repository.saveAll( // invoke Hibernate to save data into database (repository)
                    List.of(mariam, alex)
            );
        };
    }
}
