import java.util.*;
import java.sql.*;
import java.io.*;

public class Connector {

    String username = "uuq3y9hxspztprg3";
    String password = "DTrrTBXZRHmXNARf7hUX";
    String databaseName = "bj0v4y1iiftvoiyqqbbs";
    String url = "jdbc:mysql://bj0v4y1iiftvoiyqqbbs-mysql.services.clever-cloud.com:3306/" + databaseName;

    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void createConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Not Working");
        }
    }


    public void setUsers(){

        try {
            resultSet = statement.executeQuery("select * from Costumers ;");

            

            while(resultSet.next()){
                String username = resultSet.getString("username") ; 
                String password = resultSet.getString("password") ; 
                String email = resultSet.getString("email") ; 
                String age = resultSet.getString("age") ; 


                Customer.customersArr.add(
                    new Customer(username, password, email, Integer.parseInt(age))
                ) ; 


            }

            resultSet = statement.executeQuery("select * from Admins") ; 
            while(resultSet.next()){
                String username = resultSet.getString("username") ; 
                String password = resultSet.getString("password") ; 
                String fullName = resultSet.getString("fullName") ; 
                String phoneNumber = resultSet.getString("phoneNumber") ;
                
                Admin.adminsArr.add(new Admin(
                    username , password , fullName , phoneNumber
                )) ; 
                System.out.println(Admin.adminsArr.get(0).username);

            }



        } catch(Exception e) {
            System.out.println("Could Not Create");
        }


    }


}
