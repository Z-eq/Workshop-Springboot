package com.example.demo.data;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {

    BookLoan create(BookLoan bookloan);
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookloan);
    void delete(int id);
}
