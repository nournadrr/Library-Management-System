package com.managementsystem.library_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthorSaveDTO {
    private String name;

    public AuthorSaveDTO(String name) {
        this.name = name;
    }
}
