package com.energizeglobal.bookstore.repository.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = ("authors"))
public class Author {

    /**************************************************************
     * FIELDS
     **************************************************************/

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "book_written_count")
    private Long bookWrittenCount;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    /**************************************************************
     * CONSTRUCTORS
     **************************************************************/

    public Author() {
    }

    public Author(String name, String surname, Long bookWrittenCount, Set<Book> books) {
        this.name = name;
        this.surname = surname;
        this.bookWrittenCount = bookWrittenCount;
        this.books = new HashSet<>();
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**************************************************************
     * EQUALS & HASHCODE
     **************************************************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    /**************************************************************
     * TO STRING
     **************************************************************/

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bookWrittenCount=" + bookWrittenCount +
                ", books=" + books +
                '}';
    }
}
