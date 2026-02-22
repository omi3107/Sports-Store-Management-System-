package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    String customerid;
    JButton addcustomerDetails, viewcustomerDetails, updatecustomerDetails, checkProducts, addtocartProducts, payment, calculator, logout, notepad, about, deletecustomerDetails, updateproductdetails;

    Dashboard(String customerid) {
        this.customerid = customerid;
        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/Dashboard icon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("serif", Font.ITALIC, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addcustomerDetails = new JButton("Add Customer Details");
        addcustomerDetails.setBounds(0, 0, 300, 50);
        addcustomerDetails.setBackground(new Color(0, 0, 102));
        addcustomerDetails.setForeground(Color.WHITE);
        addcustomerDetails.setFont(new Font("serif", Font.ITALIC, 20));
        addcustomerDetails.setMargin(new Insets(0, 0, 0, 60)); // top,left,bottom,right
        addcustomerDetails.addActionListener(this);
        p2.add(addcustomerDetails);

        updatecustomerDetails = new JButton("Update Customer Details");
        updatecustomerDetails.setBounds(0, 50, 300, 50);
        updatecustomerDetails.setBackground(new Color(0, 0, 102));
        updatecustomerDetails.setForeground(Color.WHITE);
        updatecustomerDetails.setFont(new Font("serif", Font.ITALIC, 20));
        updatecustomerDetails.setMargin(new Insets(0, 0, 0, 45)); // top,left,bottom,right
        updatecustomerDetails.addActionListener(this);
        p2.add(updatecustomerDetails);

        viewcustomerDetails = new JButton("View Customer Details");
        viewcustomerDetails.setBounds(0, 100, 300, 50);
        viewcustomerDetails.setBackground(new Color(0, 0, 102));
        viewcustomerDetails.setForeground(Color.WHITE);
        viewcustomerDetails.setFont(new Font("serif", Font.ITALIC, 20));
        viewcustomerDetails.setMargin(new Insets(0, 0, 0, 65)); // top,left,bottom,right
        viewcustomerDetails.addActionListener(this);
        p2.add(viewcustomerDetails);

        deletecustomerDetails = new JButton("Delete Customer Details");
        deletecustomerDetails.setBounds(0, 150, 300, 50);
        deletecustomerDetails.setBackground(new Color(0, 0, 102));
        deletecustomerDetails.setForeground(Color.WHITE);
        deletecustomerDetails.setFont(new Font("serif", Font.ITALIC, 20));
        deletecustomerDetails.setMargin(new Insets(0, 0, 0, 50)); // top,left,bottom,right
        deletecustomerDetails.addActionListener(this);
        p2.add(deletecustomerDetails);

        checkProducts = new JButton("Check Products");
        checkProducts.setBounds(0, 200, 300, 50);
        checkProducts.setBackground(new Color(0, 0, 102));
        checkProducts.setForeground(Color.WHITE);
        checkProducts.setFont(new Font("serif", Font.ITALIC, 20));
        checkProducts.setMargin(new Insets(0, 0, 0, 125)); // top,left,bottom,right
        checkProducts.addActionListener(this);
        p2.add(checkProducts);

        addtocartProducts = new JButton("Add to Cart");
        addtocartProducts.setBounds(0, 250, 300, 50);
        addtocartProducts.setBackground(new Color(0, 0, 102));
        addtocartProducts.setForeground(Color.WHITE);
        addtocartProducts.setFont(new Font("serif", Font.ITALIC, 20));
        addtocartProducts.setMargin(new Insets(0, 0, 0, 155)); // top,left,bottom,right
        addtocartProducts.addActionListener(this);
        p2.add(addtocartProducts);

        updateproductdetails = new JButton("Update Product Details");
        updateproductdetails.setBounds(0, 300, 300, 50);
        updateproductdetails.setBackground(new Color(0, 0, 102));
        updateproductdetails.setForeground(Color.WHITE);
        updateproductdetails.setFont(new Font("serif", Font.ITALIC, 20));
        updateproductdetails.setMargin(new Insets(0, 0, 0, 60)); // top,left,bottom,right
        updateproductdetails.addActionListener(this);
        p2.add(updateproductdetails);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 350, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("serif", Font.ITALIC, 20));
        calculator.setMargin(new Insets(0, 0, 0, 170)); // top,left,bottom,right
        calculator.addActionListener(this);
        p2.add(calculator);

        payment = new JButton("Payment");
        payment.setBounds(0, 400, 300, 50);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("serif", Font.ITALIC, 20));
        payment.setMargin(new Insets(0, 0, 0, 185)); // top,left,bottom,right
        payment.addActionListener(this);
        p2.add(payment);

        logout = new JButton("Logout");
        logout.setBounds(0, 450, 300, 50);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("serif", Font.ITALIC, 20));
        logout.setMargin(new Insets(0, 0, 0, 195)); // top,left,bottom,right
        logout.addActionListener(this);
        p2.add(logout);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 500, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("serif", Font.ITALIC, 20));
        notepad.setMargin(new Insets(0, 0, 0, 195)); // top,left,bottom,right
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 550, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("serif", Font.ITALIC, 20));
        about.setMargin(new Insets(0, 0, 0, 205)); // top,left,bottom,right
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Images/Dashboard.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("GearUp Sports Store");
        text.setBounds(310, 50, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.ITALIC, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addcustomerDetails) {
            new Addcustomer(customerid);
        } else if (ae.getSource() == viewcustomerDetails) {
            new ViewCustomer(customerid);
        } else if (ae.getSource() == updatecustomerDetails) {
            new UpdateCustomer(customerid);
        } else if (ae.getSource() == checkProducts) {
            new CheckProducts();
        } else if (ae.getSource() == addtocartProducts) {
            new AddtoCart(customerid);
        } else if (ae.getSource() == payment) {
            new Payment();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        } else if (ae.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {
            new About();
        } else if (ae.getSource() == deletecustomerDetails) {
            new DeleteDetails(customerid);
        } else if (ae.getSource() == updateproductdetails) {
            new UpdateProductDetails(customerid);
        }
    }

    public static void main(String[] args) {
        new Dashboard("Omkar123");
    }
}
