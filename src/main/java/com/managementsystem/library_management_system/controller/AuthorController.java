package com.managementsystem.library_management_system.controller;

import com.managementsystem.library_management_system.dto.AuthorDTO;
import com.managementsystem.library_management_system.dto.AuthorSaveDTO;
import com.managementsystem.library_management_system.dto.AuthorUpdateDTO;
import com.managementsystem.library_management_system.entity.Author;
import com.managementsystem.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping( "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO) {
        String authorname = authorService.addAuthor(authorSaveDTO);
        return authorname;
    }

    @GetMapping("/getAllAuthors")
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return authors;
    }

    @PutMapping("/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO) {
        String authorname = authorService.updateAuthor(authorUpdateDTO);
        return authorname;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id) {
        String authorname = authorService.deleteAuthor(id);
        return "deleted successfully.";
    }


}
