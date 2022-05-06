import java.util.ArrayList;

public class Admin extends User {

    public static ArrayList<Admin> adminsArr = new ArrayList<Admin>();

    String fullName;
    String phoneNumber;

    Admin(String username, String password, String fullName, String phoneNumber) {
        super(username, password);
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin fullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public Admin phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " fullName='" + getFullName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                "}";
    }

}
