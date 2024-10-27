package com.managementsystem.library_management_system.dto;

import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int id;

    private String title;

    private int author_id;

    private int category_id;
}
