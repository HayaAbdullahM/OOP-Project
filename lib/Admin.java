import java.util.ArrayList;

public class Admin  extends User{

    public static ArrayList<Admin> adminsArr = new ArrayList<Admin>() ; 

    String fullName ; 
    String phoneNumber ;



    Admin(String username, String password , String fullName , String phoneNumber) {
        super(username, password);
        this.fullName = fullName ; 
        this.phoneNumber = phoneNumber ; 
    }
    
}
