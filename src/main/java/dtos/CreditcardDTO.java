package dtos;

import entities.Creditcard;
import java.util.Date;

/**
 *
 * @author David
 */
public class CreditcardDTO {

    private String type;
    private int cardNumber;
    private String expireDate;
    private String nameOnCard;

    public CreditcardDTO(Creditcard creditcard) {
        this.type = creditcard.getType();
        this.cardNumber = creditcard.getCardNumber();
        this.expireDate = creditcard.getExpireDate();
        this.nameOnCard = creditcard.getNameOnCard();
    }

    CreditcardDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}