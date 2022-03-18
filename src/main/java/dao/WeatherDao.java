package dao;

import connection.HibernateUtil;
import model.entity.Weather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.UserInformation;


import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class WeatherDao {
    private final Logger logger = LogManager.getLogger();
    private final UserInformation userInformation = new UserInformation();

    public List<Weather> weatherByCityNameAndDate(String cityName){
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Date data1 = new Date(Calendar.getInstance().getTime().getTime());


            List weathers = session.createQuery("FROM Weather w " +
                            "WHERE city_id = :city_id AND date = :date")
                    .setParameter("city_id", cityName)
                    .setParameter("date", data1)
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
}
