package com.example.demo.data;

import com.example.demo.Entity.AppUser;
import com.example.demo.Entity.Details;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional

class AppUserDaoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppUserDao appUserDao;

    private AppUser testObject;

    public List<AppUser> appUsers(){
        return Arrays.asList(
                new AppUser( "Test123", "password",
                        new Details("3433@email.com", "test tester" ,LocalDate.parse("1999-01-02"))),
                new AppUser("test222", "987654321",
                        new Details("Simon@gmail.se", "Simon blink", LocalDate.parse("1990-02-21")))
        );
    }
    @BeforeEach
    void setUp() {
        List<AppUser> persistedAppUser =
                appUsers().stream()
                        .map(entityManager::persist)
                        .collect(Collectors.toList());

        testObject = (AppUser) persistedAppUser.get(0);
    }

    @Test
    void findById() {
        AppUser foundAppUser = appUserDao.findById(testObject.getAppUserId());

        assertNotNull(foundAppUser);
    }

    @Test
    void findAll() {
        Collection<AppUser> found = appUserDao.findAll();

        assertNotNull(found);
        assertEquals(2, found.size());

    }

    @Test
    void create() {

        AppUser appUser = new AppUser("Erik","123", null);

        AppUser persistedUser = appUserDao.create(appUser);

        assertNotNull(persistedUser);
        assertNotEquals(0,persistedUser.getAppUserId());
        assertNotNull(entityManager.find(AppUser.class, persistedUser.getAppUserId()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

        assertNotNull(entityManager.find(AppUser.class, testObject.getAppUserId()));

        appUserDao.delete(testObject.getAppUserId());

        assertNull(entityManager.find(AppUser.class, testObject.getAppUserId()));
    }
}