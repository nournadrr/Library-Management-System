package com.managementsystem.library_management_system.service.IMPL;

import com.managementsystem.library_management_system.dto.AdminDTO;
import com.managementsystem.library_management_system.dto.AdminSaveDTO;
import com.managementsystem.library_management_system.dto.AdminUpdateDTO;
import com.managementsystem.library_management_system.dto.AuthorDTO;
import com.managementsystem.library_management_system.entity.Admin;
import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.repo.AdminRepo;
import com.managementsystem.library_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public String addAdmin(AdminSaveDTO adminSaveDTO) {
        Admin admin = new Admin(
                adminSaveDTO.getName()
        );
        adminRepo.save(admin);
        return admin.getName();

    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepo.findAll();
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin admin : admins) {
            AdminDTO adminDTO = new AdminDTO(
                    admin.getAdminid(),
                    admin.getName()
            );
            adminDTOS.add(adminDTO);
        }
        return adminDTOS;
    }

    @Override
    public String updateAdmin(AdminUpdateDTO adminUpdateDTO) {
        if(adminRepo.existsById(adminUpdateDTO.getAdminid())) {
            Admin admin = adminRepo.getById(adminUpdateDTO.getAdminid());
            admin.setName(adminUpdateDTO.getName());
            adminRepo.save(admin);
            return admin.getName() + " updated successfully.";
        }
        else{
            System.out.println(adminUpdateDTO.getName() + " is not found.");
        }
        return null;
    }

    @Override
    public String deleteAdmin(int id) {
        if(adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
        }
        else{
            System.out.println(id + " is not found.");
        }
        return null;
    }
}
