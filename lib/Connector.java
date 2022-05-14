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

    public void addCostumer(String username, String password, String email, String age) {
        PreparedStatement createStatement;
        try {
            createStatement = connection.prepareStatement(
                    "INSERT INTO Costumers VALUES (? , ? , ? , ?) ; ");
            createStatement.setString(1, username);
            createStatement.setString(2, password);
            createStatement.setString(3, email);
            createStatement.setString(4, age);

            createStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Nope");
        }
    }

    public void addMovie(Movie movie) {
        PreparedStatement createStatement;
        try {

            if (movie.type.equals("Now-Showing")) {
                createStatement = connection.prepareStatement(
                        "INSERT INTO `nowShowing` (`id`, `title`, `genre`,  `language` ,`duration`, `ageRestriction`, `IMDb`, `showDate`, `showTime`, `imageLink`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");

            } else {
                createStatement = connection.prepareStatement(
                        "INSERT INTO `upComing` (`id`, `title`, `genre`,  `language` ,`duration`, `ageRestriction`, `IMDb`, `showDate`, `showTime`, `imgLink`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");

            }


        if(movie.imgLink.equals("")){
            System.out.println("No Image");
        }    

            createStatement.setString(1, movie.id);
            createStatement.setString(2, movie.title);
            createStatement.setString(3, movie.genre);
            createStatement.setString(4, movie.language);
            createStatement.setInt(5, Integer.parseInt(movie.duration));
            createStatement.setString(6, movie.ageRestriction);
            createStatement.setString(7, movie.IMDb);
            createStatement.setString(8, movie.showDate);
            createStatement.setString(9, movie.showTime);
            createStatement.setString(10, movie.imgLink);

            createStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Nope");
        }
    }

    public void setUsers() {

        try {
            resultSet = statement.executeQuery("select * from Costumers ;");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String age = resultSet.getString("age");

                Customer.customersArr.add(
                        new Customer(username, password, email, Integer.parseInt(age)));

            }

            resultSet = statement.executeQuery("select * from Admins");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phoneNumber = resultSet.getString("phoneNumber");

                Admin.adminsArr.add(new Admin(
                        username, password, fullName, phoneNumber));

            }

        } catch (Exception e) {
            System.out.println("Could Not Get Users");
        }

    }

    public void setMovies() {

        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM `nowShowing`");

            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String language = rs.getString("language");
                String duration = rs.getInt("duration") + "";
                String ageRestriction = rs.getString("ageRestriction");
                String IMDb = rs.getString("IMDb");
                String showDate = rs.getString("showDate");
                String showTime = rs.getString("showTime");
                String imgLink = rs.getString("imageLink");

                Movie.moviesArr.add(new Movie(id, title, genre, language, duration, ageRestriction, IMDb, showDate,
                        showTime, "Now-Showing", imgLink));

            }

            rs = statement.executeQuery("SELECT * FROM `upComing`");

            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String language = rs.getString("language");
                String duration = rs.getInt("duration") + "";
                String ageRestriction = rs.getString("ageRestriction");
                String IMDb = rs.getString("IMDb");
                String showDate = rs.getString("showDate");
                String showTime = rs.getString("showTime");
                String imgLink = rs.getString("imgLink");

                Movie.moviesArr.add(new Movie(id, title, genre, language, duration, ageRestriction, IMDb, showDate,
                        showTime, "Up-Coming", imgLink));

            }

        } catch (Exception e) {
            System.out.println("Could Not Set Movies : " + e.getMessage());
        }

    }

    public void deleteMovie(String movieId) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Movies WHERE id = ? ");
            preparedStatement.setString(1, movieId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

}
