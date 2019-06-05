package com.energizeglobal.bookstore.service;

import com.energizeglobal.bookstore.repository.dto.BookDto;
import com.energizeglobal.bookstore.repository.entity.Book;
import com.energizeglobal.bookstore.repository.interfaces.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }

    public BookDto saveBook(BookDto bookDto) {
        Book book = BookDto.mapDtoToEntity(bookDto);
        bookRepository.save(book);

        return BookDto.mapEntityToDto(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteBookById(id);
    }

    public List<BookDto> findBookByTitle(String title) {
        return BookDto.mapEntitesToDto(bookRepository.findBooksByTitle(title));
    }
}
