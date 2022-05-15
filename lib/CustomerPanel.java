import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class CustomerPanel extends JPanel {

    JLabel mainLabel = new JLabel();
    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    JButton viewUpComingMoviesButton = new JButton("View Up Coming Movies");
    JButton viewNowShowingMoviesButton = new JButton("View Now Showing Movies");
    JButton bookMovieButton = new JButton("Book Movie");
    JButton orderFoodButton = new JButton("Order Food");
    JButton signOut = new JButton("Sign Out");

    CustomerPanel() {
        setLayout(new BorderLayout());

        User user = getLoggedInUser();

        // ! whitePanel

        whitePanel.setLayout(new GridLayout(0, 1));
        whitePanel.setBackground(Color.WHITE);

        mainLabel.setText("Welcome ");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 34));
        mainLabel.setBorder(new EmptyBorder(130, 100, 30, 100));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setSize(100, 100);
        buttonPanel.setLayout(new GridLayout(0, 1));

        JPanel buttonPanelOne = new JPanel();
        JPanel buttonPanelTwo = new JPanel();
        JPanel buttonPanelThree = new JPanel();
        JPanel buttonPanelFour = new JPanel();

        buttonPanelOne.setPreferredSize(new Dimension(100, 100));
        buttonPanelTwo.setPreferredSize(new Dimension(100, 100));
        buttonPanelThree.setPreferredSize(new Dimension(100, 100));
        buttonPanelFour.setPreferredSize(new Dimension(120, 40));


        buttonPanelOne.setBackground(Color.WHITE);
        buttonPanelTwo.setBackground(Color.WHITE);
        buttonPanelThree.setBackground(Color.WHITE);
        buttonPanelFour.setBackground(Color.WHITE);

        viewNowShowingMoviesButton.setBackground(Color.WHITE);
        viewUpComingMoviesButton.setBackground(Color.WHITE);
        bookMovieButton.setBackground(Color.WHITE);
        orderFoodButton.setBackground(Color.WHITE);
        signOut.setBackground(Color.WHITE);

        buttonPanelOne.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        buttonPanelOne.add(viewNowShowingMoviesButton);

        buttonPanelOne.add(viewUpComingMoviesButton);
        buttonPanelTwo.add(bookMovieButton);
        buttonPanelThree.add(orderFoodButton);
        buttonPanelFour.add(signOut);

        viewNowShowingMoviesButton.setFocusable(false);
        viewUpComingMoviesButton.setFocusable(false);
        bookMovieButton.setFocusable(false);
        orderFoodButton.setFocusable(false);
        signOut.setFocusable(false);

        viewNowShowingMoviesButton.addActionListener(new ButtonHandler());
        viewUpComingMoviesButton.addActionListener(new ButtonHandler());
        bookMovieButton.addActionListener(new ButtonHandler());
        orderFoodButton.addActionListener(new ButtonHandler());
        signOut.addActionListener(new ButtonHandler());

        buttonPanel.add(buttonPanelOne);
        buttonPanel.add(buttonPanelTwo);
        buttonPanel.add(buttonPanelThree);
        buttonPanel.add(buttonPanelFour);

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

    }

    private User getLoggedInUser() {
        return User.loggedInUser;
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (viewUpComingMoviesButton == e.getSource()) {
                new ViewUpComingMoviesPanel();
            }

            if (viewNowShowingMoviesButton == e.getSource()) {
                new ViewNowShowingMoviesPanel();
            }
            if (bookMovieButton == e.getSource()) {
                Main.cardLayout.show(MainFrame.framePanel, "bookMoviePanel");

                System.out.println("Booking") ; 

            }
            if (orderFoodButton == e.getSource()) {
                Main.cardLayout.show(MainFrame.framePanel, "menuPanel");

            }

            if(e.getSource() == signOut){
                Main.cardLayout.show(MainFrame.framePanel, "mainPanel");
            }

        }

    }

}
