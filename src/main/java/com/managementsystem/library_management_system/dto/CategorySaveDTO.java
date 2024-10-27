package com.managementsystem.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategorySaveDTO {

    private String name;

    public CategorySaveDTO(String name) {
        this.name = name;
    }
}
