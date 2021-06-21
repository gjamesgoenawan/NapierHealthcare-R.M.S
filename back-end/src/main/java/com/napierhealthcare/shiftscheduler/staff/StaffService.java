package com.napierhealthcare.shiftscheduler.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Service Layer
@Service // allow this to be a Spring Bean (@Component / @Service - more specific)
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Autowired
    public List<Staff> getStaffs() {

        // Get data from Database
        return staffRepository.findAll();


//        return List.of(
//                new Staff(
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

    public void addNewStaff(Staff staff) {
        Optional<Staff> staffOptional = staffRepository
                                        .findStaffByEmail((staff.getEmail()));

        if(staffOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }
        staffRepository.save(staff);

//        System.out.println(staff);
    }

    public void deleteStaff(Long staffId) {
//        staffRepository.findById(staffId);
        boolean exists = staffRepository.existsById(staffId);
        if (!exists) {
            throw new IllegalStateException(
                    "Staff with id " + staffId + " does not exists."
            );
        }
        staffRepository.deleteById(staffId);
    }

    @Transactional
    public void updateStaff(Long staffId, // Business Logic
                            String staffName,
                            String email) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new IllegalStateException(
                        "Staff with id " + staffId + " does not exist."
                ));
        if (staffName != null &&
                staffName.length() > 0 &&
                !Objects.equals(staff.getStaffName(), staffName)) {
            staff.setStaffName(staffName);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(staff.getEmail(), email)) {
            // Check if email is taken or not
            Optional<Staff> staffOptional = staffRepository
                    .findStaffByEmail(email);
            if (staffOptional.isPresent()) {
                throw new IllegalStateException("Email taken.");
            }
            // set the new email
            staff.setEmail(email);
        }
    }
}
