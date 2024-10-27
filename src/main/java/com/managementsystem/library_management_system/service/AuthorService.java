package com.managementsystem.library_management_system.service;

import com.managementsystem.library_management_system.dto.AuthorDTO;
import com.managementsystem.library_management_system.dto.AuthorSaveDTO;
import com.managementsystem.library_management_system.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {

    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthors();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
