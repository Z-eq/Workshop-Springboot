package com.example.demo.data;


import com.example.demo.Entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class,id);

    }
    @Transactional(readOnly = true)
    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT a FROM AppUser a", AppUser.class).getResultList();
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public int getAppUserId() {
        return 0;
    }

}
