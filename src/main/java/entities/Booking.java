package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author David
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Booking.deleteAllRows", query = "DELETE from Booking"),
@NamedQuery(name = "Booking.getAll", query = "SELECT b FROM Booking b")})
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
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    @ManyToOne
    private User user;

    public Booking(Long id, String startDate, int nights, int nightPrice, Hotel hotel) {
        this.id = id;
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
    
    public void setHotelBooking(Hotel hotel) {
        this.hotel = hotel;
        if (!hotel.getBookings().contains(this)) {
            hotel.getBookings().add(this);
        }
    }
}
