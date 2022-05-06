import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {

    JLabel mainLabel = new JLabel();
    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton signUpButton = new JButton("Sign Up");

    MainPanel() {
        setLayout(new BorderLayout());

        // ! whitePanel

        whitePanel.setLayout(new GridLayout(0, 1));
        whitePanel.setBackground(Color.WHITE);

        mainLabel.setText("Star City");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 34));
        mainLabel.setBorder(new EmptyBorder(130, 100, 30, 100));

        buttonsPanel.setBackground(Color.WHITE);

        loginButton.setPreferredSize(new Dimension(120, 40));
        signUpButton.setPreferredSize(new Dimension(120, 40));

        loginButton.setBackground(Color.WHITE);
        signUpButton.setBackground(Color.WHITE);

        loginButton.setFocusable(false);
        signUpButton.setFocusable(false);

        loginButton.addActionListener(new ButtonHandler());
        signUpButton.addActionListener(new ButtonHandler());

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(0, 10, 0, 10));
        padding.setBackground(Color.WHITE);

        buttonsPanel.add(loginButton);
        buttonsPanel.add(padding);
        buttonsPanel.add(signUpButton);

        whitePanel.add(mainLabel);
        whitePanel.add(buttonsPanel);

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

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {
                Main.cardLayout.show(MainFrame.framePanel, "loginPanel");
            }

            if (e.getSource() == signUpButton) {
                Main.cardLayout.show(MainFrame.framePanel, "signUpPanel");
            }

        }

    }

}
