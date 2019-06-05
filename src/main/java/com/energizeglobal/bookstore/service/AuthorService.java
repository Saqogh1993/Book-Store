package com.energizeglobal.bookstore.service;

import com.energizeglobal.bookstore.repository.dto.AuthorDto;
import com.energizeglobal.bookstore.repository.entity.Author;
import com.energizeglobal.bookstore.repository.interfaces.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author author = AuthorDto.mapDtoToEntity(authorDto);
        authorRepository.save(author);
        return AuthorDto.mapEntityToDto(author);
    }
}
