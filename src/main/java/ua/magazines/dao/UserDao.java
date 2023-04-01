package ua.magazines.dao;

import ua.magazines.entity.User;
import ua.magazines.shared.AbstractCrud;

import javax.persistence.EntityManager;

public interface UserDao extends AbstractCrud<User> {
    User getUserByEmail(String email);

    EntityManager getEntityManager();
}
