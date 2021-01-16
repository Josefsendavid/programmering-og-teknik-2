package dtos;

import entities.Booking;
import entities.Hotel;
import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class HotelDTO {

    public int id;
    public String name;
    public String address;
    public String price;
    public String phone;
    public List<BookingDTO> bookings;
    public String url;

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.price = hotel.getPrice();
        this.phone = hotel.getPhone();
        for (Booking booking : hotel.getBookings()) {
            bookings.add(new BookingDTO(booking));
        }
    }

    public HotelDTO(int id, String name, String address, String price, String phone, List<BookingDTO> bookings, String url) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.phone = phone;
        this.bookings = bookings;
        this.url = url;
    }

    public HotelDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }
    
}
