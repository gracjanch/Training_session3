package dao;

import connection.hibernate.HibernateUtil;
import model.entity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class LocationDao {
    private final Logger logger = LogManager.getLogger(CountryDao.class);

    public List<Location> getAllLocations() {
        Transaction transaction = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List locations = session.createQuery("FROM Location").getResultList();

            transaction.commit();

            return locations;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    public void addLocation(Location location) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(location);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.info(e.getMessage());
        }
    }

    public void deleteLocation(Location location) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(location);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.info(e.getMessage());
        }
    }

    public Location findById(String id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Location location = session.createQuery("FROM Location WHERE city_id = :cityId", Location.class)
                    .setParameter("cityId", id)
                    .getSingleResult();

            transaction.commit();

            return location;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.info(e.getMessage());
        }
        return null;
    }

    public void updateLocation(Location location) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(location);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }
    }

}
