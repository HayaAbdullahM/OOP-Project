import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class AddMoviePanel extends JPanel {

    JTextField movieTitle = new JTextField();
    JTextField genre = new JTextField();
    JTextField language = new JTextField();
    JTextField duration = new JTextField();
    JTextField ageRes = new JTextField();
    JTextField IMDb = new JTextField();
    JTextField showTimeOne = new JTextField();
    JTextField showTimeTwo = new JTextField();

    JRadioButton nowShowing = new JRadioButton("NOW-SHOWING");
    JRadioButton upComing = new JRadioButton("UP-COMING");
    ButtonGroup radioButton = new ButtonGroup();

    JButton addButton = new JButton("Add") ; 
    JButton backButton = new JButton("Back") ; 


    AddMoviePanel() {
        setBackground(Color.white);
        setLayout(null);

        backButton.setBounds(34, 21, 70, 31) ; 
        backButton.setBackground(Color.white);

        addButton.setBounds(592 , 21 , 70 , 31) ; 
        addButton.setBackground(Color.white);

        backButton.setFocusable(false);
        addButton.setFocusable(false);

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
        nowShowingLabel.setBounds(291 , 420 , 112 , 16) ; 
        JLabel upComingLabel = new JLabel("Up Coming");
        upComingLabel.setBounds(480 , 419 , 112 , 16) ; 

        movieTitle.setBounds(225, 64, 356, 40);
        genre.setBounds(225, 112, 356, 40);
        language.setBounds(225, 160, 356, 40);
        duration.setBounds(225, 208, 356, 40);
        ageRes.setBounds(225, 256, 356, 40);
        IMDb.setBounds(225, 304, 356, 40);
        showTimeOne.setBounds(225, 352, 159, 40);
        showTimeTwo.setBounds(387, 352, 159, 40);

        radioButton.add(nowShowing) ; 
        radioButton.add(upComing) ; 


        nowShowing.setBounds(258 , 419 , 17 , 17) ; 
        upComing.setBounds(447 , 419 , 17 , 17) ; 



        add(titleLabel);
        add(genderLabel);
        add(languageLabel);
        add(durationLabel);
        add(ageRestrictionLabel);
        add(IMDbLabel);
        add(showTimeLabel);

        add(movieTitle);
        add(genre);
        add(language);
        add(duration);
        add(ageRes);
        add(IMDb);
        add(showTimeOne);
        add(showTimeTwo);


        nowShowing.setBackground(Color.white); ; 
        upComing.setBackground(Color.white); ; 

        add(nowShowingLabel);
        add(upComingLabel);

        add(nowShowing) ; 
        add(upComing) ; 

        add(backButton) ; 
        add(addButton) ; 

    }

}
