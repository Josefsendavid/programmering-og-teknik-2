package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author David
 */
@Entity
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private int nights;
    private int nightPrice;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Hotel hotel;
    @ManyToOne
    private User user;

    public Booking(String startDate, int nights, int nightPrice) {
        this.startDate = startDate;
        this.nights = nights;
        this.nightPrice = nightPrice;
        this.hotel = hotel;
    }

    public Booking(String startDate, int nights, int nightPrice, String name) {
        this.startDate = startDate;
        this.nights = nights;
        this.nightPrice = nightPrice;
        this.name = name;
    }

    public Booking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
