package ua.magazines.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.magazines.dao.UserDao;
import ua.magazines.entity.Role;
import ua.magazines.entity.User;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static ua.magazines.TestData.*;

public class UserDaoImplTest {

    private UserDao userDao;
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
        em = userDao.getEntityManager();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

        User uFromDB = userDao.create(CREATED_USER);
        assertNotNull(uFromDB.getId());
        assertEquals("testFirstName", uFromDB.getFirstName());
        assertEquals("testLastName", uFromDB.getLastName());
        assertEquals("test@example.com", uFromDB.getEmail());
        assertEquals("password", uFromDB.getPassword());
        assertEquals(Role.USER, uFromDB.getRole());
    }

    @Test
    public void read() {
        User user = userDao.create(CREATED_USER);
        Integer id = user.getId();
        User persistedUser = userDao.read(id);
        assertNotNull(persistedUser);
        assertEquals("testFirstName", user.getFirstName());
        assertEquals("testLastName", user.getLastName());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    public void getUserByEmail() {
        userDao.create(CREATED_USER);
        User persistedUser = userDao.getUserByEmail("test@example.com");
        assertNotNull(persistedUser);
        assertEquals("testFirstName", persistedUser.getFirstName());
        assertEquals("testLastName", persistedUser.getLastName());
        assertEquals("test@example.com", persistedUser.getEmail());
        assertEquals("password", persistedUser.getPassword());
        assertEquals(Role.USER, persistedUser.getRole());
    }
}