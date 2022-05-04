import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {


    CardLayout cardLayout = new CardLayout();
    public static JPanel framePanel = new JPanel();

    MainFrame() {
        super("Star City");
        framePanel.setLayout(Main.cardLayout);

        framePanel.add(new MainPanel() , "mainPanel");
        framePanel.add(new LoginPanel() , "loginPanel");
        framePanel.add(new SignUpPanel() , "signUpPanel");
        framePanel.add(new AdminPanel() , "adminPanel");
        framePanel.add(new AddMoviePanel() , "addMoviePanel");
        framePanel.add(new DeleteMoviePanel() , "deleteMoviePanel");
        


        add(framePanel) ; 
        
        setResizable(false);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
