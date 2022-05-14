import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JFileChooser;

public class FilesManager {

    private static Formatter output;

    public static Path getDownloadPath() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(null);
        return chooser.getSelectedFile().toPath();
    }

    public static Path getDownloadPath(String x) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);
        return chooser.getSelectedFile().toPath();
    }

    public static void downloadCSVTickets() {
        openFile();
        addTicketsRecords();
        closeFile();
    }

    public static void addTicketsRecords() {
        output.format(
                "Username , Adults , Kids , Total Price , Card Holder , Card Number , Expiry Date , Pin Code \n",
                "");
        for (int i = 0; i < Ticket.ticketsArr.size(); i++) {
            Ticket t = Ticket.ticketsArr.get(i);
            output.format("%s , %s , %s , %s , %s , %s , %s , %s \n", t.username, t.adults, t.kids, t.totalPrice,
                    t.cardHolder, t.cardNumber, t.expiryDate, t.pinCode);
        }

    }

    public static void downloadCSVMovies() {
        openFile();
        addMoviesRecords();
        closeFile();
    }

    public static void openFile() {
        try {
            output = new Formatter(getDownloadPath() + "/Data.csv");

        } catch (FileNotFoundException e) {

        }
    }

    public static void addMoviesRecords() {
        output.format(
                "Id , Title , Genre , Language , Duration , Age Restriction , IMDb Rating , Show Date , Show Time , Type \n",
                "");
        for (int i = 0; i < Movie.moviesArr.size(); i++) {
            Movie m = Movie.moviesArr.get(i);
            output.format("%s , %s , %s , %s , %s , %s , %s , %s , %s , %s \n", m.id, m.title, m.genre, m.language,
                    m.duration, m.ageRestriction, m.IMDb, m.showDate, m.showTime, m.type);
        }

    }

    public static void importMovie() {
        try {
            Path folderPath = getDownloadPath("");
            Scanner scanner = new Scanner(folderPath);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split(",");
                Movie m = new Movie(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8],
                        line[9], line[10]);
                Main.database.addMovie(m);
                Movie.moviesArr.add(m);
            }
            scanner.close();
        } catch (Exception e) {

        }

    }

    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }

}
