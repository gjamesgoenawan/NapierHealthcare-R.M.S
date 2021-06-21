package com.napierhealthcare.shiftscheduler.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Responsible for Data Access
public interface StaffRepository
        extends JpaRepository<Staff, Long> {

//  SELECT * FROM staff WHERE email = "???"
    @Query("SELECT s FROM Staff s WHERE s.email=?1") // Staff is class
    Optional<Staff> findStaffByEmail(String email);
}
