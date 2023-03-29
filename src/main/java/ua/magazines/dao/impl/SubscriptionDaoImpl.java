package ua.magazines.dao.impl;

import org.apache.log4j.Logger;
import ua.magazines.dao.SubscriptionDao;
import ua.magazines.entity.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {

    private static final Logger LOGGER = Logger.getLogger(SubscriptionDaoImpl.class);

    @Override
    public Subscription create(Subscription subscription) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return subscription;
    }

    @Override
    public Subscription read(Integer id) {
        Subscription subscription = null;
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return subscription;
    }

    @Override
    public Subscription update(Subscription subscription) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return subscription;
    }

    @Override
    public void delete(Integer id) {
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Subscription> readAll() {
        List<Subscription> subscriptionRecords = new ArrayList<>();
        try {
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return subscriptionRecords;
    }
}
