import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpComingMoviesPanel extends JPanel {
    UpComingMoviesPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(0, 1, 20, 20));

        for (int i = 0; i < Movie.moviesArr.size(); i++) {

            if (Movie.moviesArr.get(i).type.equals("Up-Coming")) {
                add(new MovieWidget(Movie.moviesArr.get(i)));
            }

        }

    }
}
