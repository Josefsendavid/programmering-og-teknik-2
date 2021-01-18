package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author David
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Hotels.deleteAllRows", query = "DELETE from Hotel"),
@NamedQuery(name = "Hotels.getAll", query = "SELECT h FROM Hotel h")})
@Table(name = "hotels")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String title;
    private String address;
    private String price;
    private String phone;
    private String content;
    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings;

    public Hotel(String name, String title, String address, String price, String phone, String content) {
        this.name = name;
        this.title = title;
        this.address = address;
        this.price = price;
        this.phone = phone;
        this.content = content;
        this.bookings = new ArrayList();
    }

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        if(booking.getHotel()!= this) {
            booking.setHotel(this);
        }
    }

}
