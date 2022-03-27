package dao;

import connection.hibernate.HibernateUtil;
import model.entity.Weather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class WeatherDao {
    private final Logger logger = LogManager.getLogger();

    public List<Weather> weatherByCityNameAndDate(List<String> cityIds){
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Date currentDate = new Date(Calendar.getInstance().getTime().getTime());


            List weathers = session.createQuery("FROM Weather w " +
                            "WHERE city_id IN :city_ids AND date = :date")
                    .setParameter("city_ids", cityIds)
                    .setParameter("date", currentDate)
                    .getResultList();


            transaction.commit();

            return weathers;

        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException);
        }
        return Collections.emptyList();
    }

    public void saveWeather(Weather weather) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(weather);


            transaction.commit();

        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException);
        }
    }

    public List<Weather> getAllWeathers() {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            List weathers = session.createQuery("FROM Weather").getResultList();

            transaction.commit();

            return weathers;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.error(e.getMessage(), e);
        }

        return Collections.emptyList();
    }

    public void deleteWeather(Weather weather){
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.delete(weather);

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

            logger.info(e.getMessage());
        }
    }

}
