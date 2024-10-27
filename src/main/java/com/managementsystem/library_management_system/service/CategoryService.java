package com.managementsystem.library_management_system.service;

import com.managementsystem.library_management_system.dto.CategoryDTO;
import com.managementsystem.library_management_system.dto.CategorySaveDTO;
import com.managementsystem.library_management_system.dto.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {
    String addCategory(CategorySaveDTO categorySaveDTO);

    List<CategoryDTO> getAllCategories();

    String updateCategory(CategoryUpdateDTO categoryUpdateDTO);

    String deleteCategory(int id);
}
