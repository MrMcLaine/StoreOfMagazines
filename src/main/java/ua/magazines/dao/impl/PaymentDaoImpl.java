package ua.magazines.dao.impl;

import org.apache.log4j.Logger;
import ua.magazines.dao.PaymentDao;
import ua.magazines.entity.Payment;
import ua.magazines.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final Logger LOGGER = Logger.getLogger(PaymentDaoImpl.class);
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Payment create(Payment payment) {
        try {
            em.getTransaction().begin();
            em.persist(payment);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return payment;
    }

    @Override
    public Payment read(Integer id) {
        Payment payment = null;
        try {
            payment = em.find(Payment.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return payment;
    }

    @Override
    public void delete(Integer id) {
        try {
            Payment payment = read(id);
            em.getTransaction().begin();
            em.remove(payment);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Payment> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT p FROM Payment p");
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return query.getResultList();
    }
}
