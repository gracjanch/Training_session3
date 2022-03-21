package dao;

import connection.hibernate.HibernateUtil;
import model.entity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.UserInformation;

import java.util.Collections;
import java.util.List;

public class LocationDao {
    private final Logger logger = LogManager.getLogger(CountryDao.class);
    private final UserInformation userInformation = new UserInformation();

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

    public List<String> getAllCitiesId() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<String> allCitiesId = session.createQuery("SELECT l.id FROM Location l").getResultList();

            transaction.commit();

            return allCitiesId;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }
        return Collections.emptyList();
    }
}
