package com.energizeglobal.bookstore.controller;

import com.energizeglobal.bookstore.repository.dto.BookDto;
import com.energizeglobal.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDto> findAllBooks() {
        return BookDto.mapEntitesToDto(bookService.findAllBooks());
    }

    @GetMapping("/books/{id}")
    public BookDto findBookById(@PathVariable long id) {
        return BookDto.mapEntityToDto(bookService.findBookById(id));
    }

    @PostMapping("/books")
    @PreAuthorize("hasAuthority('ADMIN')")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

    @DeleteMapping("/books/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }
}
