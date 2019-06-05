package com.energizeglobal.bookstore.repository.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    /**************************************************************
     * FIELDS
     **************************************************************/

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "page_count")
    @NotNull
    private long pageCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    @Column(name = "published_date")
    private Date publishedDate;


    /**************************************************************
     * CONSTRUCTORS
     **************************************************************/

    public Book() {
    }

    public Book(String title, long pageCount, Author author, Date publishedDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publishedDate = publishedDate;
    }


    /**************************************************************
     * GETTERS & SETTERS
     **************************************************************/


    public long getId() {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**************************************************************
     * EQUALS & HASHCODE
     **************************************************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishedDate, book.publishedDate);
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
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
