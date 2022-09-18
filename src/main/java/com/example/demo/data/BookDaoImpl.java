package com.example.demo.data;

import com.example.demo.Entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Collection<Book> findAll() {


        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
