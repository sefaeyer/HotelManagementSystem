package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//todo Room Guest ve Reservation icin service ve repo classlarini olusturalim : ODEV !!!
public class HotelRepository {

    private Session session;
    //1-b:
    public void save(Hotel hotel){

        try {
            session=HibernateUtils.getSessionFactory().openSession();
            Transaction transaction= session.beginTransaction();
            session.save(hotel);//insert into t_hotel values
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }

    }
}
