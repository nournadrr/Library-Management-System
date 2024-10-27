package com.managementsystem.library_management_system.service.IMPL;

import com.managementsystem.library_management_system.dto.*;
import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.entity.Category;
import com.managementsystem.library_management_system.repo.AuthorRepo;
import com.managementsystem.library_management_system.repo.CategoryRepo;
import com.managementsystem.library_management_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public String addCategory(CategorySaveDTO categorySaveDTO) {
        Category category = new Category(categorySaveDTO.getName());
        categoryRepo.save(category);
        return category.getName() + " added successfully.";
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO(
                    category.getCategory_id(),
                    category.getName()
            );
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public String updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        if(categoryRepo.existsById(categoryUpdateDTO.getId())) {
            Category category = categoryRepo.getById(categoryUpdateDTO.getId());
            category.setName(categoryUpdateDTO.getName());
            categoryRepo.save(category);
            return category.getName() + " updated successfully.";
        }
        else{
            System.out.println(categoryUpdateDTO.getName() + " is not found.");
        }
        return null;
    }

    @Override
    public String deleteCategory(int id) {
        if(categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
        }
        else{
            System.out.println(id + " is not found.");
        }
        return null;
    }
}
