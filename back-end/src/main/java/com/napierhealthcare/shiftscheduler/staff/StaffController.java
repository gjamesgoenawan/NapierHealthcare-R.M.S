package com.napierhealthcare.shiftscheduler.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // API Layer
@RequestMapping(path = "api/v1/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired // automatically autowire StaffService, instantiate staffService
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getStaffs() {
        return staffService.getStaffs();
    }

    @PostMapping
    public void registerNewStaff(@RequestBody Staff staff) { // Get the RequestBody and map onto the Staff
        staffService.addNewStaff(staff); // Add new staff
    }

    @DeleteMapping(path = "{staffId}")
    public void deleteStaff(@PathVariable("staffId") Long staffId) {
        staffService.deleteStaff(staffId);
    }

    @GetMapping("/test")
    public String testRoute() {
        return "This is a test route";
    }

    @PutMapping(path = "{staffId}")
    public void updateStaff(
            @PathVariable("staffId") Long staffId,
            @RequestParam(required = false) String staffName,
            @RequestParam(required = false) String email) {
        staffService.updateStaff(staffId, staffName, email);
    }
}
