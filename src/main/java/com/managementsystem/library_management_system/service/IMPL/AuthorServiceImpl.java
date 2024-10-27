package com.managementsystem.library_management_system.service.IMPL;

import com.managementsystem.library_management_system.dto.AuthorDTO;
import com.managementsystem.library_management_system.dto.AuthorSaveDTO;
import com.managementsystem.library_management_system.dto.AuthorUpdateDTO;
import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.repo.AuthorRepo;
import com.managementsystem.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {

        Author author = new Author(authorSaveDTO.getName());
        authorRepo.save(author);
        return author.getName() + " added successfully.";
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();
        List<AuthorDTO> authorDTOs = new ArrayList<>();
        for (Author author : authors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getId(),
                    author.getName()
            );
            authorDTOs.add(authorDTO);
        }
        return authorDTOs;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
        if(authorRepo.existsById(authorUpdateDTO.getId())) {
            Author author = authorRepo.getById(authorUpdateDTO.getId());
            author.setName(authorUpdateDTO.getName());
            authorRepo.save(author);
            return author.getName() + " updated successfully.";
        }
        else{
            System.out.println(authorUpdateDTO.getName() + " is not found.");
        }
        return null;

    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        }
        else{
            System.out.println(id + " is not found.");
        }
        return null;
    }
}
