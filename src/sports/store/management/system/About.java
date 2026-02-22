package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    About() {
        setBounds(430, 70, 500, 490);
        setLayout(null);
        setBackground(Color.white);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(210, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("seriff", Font.ITALIC, 20));
        add(l1);

        String s = "GEAR UP SPORTS STORE SYSTEM \n"
                + "\n#The Gear Up Sports Store System is a comprehensive solution designed to streamline your sporting goods retail operations. \n"
                + "\n#It empowers you to manage inventory, sales, customer information, and more, all in one platform. \n"
                + "\nAdvantages of Gear Up Sports Store:\n"
                + "\n1)Streamlined Inventory Management: Track stock levels, manage multiple locations, and receive automatic alerts for low stock. \n"
                + "\n2)Efficient Point of Sale: Process transactions quickly and accurately, handle returns and exchanges, and offer discounts and promotions. \n"
                + "\n3)Customer Relationship Management: Capture customer data, create loyalty programs, and send targeted marketing campaigns. \n"
                + "\n4)Real-time Analytics: Gain insights into sales performance, product popularity, and customer behavior to make informed decisions. \n"
                + "\n5)Mobile Access: Manage your store operations from anywhere with our mobile app. \n"
                + "\n6)Seamless Integrations: Connect Gear Up with other business systems like accounting software and e-commerce platforms.";

        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(190, 410, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
