package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Addcustomer extends JFrame implements ActionListener {

    JLabel labelcustomerID, labelcustomerIDValue, labelname, labelnameValue;
    JTextField tfemailid, tfphoneno, tfaddress;
    JComboBox comboid;
    JButton add, back;

    Addcustomer(String customerid) {
        setBounds(260, 125, 825, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Customer ID Label
        JLabel customerIDLabel = new JLabel("CustomerID");
        customerIDLabel.setBounds(30, 50, 150, 25);
        add(customerIDLabel);

        labelcustomerIDValue = new JLabel(); // To display CustomerID value
        labelcustomerIDValue.setBounds(220, 50, 150, 25);
        add(labelcustomerIDValue);

        // Name Label
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 100, 150, 25);
        add(nameLabel);

        labelnameValue = new JLabel(); // To display Name value
        labelnameValue.setBounds(220, 100, 150, 25);
        add(labelnameValue);

        // ID Label and Combo Box
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(30, 150, 150, 25);
        add(idLabel);

        comboid = new JComboBox(new String[]{"","Aadhar Card", "PAN Card", "Voting card"});
        comboid.setBounds(220, 150, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        // Email ID
        JLabel emailIDLabel = new JLabel("Email ID");
        emailIDLabel.setBounds(30, 200, 150, 25);
        add(emailIDLabel);

        tfemailid = new JTextField();
        tfemailid.setBounds(220, 200, 150, 25);
        add(tfemailid);

        // Phone Number
        JLabel phoneNoLabel = new JLabel("Phone Number");
        phoneNoLabel.setBounds(30, 250, 150, 25);
        add(phoneNoLabel);

        tfphoneno = new JTextField();
        tfphoneno.setBounds(220, 250, 150, 25);
        add(tfphoneno);

        // Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(30, 300, 150, 25);
        add(addressLabel);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 300, 150, 25);
        add(tfaddress);

        // Add Button
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 351, 100, 25);
        add.addActionListener(this);
        add(add);

        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 350, 100, 27);
        back.addActionListener(this);
        add(back);

        // Image Display
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/Customer icon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 400, 350);
        add(image);

        // Fetch and Display Customer Data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE customerID = '" + customerid + "'");
            while (rs.next()) {
                labelcustomerIDValue.setText(rs.getString("customerID"));
                labelnameValue.setText(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String customerid = labelcustomerIDValue.getText();
            String name = labelnameValue.getText();
            String id = (String) comboid.getSelectedItem();
            String emailid = tfemailid.getText();
            String number = tfphoneno.getText();
            String address = tfaddress.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer1 VALUES('" + customerid + "', '" + name + "', '" + id + "', '" + emailid + "', '" + number + "', '" + address + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addcustomer("");
    }
}
