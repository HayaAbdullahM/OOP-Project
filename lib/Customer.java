import java.util.ArrayList;

public class Customer extends User {
    
    public static ArrayList<Customer> customersArr = new ArrayList<Customer>();
    int age;
    
    Customer(String username, String password, String email, int age) {
        super(username, password);
        this.email = email;
        this.age = age;
    }

    String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    public Customer age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " email='" + getEmail() + "'" +
                ", age='" + getAge() + "'" +
                "}";
    }


}
