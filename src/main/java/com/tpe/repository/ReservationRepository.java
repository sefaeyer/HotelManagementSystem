package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepository {
    private Session session;

    public Reservation findById(Long id) {

        session = HibernateUtils.getSessionFactory().openSession();

        Reservation reservation = session.get(Reservation.class, id);
        HibernateUtils.closeSession(session);
        return reservation;


    }

    //odev 5
    public List<Reservation> findAll() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<Reservation> reservations = session.createQuery("FROM Reservation", Reservation.class).getResultList();
        if (reservations.isEmpty()) {
            System.out.println("Reservation is empty");
        }
        HibernateUtils.closeSession(session);
        return reservations;
    }

    //11-c
    public void save(Reservation reservation) {
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            Transaction transaction= session.beginTransaction();
            session.save(reservation);//insert into t_reservation values
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    //12-c
    public void delete(Reservation reservation) {
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            Transaction transaction= session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}
