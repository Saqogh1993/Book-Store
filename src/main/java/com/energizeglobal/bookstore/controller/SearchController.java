package com.energizeglobal.bookstore.controller;

import com.energizeglobal.bookstore.repository.dto.BookDto;
import com.energizeglobal.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private BookService bookService;

    @Autowired
    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public List<BookDto> findBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }
}
