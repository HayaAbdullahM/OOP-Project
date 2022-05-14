import java.util.ArrayList;

public class Ticket {

    public static ArrayList<Ticket> ticketsArr = new ArrayList<Ticket>();

    String username;
    int adults;
    int kids;
    int totalPrice;
    String cardHolder;
    String cardNumber;
    String expiryDate;
    int pinCode;

    public Ticket(String username, int adults, int kids, int totalPrice, String cardHolder, String cardNumber,
            String expiryDate, int pinCode) {
        this.username = username;
        this.adults = adults;
        this.kids = kids;
        this.totalPrice = totalPrice;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.pinCode = pinCode;
    }

}
