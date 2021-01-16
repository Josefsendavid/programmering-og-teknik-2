package dtos;

import entities.Booking;
import entities.Creditcard;
import entities.User;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    public String userName;
    public String userPass;
    public String phone;
    public List<CreditcardDTO> creditCards;
    public List<BookingDTO> bookings;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
    }

    public UserDTO(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<UserDTO> toDTO(List<User> persons) {
        List<UserDTO> dtoes = new ArrayList();
        for (User u : persons) {
            dtoes.add(new UserDTO(u));
        }
        return dtoes;
    }

}
