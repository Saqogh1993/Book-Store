package com.energizeglobal.bookstore.repository.dto;

import com.energizeglobal.bookstore.repository.entity.Author;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorDto implements Serializable {

    /**************************************************************
     * FIELDS
     **************************************************************/

    private Long id;
    private String name;
    private String surname;
    private Long bookWrittenCount;

    /**************************************************************
     * MAPPERS FROM ENTITY(S) TO DTO(S) AND DTO(S) TO ENTITY(S)
     **************************************************************/

    public static List<AuthorDto> mapEntitesToDto(List<Author> authors) {
        List<AuthorDto> authorDtos = new ArrayList<>();
        if (authors == null)
            return authorDtos;

        for (Author author : authors) {
            authorDtos.add(mapEntityToDto(author));
        }
        return authorDtos;
    }

    public static AuthorDto mapEntityToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        if (author == null)
            return null;

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        authorDto.setBookWrittenCount(author.getBookWrittenCount());

        return authorDto;
    }

    public static Author mapDtoToEntity(AuthorDto authorDto) {
        Author author = new Author();
        if (authorDto == null)
            return author;
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setBookWrittenCount(authorDto.getBookWrittenCount());

        return author;
    }

    /**************************************************************
     * GETTERS & SETTERS
     **************************************************************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getBookWrittenCount() {
        return bookWrittenCount;
    }

    public void setBookWrittenCount(Long bookWrittenCount) {
        this.bookWrittenCount = bookWrittenCount;
    }

    /**************************************************************
     * EQUALS & HASHCODE
     **************************************************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id) &&
                Objects.equals(name, authorDto.name) &&
                Objects.equals(surname, authorDto.surname) &&
                Objects.equals(bookWrittenCount, authorDto.bookWrittenCount);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
