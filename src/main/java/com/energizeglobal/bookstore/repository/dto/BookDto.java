package com.energizeglobal.bookstore.repository.dto;

import com.energizeglobal.bookstore.repository.entity.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BookDto implements Serializable {

    /**************************************************************
     * FIELDS
     **************************************************************/

    private Long id;
    private String title;
    private long pageCount;
    private Date publishedDate;
    private AuthorDto authorDto;

    /**************************************************************
     * MAPPERS FROM ENTITY(S) TO DTO(S) AND DTO(S) TO ENTITY(S)
     **************************************************************/

    public static List<BookDto> mapEntitesToDto(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        if (books == null)
            return bookDtos;

        for (Book book : books) {
            bookDtos.add(mapEntityToDto(book));
        }

        return bookDtos;
    }

    public static BookDto mapEntityToDto(Book book) {
        if (book == null)
            return null;

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setPageCount(book.getPageCount());
        bookDto.setPublishedDate(book.getPublishedDate());
        bookDto.setAuthorDto(AuthorDto.mapEntityToDto(book.getAuthor()));

        return bookDto;
    }

    public static Book mapDtoToEntity(BookDto bookDto) {
        if (bookDto == null)
            return null;

        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setPageCount(bookDto.getPageCount());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setAuthor(AuthorDto.mapDtoToEntity(bookDto.getAuthorDto()));

        return book;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    /**************************************************************
     * EQUALS & HASHCODE
     **************************************************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return pageCount == bookDto.pageCount &&
                Objects.equals(id, bookDto.id) &&
                Objects.equals(title, bookDto.title) &&
                Objects.equals(publishedDate, bookDto.publishedDate) &&
                Objects.equals(authorDto, bookDto.authorDto);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

}
