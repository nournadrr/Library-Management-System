package com.managementsystem.library_management_system.dto;

public class SearchDTO {
    private String author;
    private String category;

    public SearchDTO(String author, String category) {
        this.author = author;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
