package com.managementsystem.library_management_system.service;

import com.managementsystem.library_management_system.dto.BookDTO;
import com.managementsystem.library_management_system.dto.BookSaveDTO;
import com.managementsystem.library_management_system.dto.BookUpdateDTO;
import com.managementsystem.library_management_system.dto.SearchDTO;

import java.util.List;

public interface BookService {


    public String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBooks();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);

    List<BookSaveDTO> search(SearchDTO searchDTO);
}
