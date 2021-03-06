import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class PaymentPanel extends JPanel {

    JTextField cardNumberTextField = new HintTextField("Card Number");
    JTextField cardHolderTextField = new HintTextField("Card Holder Name");
    JTextField cardMonthTextField = new HintTextField("Card Month");
    JTextField cardYearTextField = new HintTextField("Card Year");
    JTextField cardCVCTextField = new HintTextField("CVC");

    JButton payButton = new JButton();

    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();

    PaymentPanel() {

        setLayout(new BorderLayout());
        // ! White Panel

        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);

        cardNumberTextField.setBounds(172, 32, 356, 40);
        cardHolderTextField.setBounds(172, 82, 356, 40);
        cardMonthTextField.setBounds(172, 132, 100, 40);
        cardYearTextField.setBounds(292, 132, 100, 40);
        cardCVCTextField.setBounds(172, 182, 356, 40);

        payButton.setBounds(257, 232, 167, 50);

        payButton.setBackground(Color.black);
        payButton.setForeground(Color.WHITE);
        payButton.setFocusable(false);
        payButton.addActionListener(new ButtonHandler());
        payButton.setText("Pay");

        // ! Adding

        whitePanel.add(cardNumberTextField);
        whitePanel.add(cardHolderTextField);
        whitePanel.add(cardMonthTextField);
        whitePanel.add(cardYearTextField);
        whitePanel.add(cardCVCTextField);
        whitePanel.add(payButton);

        // ! Black Panel
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel blackLabel = new JLabel();
        blackLabel.setIcon(new ImageIcon("./resource/img/mainLogo.png"));
        blackPanel.add(blackLabel);

        add(blackPanel, BorderLayout.NORTH);
        add(whitePanel, BorderLayout.CENTER);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == payButton) {

                try {

                    String cardHolder = cardHolderTextField.getText().trim();
                    String cardNumber = cardNumberTextField.getText().trim();
                    String cardMonth = cardMonthTextField.getText().trim();
                    String cardYear = cardYearTextField.getText().trim();
                    String cardCVC = cardCVCTextField.getText().trim();

                    if (cardNumber.length() == 16 && cardMonth.length() == 2 && cardYear.length() == 4
                            && cardCVC.length() == 3
                            && Handler.isNumbers(cardNumber + cardMonth + cardYear + cardCVC)) {
                        Ticket t = new Ticket(
                                User.loggedInUser.username, 1, 0, Payment.totalPrice(),
                                cardHolderTextField.getText().trim(),
                                cardNumberTextField.getText().trim(),
                                cardMonthTextField.getText().trim() + "/" + cardYearTextField.getText().trim(),
                                Integer.parseInt(cardCVCTextField.getText().trim()));

                        int answer = JOptionPane.showConfirmDialog(null, "Total Price : " + Payment.totalPrice() + "",
                                "Confirm Payment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                        if (answer == 0) {
                            JOptionPane.showMessageDialog(null, "Print Your Ticket", "Payed Successfully",
                                    JOptionPane.YES_NO_CANCEL_OPTION);

                            Main.database.addTicket(Movie.selectedMovie, t);

                            Main.cardLayout.show(MainFrame.framePanel, "customerPanel");
                        } else {
                            Main.cardLayout.show(MainFrame.framePanel, "customerPanel");
                        }
                    } else {
                        System.out.println("Wrong");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "One Of The Fields Are Entered Unsuccessfully\nPlease Try Again", "Error Occurred",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

}
