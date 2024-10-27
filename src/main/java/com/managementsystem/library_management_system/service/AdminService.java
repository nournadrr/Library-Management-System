package com.managementsystem.library_management_system.service;

import com.managementsystem.library_management_system.dto.AdminDTO;
import com.managementsystem.library_management_system.dto.AdminSaveDTO;
import com.managementsystem.library_management_system.dto.AdminUpdateDTO;

import java.util.List;

public interface AdminService {
    String addAdmin(AdminSaveDTO adminSaveDTO);

    List<AdminDTO> getAllAdmins();

    String updateAdmin(AdminUpdateDTO adminUpdateDTO);

    String deleteAdmin(int id);
}
