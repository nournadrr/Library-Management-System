package com.managementsystem.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDTO {

    private int id;

    private String title;

    private int author_id;

    private int category_id;

    public BookUpdateDTO( String title, int author_id, int category_id) {
        this.author_id = author_id;
        this.category_id = category_id;
        this.title = title;
    }
}
