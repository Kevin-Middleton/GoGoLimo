/*
 * Bean for pick up reservations
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
public class ReservePickBean {
    @PersistenceUnit(unitName = "FinalProjectPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
    @ManagedProperty(value = "#{reservationPickUp}")
    private ReservationPickUp reservationPickUp;
    
    public ReservationPickUp getReservationPickUp() {
        return reservationPickUp;
    }
    public void setReservationPickUp(ReservationPickUp reservationPickUp){
        this.reservationPickUp = reservationPickUp;
    }    
    
    /*Saves information.*/
    public String saveInfo() 
    {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.persist(reservationPickUp);
            userTransaction.commit();
            em.close();
            returnValue = "PickConfirm";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    /*Gets a list of matchign emails, returns list.*/
    public List getMatchingEmail() {
        List<ReservationPickUp> reservationPicks = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select r from ReservationPickUp r where r.email like :email";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("email", reservationPickUp.getEmail() + "%");
            reservationPicks = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return reservationPicks;
    }
    
    /*Gets a list of matching ID's returns first reservation in list.*/
    public ReservationPickUp getMatchingId() {        
        List<ReservationPickUp> reservationPicks = new ArrayList();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String selectSQL = "select r from ReservationPickUp r where r.id like :id";
        try {
            Query selectQuery = entityManager.createQuery(selectSQL);
            selectQuery.setParameter("id", reservationPickUp.getId() + "%");
            reservationPicks = selectQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return reservationPicks.get(0);
    }
    
    /*Deletes a reseravation.*/
    public String delete() {
        String returnValue = "error";
        try {
            userTransaction.begin();
            EntityManager em = entityManagerFactory.createEntityManager();
            em.remove(reservationPickUp);
            userTransaction.commit();
            em.close();
            returnValue = "PickDeleteConfirm";
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
            reservationPickUp.setAirport(airport);
            reservationPickUp.setAmpm(ampm);
            reservationPickUp.setrDay(day);
            reservationPickUp.setrMonth(month);
            reservationPickUp.setrYear(year);
            reservationPickUp.setrHour(hour);
            reservationPickUp.setrMinute(minute);
            userTransaction.commit();
            em.close();
            returnValue = "PickUpdateConfirm";
        } catch (Exception e) {
            e.printStackTrace();
        }                
        return returnValue;
    }
}
    
