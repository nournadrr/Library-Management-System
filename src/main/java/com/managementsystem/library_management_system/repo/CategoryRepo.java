package com.managementsystem.library_management_system.repo;

import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByName(String category);
}
