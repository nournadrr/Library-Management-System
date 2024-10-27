package com.managementsystem.library_management_system.repo;

import com.managementsystem.library_management_system.entity.Admin;
import com.managementsystem.library_management_system.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
