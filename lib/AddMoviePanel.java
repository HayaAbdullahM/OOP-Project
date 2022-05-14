
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class AddMoviePanel extends JPanel {

    JTextField movieTitle = new JTextField();
    JTextField genreTextField = new JTextField();
    JTextField languageTextField = new JTextField();
    JTextField durationTextField = new JTextField();
    JTextField ageResTextField = new JTextField();
    JTextField IMDbTextField = new JTextField();
    JTextField showTimeOneTextField = new JTextField();
    JTextField showTimeTwoTextField = new JTextField();

    JRadioButton nowShowing = new JRadioButton("NOW-SHOWING", true);
    JRadioButton upComing = new JRadioButton("UP-COMING", false);
    ButtonGroup radioButton = new ButtonGroup();

    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");
    JButton addImageURL = new JButton("Add Image");

    String type = "Now-Showing";
    String ImageURL = "https://www.lyricsbogie.com/wp-content/uploads/2016/09/rami-dhoban-1953-200x275.jpg";

    AddMoviePanel() {
        setBackground(Color.white);
        setLayout(null);

        backButton.setBounds(34, 21, 70, 31);
        backButton.setBackground(Color.white);
        addImageURL.setBackground(Color.white);

        addButton.setBounds(592, 21, 70, 31);
        addButton.setBackground(Color.white);

        backButton.setFocusable(false);
        addButton.setFocusable(false);
        addImageURL.setFocusable(false);

        backButton.addActionListener(new ButtonHandler());
        addButton.addActionListener(new ButtonHandler());
        addImageURL.addActionListener(new ButtonHandler());

        JLabel titleLabel = new JLabel("Movie Title : ");
        titleLabel.setBounds(60, 69, 81, 31);

        JLabel genderLabel = new JLabel("Genre : ");
        genderLabel.setBounds(60, 117, 75, 31);

        JLabel languageLabel = new JLabel("Language : ");
        languageLabel.setBounds(60, 165, 100, 31);

        JLabel durationLabel = new JLabel("Duration : ");
        durationLabel.setBounds(60, 213, 92, 31);

        JLabel ageRestrictionLabel = new JLabel("Age Restriction : ");
        ageRestrictionLabel.setBounds(60, 261, 147, 31);

        JLabel IMDbLabel = new JLabel("IMDb : ");
        IMDbLabel.setBounds(60, 309, 59, 31);

        JLabel showTimeLabel = new JLabel("Show Time : ");
        showTimeLabel.setBounds(60, 357, 108, 31);

        JLabel nowShowingLabel = new JLabel("Now Showing");
        nowShowingLabel.setBounds(291, 420, 112, 16);
        JLabel upComingLabel = new JLabel("Up Coming");
        upComingLabel.setBounds(480, 419, 112, 16);

        movieTitle.setBounds(225, 64, 356, 40);
        genreTextField.setBounds(225, 112, 356, 40);
        languageTextField.setBounds(225, 160, 356, 40);
        durationTextField.setBounds(225, 208, 356, 40);
        ageResTextField.setBounds(225, 256, 356, 40);
        IMDbTextField.setBounds(225, 304, 356, 40);
        showTimeOneTextField.setBounds(225, 352, 159, 40);
        showTimeTwoTextField.setBounds(387, 352, 159, 40);
        addImageURL.setBounds(572, 352, 100, 40);

        radioButton.add(nowShowing);

        radioButton.add(upComing);

        nowShowing.setBounds(258, 419, 17, 17);
        upComing.setBounds(447, 419, 17, 17);

        add(titleLabel);
        add(genderLabel);
        add(languageLabel);
        add(durationLabel);
        add(ageRestrictionLabel);
        add(IMDbLabel);
        add(showTimeLabel);
        add(movieTitle);
        add(genreTextField);
        add(languageTextField);
        add(durationTextField);
        add(ageResTextField);
        add(IMDbTextField);
        add(showTimeOneTextField);
        add(showTimeTwoTextField);

        nowShowing.setBackground(Color.white);

        upComing.setBackground(Color.white);

        nowShowing.addActionListener(new ButtonHandler());

        upComing.addActionListener(new ButtonHandler());

        add(nowShowingLabel);
        add(upComingLabel);
        add(addImageURL);
        add(nowShowing);
        add(upComing);

        add(backButton);
        add(addButton);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == nowShowing) {
                type = "Now-Showing";
            } else if (e.getSource() == upComing) {
                type = "Up-Coming";

            }

            if (addImageURL == e.getSource()) {
                ImageURL = JOptionPane.showInputDialog(null, "Add Poster", "Insert Image URL",
                        JOptionPane.OK_CANCEL_OPTION);
                if (!Handler.isImage(ImageURL)) {
                    JOptionPane.showMessageDialog(null, "Image URL Was Wrong \nPlease Try Again", "Error Occurred",
                            JOptionPane.ERROR_MESSAGE);
                    ImageURL = "https://www.lyricsbogie.com/wp-content/uploads/2016/09/rami-dhoban-1953-200x275.jpg";
                }

                System.out.println(ImageURL);
            }

            if (e.getSource() == backButton) {
                Main.cardLayout.show(MainFrame.framePanel, "adminPanel");
            }
            if (e.getSource() == addButton) {

                String id = Movie.movieIdGenerator();
                String title = movieTitle.getText().trim();
                String genre = genreTextField.getText().trim();
                String language = languageTextField.getText().trim();

                String duration = durationTextField.getText().trim();

                String ageRestriction = ageResTextField.getText().trim();
                String IMDb = IMDbTextField.getText().trim();
                String showDate = showTimeTwoTextField.getText().trim();
                String showTime = showTimeOneTextField.getText().trim();

                Movie movie = new Movie(
                        id, title, genre, language, duration, ageRestriction, IMDb, showDate, showTime, type, ImageURL);

                Movie.moviesArr.add(movie);

                Main.database.addMovie(movie);

                Main.cardLayout.show(MainFrame.framePanel, "adminPanel");

                showTimeTwoTextField.setText("");
                showTimeOneTextField.setText("");
                IMDbTextField.setText("");
                ageResTextField.setText("");
                durationTextField.setText("");
                durationTextField.setText("");
                languageTextField.setText("");
                genreTextField.setText("");
                movieTitle.setText("");

            }
        }

    }

}
