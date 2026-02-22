package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SportsStoreManagementSystem extends JFrame implements ActionListener {

    SportsStoreManagementSystem() {
        setSize(720, 480);
        setLocation(300, 100);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/Frame image.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 720, 480); // locationsx, locationy, length, breadth
        add(image);

        JLabel text = new JLabel("SPORTS STORE");
        text.setBounds(10, 365, 700, 80);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.ITALIC, 50));
        image.add(text);

        JButton next = new JButton("NEXT");
        next.setBounds(560, 400, 125, 30);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.ITALIC, 15));
        image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Splash();
    }

    public static void main(String[] args) {
        new SportsStoreManagementSystem();
    }

}
