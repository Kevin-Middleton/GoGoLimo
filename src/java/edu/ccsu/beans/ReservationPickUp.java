/* ReservationBean.java                 @author(Cameron)           */
/* All data for a users registration from product select page.     */
package edu.ccsu.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SessionScoped
@ManagedBean(name = "reservationPickUp")
public class ReservationPickUp implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;   
    private String firstName;
    private String lastName;
    private String email;
    private String airport = "JFK";
    private int rDay;
    private int rMonth;
    private int rYear;
    private int rHour;
    private int rMinute;
    private String ampm;
    

    
    public ReservationPickUp() {
        /*Left empty.*/
    }
    
    /*SETTERS*/
    public void setId(Integer i) {
        this.id = i;
    }   
    
    public void setFirstName(String s){
        this.firstName = s;
    }
    
    public void setLastName(String s){
        this.lastName = s;
    }
    
    public void setEmail(String s){
        this.email = s;
    }
    public void setAirport(String s) {
        this.airport = s;
    }    
    public void setrDay(int i) {
        this.rDay = i;
    }    
    public void setrMonth(int i) {
        this.rMonth = i;
    }
    public void setrYear(int i) {
        this.rYear = i;
    }
    public void setrHour(int i) {
        this.rHour = i;
    }
    public void setrMinute(int i) {
        this.rMinute = i;
    }    
    public void setAmpm(String s) {
        this.ampm = s;
    }

    
    /*GETTERS*/
    public Integer getId() {
        return id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getEmail(){
        return email;
    }
    public String getAirport() {
        return airport;
    }
    public int getrDay() {
        return rDay;
    }
    public int getrMonth() {
        return rMonth;
    }
    public int getrYear() {
        return rYear;
    }
    public int getrHour() {
        return rHour;
    }
    public int getrMinute() {
        return rMinute;
    }
    public String getAmpm() {
        return ampm;
    }


    
        
    @Override
    public String toString() {
        String s = airport + " airport at " + rHour + ":";
        if (rMinute == 0)   {s += "00";}
        else                {s += rMinute;}
        
        s += " " + ampm + ". " + rDay + " ";
        if      (rMonth == 1)   {s+="January";}
        else if (rMonth == 2)   {s+="February";}
        else if (rMonth == 3)   {s+="March";}
        else if (rMonth == 4)   {s+="April";}
        else if (rMonth == 5)   {s+="May";}
        else if (rMonth == 6)   {s+="June";}
        else if (rMonth == 7)   {s+="July";}
        else if (rMonth == 8)   {s+="August";}
        else if (rMonth == 9)   {s+="September";}
        else if (rMonth == 10)  {s+="October";}
        else if (rMonth == 11)  {s+="November";}
        else                    {s+="December";}
                
        s += " " + rYear + ".";
        return s;
    }
    public String idString() {
        return "Reservation Pick up ID # " + id;
    }
    
    
    
}
