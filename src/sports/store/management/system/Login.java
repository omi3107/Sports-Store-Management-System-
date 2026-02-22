package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, password, signup;
    JTextField tfcustomerid, tfpassword;
    String customerid;

    Login() {
        setSize(900, 400);
        setLocation(230, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/customer login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 100, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblcustomerid = new JLabel("Customer ID");
        lblcustomerid.setBounds(60, 20, 140, 25);
        lblcustomerid.setFont(new Font("serif", Font.ITALIC, 20));
        p2.add(lblcustomerid);

        tfcustomerid = new JTextField();
        tfcustomerid.setBounds(60, 60, 300, 30);
        tfcustomerid.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfcustomerid);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 140, 25);
        lblpassword.setFont(new Font("serif", Font.ITALIC, 20));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 210, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(230, 210, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(140, 260, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String name = tfcustomerid.getText();
                String pass = tfpassword.getText();

                String query = "select * from customer where customerID = '" + name + "' AND password = '" + pass + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(name);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect CustomerID or Password");
                }
            } catch (Exception e) {

            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUp();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
