package dao;

import connection.HibernateUtil;
import model.entity.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountryDao {
    private final Logger logger = LogManager.getLogger(CountryDao.class);

    public void displayAllCountries(String id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Country country = session.get(Country.class, id);

            transaction.commit();

            System.out.println(country);

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }
    }
}
