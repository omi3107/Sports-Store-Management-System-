package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewProducts extends JFrame implements ActionListener {

    JButton back;
    JLabel labelsubproduct;
    String customerid;

    public ViewProducts(String customerid) {
        this.customerid = customerid;

        setBounds(230, 70, 850, 565);
        setLayout(null);
        getContentPane().setBackground(Color.white);

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

        JLabel lblproduct = new JLabel("Product Type");
        lblproduct.setBounds(30, 140, 150, 25);
        add(lblproduct);

        JLabel labelproduct = new JLabel();
        labelproduct.setBounds(220, 140, 150, 25);
        add(labelproduct);

        JLabel lblsubproduct = new JLabel("Product Selected");
        lblsubproduct.setBounds(30, 200, 150, 25);
        add(lblsubproduct);

        labelsubproduct = new JLabel();
        labelsubproduct.setBounds(220, 200, 150, 25);
        add(labelsubproduct);

        JLabel lblbrand = new JLabel("Brand");
        lblbrand.setBounds(30, 260, 150, 25);
        add(lblbrand);

        JLabel labelbrand = new JLabel();
        labelbrand.setBounds(220, 260, 150, 25);
        add(labelbrand);

        JLabel lblquantity = new JLabel("Quantity");
        lblquantity.setBounds(30, 320, 150, 25);
        add(lblquantity);

        JLabel labelquantity = new JLabel();
        labelquantity.setBounds(220, 320, 200, 25);
        add(labelquantity);

        JLabel lblwarranty = new JLabel("Warranty Period");
        lblwarranty.setBounds(30, 380, 150, 25);
        add(lblwarranty);

        JLabel labelwarranty = new JLabel();
        labelwarranty.setBounds(220, 380, 150, 25);
        add(labelwarranty);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(30, 440, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 440, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(105, 485, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/View products icon.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 80, 400, 350);
        add(image);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM products1234567 WHERE customerID = '" + customerid + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelcustomerid.setText(rs.getString("customerID"));
                labelproduct.setText(rs.getString("product_type"));
                labelbrand.setText(rs.getString("brand"));
                labelquantity.setText(rs.getString("quantity"));
                labelwarranty.setText(rs.getString("warranty"));
                labelprice.setText(rs.getString("total_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Call displayProducts to show the currently selected product
        displayProducts(); 

        setVisible(true);
    }

public void displayProducts() {
    try {
        // Initialize connection
        Conn conn = new Conn();

        // Corrected query to fetch the latest row for the user based on time or ID
        String query = "SELECT * FROM subproduct12345 WHERE customerID = '" 
                        + customerid + "' ORDER BY purchase_time DESC LIMIT 1";
        
        ResultSet rs = conn.s.executeQuery(query);

        // Clear previous product selection
        labelsubproduct.setText("");

        // Process the latest row and print non-null product values
        if (rs.next()) {
            StringBuilder products = new StringBuilder();  // Store non-null product names

            // Iterate through columns starting from 2 to skip customerID
            for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
                String product = rs.getString(i);  // Get the product name from the current column

                // Check if the value is non-null and non-empty
                if (product != null && !product.isEmpty()) {
                    products.append(product).append(", ");  // Add product name with a comma
                }
            }

            // If valid products are found, set them in the label
            if (products.length() > 0) {
                // Remove the trailing comma and space
                labelsubproduct.setText(products.substring(0, products.length() - 2));
            } else {
                // No valid products found, display fallback message
                labelsubproduct.setText("No valid products found");
            }
        } else {
            // No rows found for the user
            labelsubproduct.setText("No products selected");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewProducts("omi3107");
    }
}