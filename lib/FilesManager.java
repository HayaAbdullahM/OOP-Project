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

    public static void downloadCSV() {
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile() {
        try {
            output = new Formatter(getDownloadPath() + "/Movies.csv");

        } catch (FileNotFoundException e) {

        }
    }

    public static void addRecords() {
        output.format(
                "Id , Title , Genre , Language , Duration , Age Restriction , IMDb Rating , Show Date , Show Time , Type \n",
                "");
        for (int i = 0; i < Movie.moviesArr.size(); i++) {
            Movie m = Movie.moviesArr.get(i);
            output.format("%s , %s , %s , %s , %s , %s , %s , %s , %s , %s \n", m.id, m.title, m.genre, m.language,
                    m.duration, m.ageRestriction, m.IMDb, m.showDate, m.showTime, m.type);
        }

    }

    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }

}
