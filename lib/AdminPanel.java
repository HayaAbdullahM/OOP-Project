import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel {

    JLabel mainLabel = new JLabel();
    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();
    JButton addMovieButton = new JButton("Add New Movie");
    JButton deleteMovieButton = new JButton("Delete Movie");
    JButton exportDataButton = new JButton("Export Data");



    AdminPanel() {
        setLayout(new BorderLayout());

        // ! whitePanel

        whitePanel.setLayout(new GridLayout(0, 1));
        whitePanel.setBackground(Color.WHITE);
        System.out.println(User.loggedInUser);
        System.out.println( User.loggedInUser);
        mainLabel.setText("Admin Panel");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 34));
        mainLabel.setBorder(new EmptyBorder(130, 100, 30, 100));


        addMovieButton.setPreferredSize(new Dimension(120, 40));
        deleteMovieButton.setPreferredSize(new Dimension(120, 40));
        exportDataButton.setPreferredSize(new Dimension(120, 40));

        addMovieButton.setBackground(Color.WHITE);
        deleteMovieButton.setBackground(Color.WHITE);
        exportDataButton.setBackground(Color.WHITE);

        addMovieButton.setFocusable(false);
        deleteMovieButton.setFocusable(false);
        exportDataButton.setFocusable(false);

        addMovieButton.addActionListener(new ButtonHandler());
        deleteMovieButton.addActionListener(new ButtonHandler());
        exportDataButton.addActionListener(new ButtonHandler());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE) ; 
        buttonPanel.setSize(100 , 100) ; 
        buttonPanel.setLayout(new GridLayout(0 , 1 , 0 , 0)) ; 


        JPanel buttonPanelOne = new JPanel() ; 
        JPanel buttonPanelTwo = new JPanel() ; 
        JPanel buttonPanelThree = new JPanel() ; 

        buttonPanelOne.setPreferredSize(new Dimension(100 , 100)) ; 
        buttonPanelTwo.setPreferredSize(new Dimension(100 , 100)) ; 
        buttonPanelThree.setPreferredSize(new Dimension(100 , 100)) ; 



        buttonPanelOne.add(addMovieButton) ; 
        buttonPanelTwo.add(deleteMovieButton) ; 
        buttonPanelThree.add(exportDataButton) ; 

        buttonPanelOne.setBackground(Color.WHITE) ; 
        buttonPanelTwo.setBackground(Color.WHITE) ; 
        buttonPanelThree.setBackground(Color.WHITE) ; 

        buttonPanel.add(buttonPanelOne) ; 
        buttonPanel.add(buttonPanelTwo) ; 
        buttonPanel.add(buttonPanelThree) ; 


        whitePanel.add(mainLabel);
        whitePanel.add(buttonPanel);

        // ! leftPanel
        ImageIcon icon = new ImageIcon("./resource/img/mainLogo.png");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);
        imageLabel.setBorder(new EmptyBorder(40, 10, 0, 10));
        blackPanel.setBackground(Color.BLACK);
        blackPanel.add(imageLabel);

        // ! Add Elements

        add(blackPanel, BorderLayout.WEST);
        add(whitePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addMovieButton) {
                Main.cardLayout.show(MainFrame.framePanel , "loginPanel");
            }

            if (e.getSource() == deleteMovieButton) {
                Main.cardLayout.show(MainFrame.framePanel , "signUpPanel");
            }

        }

    }

}