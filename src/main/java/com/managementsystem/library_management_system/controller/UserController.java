package com.managementsystem.library_management_system.controller;

import com.managementsystem.library_management_system.dto.BookDTO;
import com.managementsystem.library_management_system.dto.BookSaveDTO;
import com.managementsystem.library_management_system.dto.SearchDTO;
import com.managementsystem.library_management_system.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


    private final BookService bookService;

    public UserController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/search")
    public List<BookSaveDTO> search(@RequestBody SearchDTO searchDTO) {
        return bookService.search(searchDTO);
    }

    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return books;
    }
}
