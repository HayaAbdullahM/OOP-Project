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
    JButton exportDataButton = new JButton("Export Movies");
    JButton exportTicketButton = new JButton("Export Ticket");
    JButton importDataButton = new JButton("Import Data");
    JButton signOut = new JButton("Sign Out");

    AdminPanel() {
        setLayout(new BorderLayout());

        // ! whitePanel

        whitePanel.setLayout(new GridLayout(0, 1));
        whitePanel.setBackground(Color.WHITE);

        mainLabel.setText("Admin Panel");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 34));
        mainLabel.setBorder(new EmptyBorder(130, 100, 30, 100));

        addMovieButton.setPreferredSize(new Dimension(120, 40));
        deleteMovieButton.setPreferredSize(new Dimension(120, 40));
        exportDataButton.setPreferredSize(new Dimension(120, 40));
        exportTicketButton.setPreferredSize(new Dimension(120, 40));
        importDataButton.setPreferredSize(new Dimension(120, 40));
        signOut.setPreferredSize(new Dimension(120, 40));

        addMovieButton.setBackground(Color.WHITE);
        deleteMovieButton.setBackground(Color.WHITE);
        exportDataButton.setBackground(Color.WHITE);
        exportTicketButton.setBackground(Color.WHITE);
        importDataButton.setBackground(Color.WHITE);
        signOut.setBackground(Color.WHITE);

        addMovieButton.setFocusable(false);
        deleteMovieButton.setFocusable(false);
        exportDataButton.setFocusable(false);
        exportTicketButton.setFocusable(false);
        importDataButton.setFocusable(false);
        signOut.setFocusable(false);

        addMovieButton.addActionListener(new ButtonHandler());
        deleteMovieButton.addActionListener(new ButtonHandler());
        exportDataButton.addActionListener(new ButtonHandler());
        exportTicketButton.addActionListener(new ButtonHandler());
        importDataButton.addActionListener(new ButtonHandler());
        signOut.addActionListener(new ButtonHandler());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setSize(100, 100);
        buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel buttonPanelOne = new JPanel();
        JPanel buttonPanelTwo = new JPanel();
        JPanel buttonPanelThree = new JPanel();
        JPanel buttonPanelFour = new JPanel();

        buttonPanelOne.setPreferredSize(new Dimension(100, 100));
        buttonPanelTwo.setPreferredSize(new Dimension(100, 100));
        buttonPanelThree.setPreferredSize(new Dimension(100, 100));
        buttonPanelFour.setPreferredSize(new Dimension(100, 100));

        buttonPanelOne.add(addMovieButton);

      


        buttonPanelThree.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanelTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        buttonPanelTwo.add(deleteMovieButton);
        buttonPanelTwo.add(importDataButton);

        buttonPanelThree.add(exportDataButton);
        buttonPanelThree.add(exportTicketButton);

        buttonPanelOne.setBackground(Color.WHITE);
        buttonPanelFour.setBackground(Color.WHITE);
        buttonPanelTwo.setBackground(Color.WHITE);
        buttonPanelThree.setBackground(Color.WHITE);


        buttonPanelFour.add(signOut);

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

        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addMovieButton) {
                Main.cardLayout.show(MainFrame.framePanel, "addMoviePanel");
            }

            if (e.getSource() == deleteMovieButton) {
                String movieName = JOptionPane.showInputDialog(null, "Delete Movie", "Name Of The Movie",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println(movieName);

                String movieId = Movie.getMovieId(movieName);

                if (movieId.equals("-1")) {
                    Handler.showError("No Movie With This Title");
                } else {

                    for (int i = 0; i < Movie.moviesArr.size(); i++) {
                        if (Movie.moviesArr.get(i).id.equals(movieId)) {
                            if (Movie.moviesArr.get(i).type.equals("Up-Coming")) {
                                Main.database.deleteUpComing(movieId);
                            } else {
                                Main.database.deleteNowShowing(movieId);
                            }
                            break;
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Movie Deleted Successfully", "Done",
                            JOptionPane.INFORMATION_MESSAGE);
                    ;
                }
            }

            if(importDataButton == e.getSource()){
                FilesManager.importMovie();
            }


            if (e.getSource() == exportDataButton) {
                FilesManager.downloadCSVMovies();
            }

            if (e.getSource() == exportTicketButton) {

                String movieName = JOptionPane.showInputDialog(null, "Export Tickets", "Name Of The Movie",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println(movieName);

                String movieId = Movie.getMovieId(movieName);

                if (movieId.equals("-1")) {
                    Handler.showError("No Movie With This Title");
                } else {

                }

                Main.database.getTickets(movieId);
                FilesManager.downloadCSVTickets();
                Ticket.ticketsArr.clear();

            }

            if(e.getSource() == signOut){
                Main.cardLayout.show(MainFrame.framePanel, "mainPanel");
            }


        }

    }

}
