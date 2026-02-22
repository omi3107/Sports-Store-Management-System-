package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateProductDetails extends JFrame implements ActionListener {

    JLabel labelcustomerID, labelname;
    JTextField tfproductType, tfselectedProduct, tfbrand, tfquantity, tfwarranty;
    JButton update, back;
    
    Conn c = new Conn(); 

    UpdateProductDetails(String customerid) {
        setBounds(250, 125, 825, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Product Details");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("serif", Font.PLAIN, 20));
        add(text);

        JLabel customerIdLabel = new JLabel("CustomerID:");
        customerIdLabel.setBounds(30, 50, 150, 25);
        add(customerIdLabel);

        labelcustomerID = new JLabel();
        labelcustomerID.setBounds(220, 50, 150, 25);
        add(labelcustomerID);

        JLabel productTypeLabel = new JLabel("Product Type:");
        productTypeLabel.setBounds(30, 100, 150, 25);
        add(productTypeLabel);

        tfproductType = new JTextField();
        tfproductType.setBounds(220, 100, 150, 25);
        add(tfproductType);

        JLabel selectedProductLabel = new JLabel("Product Selected:");
        selectedProductLabel.setBounds(30, 150, 150, 25);
        add(selectedProductLabel);

        tfselectedProduct = new JTextField();
        tfselectedProduct.setBounds(220, 150, 150, 25);
        add(tfselectedProduct);
        
        JLabel brandLabel = new JLabel("Brand:");
        brandLabel.setBounds(30, 200, 150, 25);
        add(brandLabel);

        tfbrand = new JTextField();
        tfbrand.setBounds(220, 200, 150, 25);
        add(tfbrand);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(30, 250, 150, 25);
        add(quantityLabel);

        tfquantity = new JTextField();
        tfquantity.setBounds(220, 250, 150, 25);
        add(tfquantity);

        JLabel warrantyLabel = new JLabel("Warranty Period:");
        warrantyLabel.setBounds(30, 300, 150, 25);
        add(warrantyLabel);

        tfwarranty = new JTextField();
        tfwarranty.setBounds(220, 300, 150, 25);
        add(tfwarranty);

        update = new JButton("Update");
        update.setBounds(70, 401, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(200, 401, 100, 27);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/update customer details.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(400, 20, 400, 350);
        add(image);

        loadProductDetails(customerid);

        setVisible(true);
    }

    private void loadProductDetails(String customerid) {
        try {
            String query = "SELECT * FROM products1234567 WHERE CustomerID = '" + customerid + "'";
            String query1 = "SELECT * FROM subproduct12345 WHERE CustomerID = '" + customerid + "'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                labelcustomerID.setText(rs.getString("CustomerID"));
                tfproductType.setText(rs.getString("product_type"));
                tfbrand.setText(rs.getString("brand"));
                tfquantity.setText(rs.getString("quantity"));
                tfwarranty.setText(rs.getString("warranty"));
            }

            ResultSet rs1 = c.s.executeQuery(query1);
            if (rs1.next()) {
                tfselectedProduct.setText(rs1.getString("teamsports_products"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String customerid = labelcustomerID.getText();
            String productType = tfproductType.getText();
            String selectedProduct = tfselectedProduct.getText();
            String brand = tfbrand.getText();
            String quantity = tfquantity.getText();
            String warranty = tfwarranty.getText();

            try {
                String updateQuery = "UPDATE products1234567 SET product_type = '" + productType + "', brand = '" + brand + "', quantity = '" + quantity + "', warranty = '" + warranty + "' WHERE CustomerID = '" + customerid + "'";

   
                String updateQuery1 = "UPDATE subproduct12345 SET teamsports_products = '"+ selectedProduct + "' WHERE CustomerID = '" + customerid + "'";

                c.s.executeUpdate(updateQuery);
                c.s.executeUpdate(updateQuery1);

                JOptionPane.showMessageDialog(null, "Product Details Updated Successfully");
                setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateProductDetails("");
    }
}

