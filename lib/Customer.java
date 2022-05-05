import java.util.ArrayList;

public class Customer  extends User {

    public static ArrayList<Customer> customersArr = new ArrayList<Customer>();




    Customer(String username , String password , String email , int age){
        super(username, password) ; 
        this.email = email ; 
        this.age = age ;
    }

    String email ; 
    int age ;





}
