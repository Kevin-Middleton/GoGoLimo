/* ReservationBean.java                 @author(Cameron)           */
/* All data for a users registration from product select page.     */
package edu.ccsu.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATIONDROP")
@ManagedBean(name = "reservationDrop")
public class ReservationDrop implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "AIRPORT")
    private String airport = "JFK";
    @Column(name = "RDAY")
    private int rDay;
    @Column(name = "RMONTH")
    private int rMonth;
    @Column(name = "RYEAR")
    private int rYear;
    @Column(name = "RHOUR")
    private int rHour;
    @Column(name = "RMINUTE")
    private int rMinute;
    @Column(name = "AMPM")
    private String ampm;
    
    
    public ReservationDrop() {
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
        if (rMinute == 0) {s += "00";}
        else {s += rMinute;}
        
        s += " " + ampm + ". " + rDay + " ";
        if (rMonth == 1) {s+="January";}
        else if (rMonth == 2) {s+="February";}
        else if (rMonth == 3) {s+="March";}
        else if (rMonth == 4) {s+="April";}
        else if (rMonth == 5) {s+="May";}
        else if (rMonth == 6) {s+="June";}
        else if (rMonth == 7) {s+="July";}
        else if (rMonth == 8) {s+="August";}
        else if (rMonth == 9) {s+="September";}
        else if (rMonth == 10) {s+="October";}
        else if (rMonth == 11) {s+="November";}
        else {s+="December";}                
                
        s += " " + rYear + ".";
        return s;
    }
    
    public String idString() {
        return "Reservation Drop off ID # " + id;
    }
}
