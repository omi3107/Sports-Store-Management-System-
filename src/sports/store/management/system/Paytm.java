package sports.store.management.system;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    JButton payButton, backButton;
    JTextField amountField, customerIDField;

    public Paytm() {
        setTitle("Sports Store - Razorpay Payment");
        setBounds(420, 190, 500, 300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel customerIDLabel = new JLabel("Customer ID:");
        customerIDLabel.setBounds(50, 50, 100, 30);
        add(customerIDLabel);

        customerIDField = new JTextField();
        customerIDField.setBounds(150, 50, 200, 30);
        add(customerIDField);

        JLabel amountLabel = new JLabel("Amount (INR):");
        amountLabel.setBounds(50, 100, 100, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 100, 200, 30);
        add(amountField);

        payButton = new JButton("Pay Now");
        payButton.setBounds(80, 180, 120, 40);
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        add(payButton);

        backButton = new JButton("Back");
        backButton.setBounds(230, 180, 120, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == payButton) {
            String customerID = customerIDField.getText();
            String amount = amountField.getText();
            if (!customerID.isEmpty() && !amount.isEmpty()) {
                try {
                    openRazorpayPaymentPage(customerID, amount);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to open payment page.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter Customer ID and Amount.");
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    private void openRazorpayPaymentPage(String customerID, String amount) throws IOException, URISyntaxException {
        // Generate a payment link (for example purpose; replace with your Razorpay logic)
        String paymentLink = "https://rzp.io/l/test-payment?customerID=" + customerID + "&amount=" + amount;
        // Check if Desktop is supported on the system
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(paymentLink));
        } else {
            throw new UnsupportedOperationException("Desktop not supported. Cannot open browser.");
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
