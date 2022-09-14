package com.example.demo.data;


import com.example.demo.Entity.Details;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Transactional(readOnly = true)
    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT details FROM Details details",Details.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));

    }
}
