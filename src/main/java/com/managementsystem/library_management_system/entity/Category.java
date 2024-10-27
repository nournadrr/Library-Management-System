package com.managementsystem.library_management_system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", length = 11)
    private int category_id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public Category(int category_id, String name, List<Book> books) {
        this.category_id = category_id;
        this.name = name;
        this.books = books;
    }

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
