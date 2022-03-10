package dao;

import connection.HibernateUtil;
import model.entity.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class CountryDao {
    private final Logger logger = LogManager.getLogger(CountryDao.class);

    public List<String> getAllCountriesId() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List<String> allCountriesId = session.createQuery("SELECT c.countryId FROM Country c").getResultList();

            transaction.commit();

            return allCountriesId;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }
        return Collections.emptyList();
    }
}
