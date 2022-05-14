
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ViewUpComingMoviesPanel extends JFrame {

    ViewUpComingMoviesPanel() {
        JScrollPane sp = new JScrollPane(new UpComingMoviesPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(sp);

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(700, 500);

    }

}
