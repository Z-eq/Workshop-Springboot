package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {


    //Constructor and Setter,Getter
    private int bookID;
    private String isbn;
    private String title;
    private int maxLoanDays;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookID() == book.getBookID() && getMaxLoanDays() == book.getMaxLoanDays() && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookID(), getIsbn(), getTitle(), getMaxLoanDays());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
