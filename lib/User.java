public class User {

    public static User loggedInUser = new User("User" , "1234"); 

    String username;
    String password;



    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setUser(User user){
        loggedInUser = user ; 
    }


}
