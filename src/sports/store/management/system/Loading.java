package sports.store.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    JLabel lblname, lblloading, lbltext;
    String customerid;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); //100
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(true);
                    new Dashboard(customerid);
                    //new class object
                }
                Thread.sleep(25);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String customerid) {
        this.customerid = customerid;
        t = new Thread(this);

        setBounds(340, 150, 625, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        lbltext = new JLabel("GearUp Sports Store Application");
        lbltext.setBounds(60, 30, 600, 40);
        lbltext.setForeground(Color.BLUE);
        lbltext.setFont(new Font("Raleway", Font.ITALIC, 35));
        add(lbltext);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        lblloading = new JLabel("Loading,Please wait...");
        lblloading.setBounds(200, 140, 250, 35);
        lblloading.setForeground(Color.RED);
        lblloading.setFont(new Font("serif", Font.ITALIC, 25));
        add(lblloading);

        lblname = new JLabel("Welcome " + customerid);
        lblname.setBounds(20, 310, 400, 40);
        lblname.setForeground(Color.RED);
        lblname.setFont(new Font("serif", Font.ITALIC, 30));
        add(lblname);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("omi3107");
    }
}
