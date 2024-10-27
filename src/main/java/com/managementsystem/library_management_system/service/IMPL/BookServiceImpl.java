package com.managementsystem.library_management_system.service.IMPL;

import com.managementsystem.library_management_system.dto.*;
import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.entity.Book;
import com.managementsystem.library_management_system.entity.Category;
import com.managementsystem.library_management_system.repo.AuthorRepo;
import com.managementsystem.library_management_system.repo.BookRepo;
import com.managementsystem.library_management_system.repo.CategoryRepo;
import com.managementsystem.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getTitle(),
                authorRepo.getById(bookSaveDTO.getAuthor_id()),
                categoryRepo.getById(bookSaveDTO.getCategory_id())
        );
        bookRepo.save(book);
        return book.getTitle() + " added successfully.";
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor().getId(),
                    book.getCategory().getCategory_id()
            );
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if(bookRepo.existsById(bookUpdateDTO.getId())) {
            Book book = bookRepo.getById(bookUpdateDTO.getId());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthor_id()));
            book.setCategory(categoryRepo.getById(bookUpdateDTO.getCategory_id()));
            bookRepo.save(book);
            return book.getTitle() + " updated successfully.";
        }
        else{
            System.out.println(bookUpdateDTO.getTitle() + " is not found.");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }
        else{
            System.out.println(id + " is not found.");
        }
        return null;
    }

    @Override
    public List<BookSaveDTO> search(SearchDTO searchDTO) {
        List<Book> books=new ArrayList<>();
        if(searchDTO.getAuthor()==null && searchDTO.getCategory()!=null) {
           books = bookRepo.findAllByCategory_Name(searchDTO.getCategory());

        }
        else if(searchDTO.getAuthor()!=null && searchDTO.getCategory()==null) {
             books = bookRepo.findAllByAuthor_Name(searchDTO.getAuthor());
        }
        else if(searchDTO.getAuthor()!=null && searchDTO.getCategory()!=null) {
            Category category=categoryRepo.findByName(searchDTO.getCategory());
            Author author=authorRepo.findByName(searchDTO.getAuthor());

            books = bookRepo.findAllByCategoryAndAuthor(category.getCategory_id(), author.getId());
        }

        List<BookSaveDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            BookSaveDTO bookDTO = new BookSaveDTO(
                    book.getTitle(),
                    book.getAuthor().getId(),
                    book.getCategory().getCategory_id()
            );
            bookDTOs.add(bookDTO);
        }
        return bookDTOs;
    }
}
