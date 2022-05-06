import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class BookMoviePanel extends JPanel {

    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    static JTextField adultTextField = new JTextField(2);
    static JTextField kidsTextField = new JTextField(2);

    JButton bookButton = new JButton("Book");
    JButton backButton = new JButton("Back");

    JPanel adultAndKidsPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JComboBox comboBox;

    int selectedIndex = 0;

    BookMoviePanel() {
        setLayout(new BorderLayout());
        comboBox = new JComboBox(Movie.getMoviesTitles());
        comboBox.addActionListener(new ButtonHandler());
        comboBox.setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // ! Black Panel
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel blackLabel = new JLabel();
        blackLabel.setText("STAR CITY");
        blackLabel.setFont(new Font("Arial", Font.BOLD, 32));
        blackLabel.setForeground(Color.WHITE);
        blackLabel.setIcon(new ImageIcon("./resource/img/mainLogo.png"));
        blackPanel.add(blackLabel);

        // ! White Panel
        whitePanel.setBackground(Color.WHITE);
        whitePanel.add(comboBox);

        whitePanel.setLayout(new GridLayout(0, 1, 100, 100));

        adultAndKidsPanel.add(new JLabel("Adult : "));
        adultAndKidsPanel.add(adultTextField);
        adultTextField.setText("1");
        adultTextField.addActionListener(new ButtonHandler());
        adultAndKidsPanel.setBackground(Color.WHITE);
        adultAndKidsPanel.setPreferredSize(new Dimension(100, 100));

        adultAndKidsPanel.add(new JLabel("Kids : "));
        adultAndKidsPanel.add(kidsTextField);
        kidsTextField.addActionListener(new ButtonHandler());
        kidsTextField.setText("0");
        adultAndKidsPanel.setBackground(Color.WHITE);

        bottomPanel.setLayout(new GridLayout(1, 3, 100, 50));

        bottomPanel.setBackground(Color.WHITE);

        backButton.setBackground(Color.BLACK);
        bookButton.setBackground(Color.BLACK);

        backButton.setForeground(Color.WHITE);
        bookButton.setForeground(Color.WHITE);

        JPanel paddingPanel = new JPanel();
        paddingPanel.setBackground(Color.WHITE);

        backButton.setFocusable(false);
        bookButton.setFocusable(false);

        backButton.addActionListener(new ButtonHandler());
        bookButton.addActionListener(new ButtonHandler());

        bottomPanel.add(backButton);
        bottomPanel.add(paddingPanel);
        bottomPanel.add(bookButton);

        whitePanel.add(adultAndKidsPanel);
        whitePanel.add(bottomPanel);

        // ! Adding Elements

        add(blackPanel, BorderLayout.NORTH);
        add(whitePanel, BorderLayout.CENTER);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (comboBox == e.getSource()) {
                selectedIndex = comboBox.getSelectedIndex();
            }
            if (backButton == e.getSource()) {
                Main.cardLayout.show(MainFrame.framePanel, "customerPanel");
            }
            if (bookButton == e.getSource()) {

                Main.cardLayout.show(MainFrame.framePanel, "paymentPanel");

                System.out.println(Payment.totalPrice()); 
                
            }
        }

    }
}
