/*
 * Bean for drop off reservations
 * @author Cameron
 */
package edu.ccsu.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

@ManagedBean
@Named
public class ReserveDropBean {
    @PersistenceUnit(unitName = "FinalProjectPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{reservationDrop}")
    private ReservationDrop reservationDrop;
    
    public ReservationDrop  getReservationDrop() {
        return reservationDrop;
    }
    public void setReservationDrop(ReservationDrop reservationDrop){
        this.reservationDrop = reservationDrop;
    }    
    
    /*Saving to database*/
    public String saveInfo() 
    {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.persist(reservationDrop);
            userTransaction.commit();
            em.close();
            returnValue = "DropConfirm";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    /*Searching by email*/
    public List getMatchingEmail() {
        List<ReservationDrop> reservationDrops = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select r from ReservationDrop r where r.email like :email";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("email", reservationDrop.getEmail() + "%");
            reservationDrops = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationDrops;
    }
    
    /*Searching by reservation ID*/
    public ReservationDrop getMatchingId() {        
        List<ReservationDrop> reservationDrops = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select r from ReservationDrop r where r.id like :id";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("id", reservationDrop.getId() + "%");
            reservationDrops = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationDrops.get(0);
    }
    
    /*Deletes a reseravation.*/
    public String delete(Integer i) {
        String returnValue = "error";
        String selectSQL = "delete from RESERVATIONDROP id = :i";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            Query selectQuery = em.createQuery(selectSQL);
            userTransaction.commit();
            em.close();
            returnValue = "DropDeleteConfirm";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    /*Update a reservation.*/
    public String update(String airport, String ampm, int day, int month,
                         int year, int hour, int minute) {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            reservationDrop.setAirport(airport);
            reservationDrop.setAmpm(ampm);
            reservationDrop.setrDay(day);
            reservationDrop.setrMonth(month);
            reservationDrop.setrYear(year);
            reservationDrop.setrHour(hour);
            reservationDrop.setrMinute(minute);
            userTransaction.commit();
            em.close();
            returnValue = "DropUpdateConfirm";
        } catch (Exception e) {
            e.printStackTrace();
        }                
        return returnValue;
    }    
}
