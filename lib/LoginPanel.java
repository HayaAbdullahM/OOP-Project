import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class LoginPanel extends JPanel {

    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    JTextField textField = new JTextField(18);
    JPasswordField passwordField = new JPasswordField(18);

    JButton loginButton = new JButton("Login");
    JButton returnButton = new JButton("return");

    BufferedImage img;

    LoginPanel() {

        // try {
        // img = ImageIO.read(new
        // URL("https://images.unsplash.com/photo-1649027421785-6827863f0891?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=715&q=80"));
        // } catch (Exception e) {

        // }

        setLayout(new BorderLayout());

        // ! Black Panel
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel blackLabel = new JLabel();
        blackLabel.setText("STAR CITY");
        blackLabel.setFont(new Font("Arial", Font.BOLD, 32));
        blackLabel.setForeground(Color.WHITE);

        blackLabel.setIcon(new ImageIcon("./resource/img/mainLogo.png"));
        // blackLabel.setIcon(new ImageIcon(img));
        blackPanel.add(blackLabel);

        // ! White Panel
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel usernamesPanel = new JPanel();
        usernamesPanel.add(new JLabel("Username : "));
        usernamesPanel.add(textField);
        usernamesPanel.setBorder(new EmptyBorder(50, 10, 10, 10));
        usernamesPanel.setBackground(Color.WHITE);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password : "));
        passwordPanel.add(passwordField);
        passwordPanel.setBackground(Color.WHITE);

        loginButton.setBackground(Color.WHITE);
        returnButton.setBackground(Color.WHITE);

        loginButton.setFocusable(false);
        returnButton.setFocusable(false);

        loginButton.addActionListener(new ButtonHandler());
        returnButton.addActionListener(new ButtonHandler());

        loginButton.setPreferredSize(new Dimension(180, 30));
        returnButton.setPreferredSize(new Dimension(80, 30));

        JPanel loginButtonPanel = new JPanel();
        loginButtonPanel.add(loginButton);
        loginButtonPanel.setBackground(Color.white);

        JPanel returnButtonPanel = new JPanel();
        returnButtonPanel.add(returnButton);
        returnButtonPanel.setBackground(Color.white);

        whitePanel.add(usernamesPanel);
        whitePanel.add(passwordPanel);
        whitePanel.add(loginButtonPanel);
        whitePanel.add(returnButtonPanel);

        // ! Adding Elements

        add(blackPanel, BorderLayout.NORTH);
        add(whitePanel, BorderLayout.CENTER);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {

                boolean isFound = false;
                for (int i = 0; i < Admin.adminsArr.size(); i++) {
                    if (Admin.adminsArr.get(i).username.equals(textField.getText().trim())
                            && Admin.adminsArr.get(i).password.equals(passwordField.getText().trim())) {
                        User.loggedInUser = new User(Admin.adminsArr.get(i).username,
                                Admin.adminsArr.get(i).password);
                        Main.cardLayout.show(MainFrame.framePanel, "adminPanel");
                        isFound = true;
                        break;
                    }
                }

                for (int i = 0; i < Customer.customersArr.size(); i++) {
                    if (Customer.customersArr.get(i).username.equals(textField.getText().trim())
                            && Customer.customersArr.get(i).password.equals(passwordField.getText().trim())) {
                        User.loggedInUser.setUser(
                                new User(Customer.customersArr.get(i).username, Customer.customersArr.get(i).password));
                        System.out.println(User.loggedInUser.username);
                        Main.cardLayout.show(MainFrame.framePanel, "customerPanel");
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {

                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password\nPlease Try Again",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

            if (e.getSource() == returnButton) {
                Main.cardLayout.show(MainFrame.framePanel, "mainPanel");
            }

        }

    }

}
