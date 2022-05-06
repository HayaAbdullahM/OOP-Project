import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class SignUpPanel extends JPanel {

    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    JTextField usernameTextFiled = new JTextField(18);
    JTextField emailTextField = new JTextField(18);
    JTextField ageTextField = new JTextField(2);
    JTextField phoneNumberTextField = new JTextField(18);

    JPasswordField passwordField = new JPasswordField(18);

    JButton signUpButton = new JButton("Sign Up");
    JButton returnButton = new JButton("return");

    SignUpPanel() {

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
        whitePanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel usernamesPanel = new JPanel();
        usernamesPanel.add(new JLabel("Username :        "));
        usernamesPanel.add(usernameTextFiled);
        usernamesPanel.setBackground(Color.WHITE);

        JPanel emailPanel = new JPanel();
        emailPanel.add(new JLabel("Email :                 "));
        emailPanel.add(emailTextField);
        emailPanel.setBackground(Color.WHITE);

        JPanel phoneNumberPanel = new JPanel();
        phoneNumberPanel.add(new JLabel("Phone Number : "));
        phoneNumberPanel.add(phoneNumberTextField);
        phoneNumberPanel.setBackground(Color.WHITE);

        JPanel agePanel = new JPanel();
        agePanel.add(new JLabel("Age :                 "));
        agePanel.add(ageTextField);
        agePanel.setBackground(Color.WHITE);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password :           "));
        passwordPanel.add(passwordField);
        passwordPanel.setBackground(Color.WHITE);

        signUpButton.setBackground(Color.WHITE);
        returnButton.setBackground(Color.WHITE);

        signUpButton.setFocusable(false);
        returnButton.setFocusable(false);

        signUpButton.addActionListener(new ButtonHandler());
        returnButton.addActionListener(new ButtonHandler());

        signUpButton.setPreferredSize(new Dimension(180, 30));
        returnButton.setPreferredSize(new Dimension(80, 30));

        JPanel signUpButtonButtonPanel = new JPanel();
        signUpButtonButtonPanel.add(signUpButton);
        signUpButtonButtonPanel.setBackground(Color.white);

        JPanel returnButtonPanel = new JPanel();
        returnButtonPanel.add(returnButton);
        returnButtonPanel.setBackground(Color.white);

        whitePanel.add(usernamesPanel);
        whitePanel.add(emailPanel);
        whitePanel.add(agePanel);
        whitePanel.add(passwordPanel);
        whitePanel.add(signUpButtonButtonPanel);
        whitePanel.add(returnButtonPanel);

        // ! Adding Elements

        add(blackPanel, BorderLayout.NORTH);
        add(whitePanel, BorderLayout.CENTER);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == signUpButton) {

                String username = usernameTextFiled.getText().trim();
                String password = passwordField.getText().trim();
                String email = emailTextField.getText().trim();
                String age = ageTextField.getText().trim();

                if ((!username.isEmpty()) && (!password.isEmpty()) & (!email.isEmpty()) && !(password.isEmpty())) {
                    System.out.println("Created");
                    Main.database.addCostumer(username, password, email, age);

                    Main.cardLayout.show(MainFrame.framePanel, "customerPanel");
                }

            }

            if (e.getSource() == returnButton) {
                Main.cardLayout.show(MainFrame.framePanel, "mainPanel");
            }

        }

    }

}
