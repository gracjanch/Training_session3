package dao;

import connection.HibernateUtil;
import model.entity.Weather;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class WeatherDao {
    public void weatherByCityNameAndDate(String cityName){
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Date data1 = new Date(Calendar.getInstance().getTime().getTime());
            //

            List weathers = session.createQuery("FROM Weather w " +
                            "WHERE city_id = :city_id AND date = :date") /*and date = :date*/
                    .setParameter("city_id", cityName)
                    .setParameter("date", data1)
                    .getResultList();


            transaction.commit();

            for(Object w : weathers){
                Weather weather = (Weather)w;
                System.out.println("City: " + weather.getLocation().getCity() + " Date: " + weather.getDate()
                        + " Temperature: " + weather.getTemperature()
                        + " Pressure: " + weather.getPressure());
            }

        } catch (HibernateException hibernateException) {
            if (transaction != null)
                transaction.rollback();

            logger.error(hibernateException);
        }
    }
}
