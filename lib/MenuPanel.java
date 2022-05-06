import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {

    static ArrayList<String> totalSides = new ArrayList<String>();

    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel() ; 


    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JPanel sidesPanel = new JPanel();
    JPanel drinksPanel = new JPanel();

    JButton backButton = new JButton("Back");

    JCheckBox[] sidesArr = {
            new JCheckBox("Popcorn", false), new JCheckBox("Fries", false), new JCheckBox("Nachos", false),
            new JCheckBox("Chips", false)
    };

    // ! Drinks Menu

    JCheckBox softDrinkBox = new JCheckBox("Soft Drinks", false);
    JCheckBox freshJuiceBox = new JCheckBox("Fresh Juice", false);
    JCheckBox slashesBox = new JCheckBox("Slashes", false);
    JCheckBox waterBox = new JCheckBox("Water", false);

    JCheckBox[] drinksArr = {
            new JCheckBox("Soft Drinks", false), new JCheckBox("Fresh Juice", false), new JCheckBox("Slashes", false),
            new JCheckBox("Water", false)
    };

    MenuPanel() {


        // ! Black Panel
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel blackLabel = new JLabel();
        blackLabel.setText("STAR CITY");
        blackLabel.setFont(new Font("Arial", Font.BOLD, 32));
        blackLabel.setForeground(Color.WHITE);
        blackLabel.setIcon(new ImageIcon("./resource/img/mainLogo.png"));
        blackPanel.add(blackLabel);



        // ! Coloring
        setBackground(Color.white);
        centerPanel.setBackground(Color.white);
        bottomPanel.setBackground(Color.white);
        sidesPanel.setBackground(Color.white);
        drinksPanel.setBackground(Color.white);

        setLayout(new BorderLayout());

        centerPanel.setLayout(new GridLayout(0, 1, 40, 40));

        sidesPanel.add(new JLabel("Sides : "));

        drinksPanel.add(new JLabel("Drinks : "));

        for (int i = 0; i < sidesArr.length; i++) {
            sidesArr[i].setFocusable(false);
            sidesArr[i].setBackground(Color.white);
            sidesPanel.add(sidesArr[i]);
        }

        for (int i = 0; i < drinksArr.length; i++) {
            drinksArr[i].setFocusable(false);
            drinksArr[i].setBackground(Color.white);
            drinksPanel.add(drinksArr[i]);
        }

        // ! Adding

        centerPanel.add(sidesPanel);
        centerPanel.add(drinksPanel);

        add(blackPanel , BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);

        backButton.setBackground(Color.white);
        backButton.addActionListener(new ButtonHandler());

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(backButton, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            totalSides.clear();
            if (e.getSource() == backButton) {

                for (int i = 0; i < sidesArr.length; i++) {
                    if (sidesArr[i].isSelected() && !(totalSides.contains(sidesArr[i]))) {
                        totalSides.add(sidesArr[i].getText());
                    }
                }

                for (int i = 0; i < drinksArr.length; i++) {
                    if (drinksArr[i].isSelected() && !(totalSides.contains(drinksArr[i]))) {
                        totalSides.add(drinksArr[i].getText());
                    }
                }

                Main.cardLayout.show(MainFrame.framePanel, "customerPanel");

            }

        }
    }

}
