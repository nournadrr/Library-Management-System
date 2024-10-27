package com.managementsystem.library_management_system.controller;

import com.managementsystem.library_management_system.dto.*;
import com.managementsystem.library_management_system.service.AdminService;
import com.managementsystem.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping( "/save")
    public String saveAdmin(@RequestBody AdminSaveDTO adminSaveDTO) {
        String adminname = adminService.addAdmin(adminSaveDTO);
        return adminname + " Added Successfully.";
    }
    @GetMapping("/getAllAdmins")
    public List<AdminDTO> getAllAdmins() {
        List<AdminDTO> admins = adminService.getAllAdmins();
        return admins;
    }

    @PutMapping("/update")
    public String updateAdmin(@RequestBody AdminUpdateDTO adminUpdateDTO) {
        String adminname = adminService.updateAdmin(adminUpdateDTO);
        return adminname;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable(value = "id") int id) {
        String adminname = adminService.deleteAdmin(id);
        return "deleted successfully.";
    }


}
