package com.energizeglobal.bookstore.repository.interfaces;

import com.energizeglobal.bookstore.repository.dto.BookDto;
import com.energizeglobal.bookstore.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);
    void deleteBookById(Long id);

    @Query(value = "SELECT * FROM books b  WHERE b.title ILIKE %:title% --#pageable\n", nativeQuery = true)
    List<Book> findBooksByTitle(@Param("title") String title);
}
