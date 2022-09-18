package com.example.demo.data;

import com.example.demo.Entity.Book;

import java.util.Collection;

public interface BookDao {

    Book create(Book book);
    Book findById(int id);
    Collection<Book> findAll();
    Book update(Book book);
    void delete(int id);

}
