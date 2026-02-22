package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;

    ViewCustomer(String customerid) {
        setBounds(250, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("View Product Details");
        text.setFont(new Font("seriff", Font.ITALIC, 20));
        text.setBounds(30, 10, 300, 30);
        add(text);

        JLabel lblcustomerid = new JLabel("Customer ID");
        lblcustomerid.setBounds(30, 80, 150, 25);
        add(lblcustomerid);

        JLabel labelcustomerid = new JLabel();
        labelcustomerid.setBounds(220, 80, 150, 25);
        add(labelcustomerid);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 150, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 150, 150, 25);
        add(labelname);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 220, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 220, 150, 25);
        add(labelid);

        JLabel lblemailid = new JLabel("Email ID");
        lblemailid.setBounds(30, 290, 150, 25);
        add(lblemailid);

        JLabel labelemailid = new JLabel();
        labelemailid.setBounds(220, 290, 200, 25);
        add(labelemailid);

        JLabel lblphoneno = new JLabel("Phone Number");
        lblphoneno.setBounds(30, 360, 150, 25);
        add(lblphoneno);

        JLabel labelphoneno = new JLabel();
        labelphoneno.setBounds(220, 360, 150, 25);
        add(labelphoneno);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 430, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(220, 430, 150, 25);
        add(labeladdress);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 475, 100, 25);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            String query = "Select * from customer1 where CustomerID = '" + customerid + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelcustomerid.setText(rs.getString("CustomerID"));
                labelname.setText(rs.getString("Name"));
                labelid.setText(rs.getString("ID"));
                labelemailid.setText(rs.getString("EmailID"));
                labelphoneno.setText(rs.getString("Phoneno"));
                labeladdress.setText(rs.getString("Address"));
            }
        } catch (Exception e) {

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String args[]) {
        new ViewCustomer("");
    }
}
