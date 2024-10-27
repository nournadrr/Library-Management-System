package com.managementsystem.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO {

    private int id;

    private String name;

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
