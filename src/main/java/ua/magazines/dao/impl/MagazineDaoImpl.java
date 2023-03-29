package ua.magazines.dao.impl;

import org.apache.log4j.Logger;
import ua.magazines.dao.MagazineDao;
import ua.magazines.entity.Magazine;
import ua.magazines.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MagazineDaoImpl implements MagazineDao {

    private static final Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Magazine create(Magazine magazine) {
        try {
            em.getTransaction().begin();
            em.persist(magazine);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return magazine;
    }

    @Override
    public Magazine read(Integer id) {
        Magazine magazine = null;
        try {
            magazine = em.find(Magazine.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return magazine;
    }

    @Override
    public Magazine update(Magazine magazine) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return magazine;
    }

    @Override
    public void delete(Integer id) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Magazine> readAll() {
        Query magazineRecords = null;
        try {
            magazineRecords = em.createQuery("SELECT m FROM Magazine m");
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return magazineRecords != null ? magazineRecords.getResultList() : null;
    }
}
