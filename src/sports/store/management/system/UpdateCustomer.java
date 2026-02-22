package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelcustomerID, labelname;
    JTextField tfemailid, tfphoneno, tfaddress, tfid;
    JButton add, back;

    UpdateCustomer(String customerid) {

        setBounds(250, 125, 825, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("seriff", Font.PLAIN, 20));
        add(text);

        labelcustomerID = new JLabel("CustomerID");
        labelcustomerID.setBounds(30, 50, 150, 25);
        add(labelcustomerID);

        labelcustomerID = new JLabel();
        labelcustomerID.setBounds(220, 50, 150, 25);
        add(labelcustomerID);

        labelname = new JLabel("Name");
        labelname.setBounds(30, 100, 150, 25);
        add(labelname);

        labelname = new JLabel();
        labelname.setBounds(220, 100, 150, 25);
        add(labelname);

        JLabel id = new JLabel("ID");
        id.setBounds(30, 150, 150, 25);
        add(id);

        tfid = new JTextField();
        tfid.setBounds(220, 150, 150, 25);
        add(tfid);

        JLabel emailID = new JLabel("Email ID");
        emailID.setBounds(30, 200, 150, 25);
        add(emailID);

        JLabel phoneNo = new JLabel("Phone Number");
        phoneNo.setBounds(30, 250, 150, 25);
        add(phoneNo);

        JLabel address = new JLabel("Address");
        address.setBounds(30, 300, 150, 25);
        add(address);

        tfemailid = new JTextField();
        tfemailid.setBounds(220, 200, 150, 25);
        add(tfemailid);

        tfphoneno = new JTextField();
        tfphoneno.setBounds(220, 250, 150, 25);
        add(tfphoneno);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 300, 150, 25);
        add(tfaddress);

        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 351, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 350, 100, 27);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/update customer details.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 400, 350);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where CustomerID = '" + customerid + "'");
            while (rs.next()) {
                labelcustomerID.setText(rs.getString("CustomerID"));
                labelname.setText(rs.getString("Name"));
                tfid.setText(rs.getString("ID"));
                tfemailid.setText(rs.getString("EmailID"));
                tfphoneno.setText(rs.getString("Phoneno"));
                tfaddress.setText(rs.getString("Address"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String customerid = labelcustomerID.getText();
            String name = labelname.getText();
            String id = tfid.getText();
            String emailid = tfemailid.getText();
            String number = tfphoneno.getText();
            String address = tfaddress.getText();

            try {
                Conn c = new Conn();
                String query = "update customer1 set CustomerID = '" + customerid + "', Name = '" + name + "', ID = '" + id + "', EmailID =  '" + emailid + "', Phoneno = '" + number + "', Address = '" + address + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
