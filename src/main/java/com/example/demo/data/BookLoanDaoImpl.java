package com.example.demo.data;

import com.example.demo.Entity.BookLoan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository

public class BookLoanDaoImpl implements BookLoanDao{

    @PersistenceContext

    private EntityManager entityManager;

    @Override
    public BookLoan create(BookLoan bookloan) {
        entityManager.persist(bookloan);

        return bookloan;
    }

    @Override
    public BookLoan findById(int id) {
        return null;
    }

    @Override
    public Collection<BookLoan> findAll() {

        return entityManager.createQuery("SELECT bl FROM BookLoan bl", BookLoan.class).getResultList();
    }

    @Override
    public BookLoan update(BookLoan bookloan) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
