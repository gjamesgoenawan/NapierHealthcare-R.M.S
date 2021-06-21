package com.napierhealthcare.shiftscheduler.staff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StaffConfig { // Spring Bean

    @Bean
    CommandLineRunner commandLineRunner(StaffRepository repository) { // connect to repository
        return args -> {
            Staff mariam = new Staff(
                    1L,
                    "Mariam",
//                    21,
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "Dentistry",
                    "Jurong",
                    "Local"
            );

            Staff alex = new Staff(
                    "alex",
//                    21,
                    "alex@gmail.com",
                    LocalDate.of(1995, Month.JANUARY, 5),
                    "Dentistry",
                    "Jurong",
                    "Local"
            );

            repository.saveAll( // invoke Hibernate to save data into database (repository)
                    List.of(mariam, alex)
            );
        };
    }
}
