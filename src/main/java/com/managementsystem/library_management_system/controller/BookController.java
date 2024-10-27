package com.managementsystem.library_management_system.controller;

import com.managementsystem.library_management_system.dto.*;
import com.managementsystem.library_management_system.service.AuthorService;
import com.managementsystem.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping( "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        String bookname = bookService.addBook(bookSaveDTO);
        return bookname;
    }

    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return books;
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO) {
        String bookname = bookService.updateBook(bookUpdateDTO);
        return bookname;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        String bookname = bookService.deleteBook(id);
        return "deleted successfully.";
    }

}
