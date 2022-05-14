import java.util.ArrayList;
import java.util.Random;

public class Movie {

    public static ArrayList<Movie> moviesArr = new ArrayList<Movie>();

    String id;
    String title;
    String genre;
    String language;
    String duration;
    String ageRestriction;
    String IMDb;
    String showDate;
    String showTime;
    String type;
    String imgLink;

    public Movie(String id, String title, String genre, String language, String duration, String ageRestriction,
            String IMDb,
            String showDate, String showTime, String type, String imgLink) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.ageRestriction = ageRestriction;
        this.IMDb = IMDb;
        this.showDate = showDate;
        this.showTime = showTime;
        this.type = type;
        this.imgLink = imgLink;
    }

    public static String movieIdGenerator() {
        String id = "";
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            id += rand.nextInt(10) + "";
        }

        return id;
    }

    public static String[] getMoviesTitles() {

        ArrayList<Movie> nowShowing = new ArrayList<Movie>();

        for (int i = 0; i < moviesArr.size(); i++) {
            if (moviesArr.get(i).type.equals("Now-Showing")) {
                nowShowing.add(moviesArr.get(i));
            }
        }

        String[] titlesArr = new String[nowShowing.size()];

        for (int i = 0; i < nowShowing.size(); i++) {
            titlesArr[i] = nowShowing.get(i).title;
        }

        return titlesArr;
    }

    public static String getMovieId(String movieTitle) {
        String id = "-1";

        for (int i = 0; i < moviesArr.size(); i++) {
            if (moviesArr.get(i).title.equalsIgnoreCase(movieTitle)) {
                return moviesArr.get(i).id;
            }
        }
        return id;
    }

}
