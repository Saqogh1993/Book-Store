package com.energizeglobal.bookstore.controller;

import com.energizeglobal.bookstore.repository.dto.AuthorDto;
import com.energizeglobal.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorDto> findAllAuthors() {
        return AuthorDto.mapEntitesToDto(authorService.findAllAuthors());
    }

    @PostMapping("/authors")
    @PreAuthorize("hasAuthority('ADMIN')")
    public AuthorDto saveAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.saveAuthor(authorDto);
    }
}
