package dtos;

import entities.Booking;
import entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David
 */
public class BookingDTO {

    private Long id;
    private String startDate;
    private int nights;
    private int nightPrice;
    private String name;
    private String hotel_id;

    public BookingDTO(Booking booking) {
        this.startDate = booking.getStartDate();
        this.nights = booking.getNights();
        this.nightPrice = booking.getNightPrice();
        this.name = booking.getName();
    }
    
    private List<User> users = new ArrayList();

    public BookingDTO(String startDate, int nights, int nightPrice, String name) {
        this.startDate = startDate;
        this.nights = nights;
        this.nightPrice = nightPrice;
        this.name = name;
    }
    
        public BookingDTO(String startDate, int nights, int nightPrice, String name, String hotel_id) {
        this.startDate = startDate;
        this.nights = nights;
        this.nightPrice = nightPrice;
        this.name = name;
        this.name = hotel_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(int nightPrice) {
        this.nightPrice = nightPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
    
}