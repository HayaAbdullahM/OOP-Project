import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class CustomerPanel extends JPanel {

    JLabel mainLabel = new JLabel();
    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    JButton viewMoviesButton = new JButton("View Movies");
    JButton bookMovieButton = new JButton("Book Movie");
    JButton orderFoodButton = new JButton("Order Food");

    CustomerPanel() {
        setLayout(new BorderLayout());

        User user = getLoggedInUser();

        // ! whitePanel

        whitePanel.setLayout(new GridLayout(0, 1));
        whitePanel.setBackground(Color.WHITE);

        mainLabel.setText("Welcome");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 34));
        mainLabel.setBorder(new EmptyBorder(130, 100, 30, 100));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setSize(100, 100);
        buttonPanel.setLayout(new GridLayout(0, 1));

        JPanel buttonPanelOne = new JPanel();
        JPanel buttonPanelTwo = new JPanel();
        JPanel buttonPanelThree = new JPanel();

        buttonPanelOne.setPreferredSize(new Dimension(100, 100));
        buttonPanelTwo.setPreferredSize(new Dimension(100, 100));
        buttonPanelThree.setPreferredSize(new Dimension(100, 100));

        buttonPanelOne.setBackground(Color.WHITE);
        buttonPanelTwo.setBackground(Color.WHITE);
        buttonPanelThree.setBackground(Color.WHITE);

        viewMoviesButton.setBackground(Color.WHITE);
        bookMovieButton.setBackground(Color.WHITE);
        orderFoodButton.setBackground(Color.WHITE);

        buttonPanelOne.add(viewMoviesButton);
        buttonPanelTwo.add(bookMovieButton);
        buttonPanelThree.add(orderFoodButton);

        viewMoviesButton.setFocusable(false);
        bookMovieButton.setFocusable(false);
        orderFoodButton.setFocusable(false);

        viewMoviesButton.addActionListener(new ButtonHandler());
        bookMovieButton.addActionListener(new ButtonHandler());
        orderFoodButton.addActionListener(new ButtonHandler());


        buttonPanel.add(buttonPanelOne);
        buttonPanel.add(buttonPanelTwo);
        buttonPanel.add(buttonPanelThree);

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

            if(viewMoviesButton == e.getSource()){
                new ViewMoviesPanel() ; 
            }
            if(bookMovieButton == e.getSource()){
                Main.cardLayout.show(MainFrame.framePanel, "bookMoviePanel");
            }
            if(orderFoodButton == e.getSource()){
                Main.cardLayout.show(MainFrame.framePanel, "menuPanel");

            }
        }

    }

}
