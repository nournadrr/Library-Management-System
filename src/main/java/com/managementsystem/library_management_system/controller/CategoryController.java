package com.managementsystem.library_management_system.controller;

import com.managementsystem.library_management_system.dto.*;
import com.managementsystem.library_management_system.service.AuthorService;
import com.managementsystem.library_management_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping( "/save")
    public String saveCategory(@RequestBody CategorySaveDTO categorySaveDTO) {
        String categoryname = categoryService.addCategory(categorySaveDTO);
        return categoryname;
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return categories;
    }

    @PutMapping("/update")
    public String updateCategory(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        String categoryname = categoryService.updateCategory(categoryUpdateDTO);
        return categoryname;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable(value = "id") int id) {
        String categoryname = categoryService.deleteCategory(id);
        return "deleted successfully.";
    }
}
