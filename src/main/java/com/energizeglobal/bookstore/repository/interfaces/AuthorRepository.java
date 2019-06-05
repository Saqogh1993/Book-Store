package com.energizeglobal.bookstore.repository.interfaces;

import com.energizeglobal.bookstore.repository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
