package ua.magazines.dao.impl;

import org.apache.log4j.Logger;
import ua.magazines.dao.UserDao;
import ua.magazines.entity.User;
import ua.magazines.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public User create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        List<User> userRecords = new ArrayList<>();
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return userRecords;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            user = query.getSingleResult();

        } catch (Exception e) {
            LOGGER.error(e);
        }
        return user;
    }
}
