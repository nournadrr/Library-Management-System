package com.managementsystem.library_management_system.dto;

import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class BookSaveDTO {

    private String title;

    private int author_id;

    private int category_id;

    public BookSaveDTO( String title, int author_id, int category_id) {
        this.author_id = author_id;
        this.category_id = category_id;
        this.title = title;
    }
}
