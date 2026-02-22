package sports.store.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddtoCart extends JFrame implements ActionListener {

    Choice products, teamSportsDropdown, fitnessDropdown, trekkingDropdown, cyclingDropdown, indoorSportsDropdown,
            accessoriesDropdown, shoesDropdown, jerseysDropdown, brand, warrantyperiod;
    JTextField tfemailid, tfphoneno;
    JLabel labelcustomerid, labeladdress;
    JButton checktotalprice, addproducts, back, remove;
    String customerid;

    AddtoCart(String customerid) {
        this.customerid = customerid;
        setBounds(100, 100, 1100, 500);
        setLayout(null);

        JLabel text = new JLabel("Add To Cart");
        text.setBounds(30, 10, 300, 30);
        text.setFont(new Font("seriff", Font.ITALIC, 25));
        add(text);

        JLabel lblcustomerid = new JLabel("Customer ID");
        lblcustomerid.setFont(new Font("seriff", Font.ITALIC, 16));
        lblcustomerid.setBounds(30, 80, 100, 20);
        add(lblcustomerid);

        labelcustomerid = new JLabel();
        labelcustomerid.setFont(new Font("seriff", Font.ITALIC, 16));
        labelcustomerid.setBounds(200, 80, 100, 20);
        add(labelcustomerid);

        JLabel lblname = new JLabel("Select Products");
        lblname.setFont(new Font("seriff", Font.ITALIC, 16));
        lblname.setBounds(30, 140, 160, 20);
        add(lblname);

        // Main Product Dropdown
        products = new Choice();
        products.add("");
        products.add("Teams sports");
        products.add("Fitness");
        products.add("Trekking and Hiking");
        products.add("Cycling");
        products.add("Indoor Sports");
        products.add("Sports Accessories");
        products.add("Shoes");
        products.add("Jerseys");
        products.setBounds(200, 140, 220, 20);
        add(products);

        // Teams Sports Dropdown
        teamSportsDropdown = new Choice();
        teamSportsDropdown.add("");
        teamSportsDropdown.add("Cricket Kit");
        teamSportsDropdown.add("Football Kit");
        teamSportsDropdown.add("Badminton Kit");
        teamSportsDropdown.add("Volleyball Kit");
        teamSportsDropdown.add("Basketball Kit");
        teamSportsDropdown.add("Hockey Kit");
        teamSportsDropdown.setBounds(450, 140, 220, 20);
        add(teamSportsDropdown);

        // Fitness Dropdown
        fitnessDropdown = new Choice();
        fitnessDropdown.add("");
        fitnessDropdown.add("Gym Equipment Kit");
        fitnessDropdown.add("Adjustable Dumbbells");
        fitnessDropdown.add("Treadmill");
        fitnessDropdown.add("Benchpress Machine");
        fitnessDropdown.add("Legs Equipments");
        fitnessDropdown.add("Exercise Bike");
        fitnessDropdown.add("Gym Bags");
        fitnessDropdown.setBounds(450, 140, 220, 20);
        add(fitnessDropdown);

        // Trekking and Hiking Dropdown
        trekkingDropdown = new Choice();
        trekkingDropdown.add("");
        trekkingDropdown.add("Trekking Jackets");
        trekkingDropdown.add("Trekking Shoes");
        trekkingDropdown.add("Tents");
        trekkingDropdown.add("Backpack");
        trekkingDropdown.add("Waist Bags");
        trekkingDropdown.add("Compass");
        trekkingDropdown.add("Binoculars");
        trekkingDropdown.add("Gloves");
        trekkingDropdown.setBounds(450, 140, 220, 20);
        add(trekkingDropdown);

        // Cycling Dropdown
        cyclingDropdown = new Choice();
        cyclingDropdown.add("");
        cyclingDropdown.add("Cycles");
        cyclingDropdown.add("Foldable Cycles");
        cyclingDropdown.add("Helmets");
        cyclingDropdown.add("Cycling Clothing");
        cyclingDropdown.add("Air Pump");
        cyclingDropdown.add("Locks");
        cyclingDropdown.add("Cycling Accessories");
        cyclingDropdown.setBounds(450, 140, 220, 20);
        add(cyclingDropdown);

        // Indoor Sports Dropdown
        indoorSportsDropdown = new Choice();
        indoorSportsDropdown.add("");
        indoorSportsDropdown.add("Table Tennis Kit");
        indoorSportsDropdown.add("TT Table");
        indoorSportsDropdown.add("Badminton");
        indoorSportsDropdown.add("Squash Rackets");
        indoorSportsDropdown.add("Carrom");
        indoorSportsDropdown.add("Chess");
        indoorSportsDropdown.add("Boxing Kit");
        indoorSportsDropdown.add("Dart Board");
        indoorSportsDropdown.add("Archery");
        indoorSportsDropdown.add("Padel");
        indoorSportsDropdown.setBounds(450, 140, 220, 20);
        add(indoorSportsDropdown);

        // Sports Accessories Dropdown
        accessoriesDropdown = new Choice();
        accessoriesDropdown.add("");
        accessoriesDropdown.add("Water Bottles");
        accessoriesDropdown.add("Sunglasses");
        accessoriesDropdown.add("Gloves");
        accessoriesDropdown.add("Resistance Bands");
        accessoriesDropdown.add("First-Aid Kit");
        accessoriesDropdown.add("Socks");
        accessoriesDropdown.add("Micro-Fiber Towels");
        accessoriesDropdown.add("Massagers");
        accessoriesDropdown.add("Proteins,Bars");
        accessoriesDropdown.setBounds(450, 140, 220, 20);
        add(accessoriesDropdown);

        // Shoes Dropdown
        shoesDropdown = new Choice();
        shoesDropdown.add("");
        shoesDropdown.add("Running Shoes");
        shoesDropdown.add("Casual Shoes");
        shoesDropdown.add("Cleats");
        shoesDropdown.add("Football Studs");
        shoesDropdown.add("Football Trainers");
        shoesDropdown.add("Cricket Shoes");
        shoesDropdown.add("Badminton Shoes");
        shoesDropdown.add("Basketball Shoes");
        shoesDropdown.add("Sneakers");
        shoesDropdown.setBounds(450, 140, 220, 20);
        add(shoesDropdown);

        // Jerseys Dropdown
        jerseysDropdown = new Choice();
        jerseysDropdown.add("");
        jerseysDropdown.add("Team Jerseys");
        jerseysDropdown.add("Training Jerseys");
        jerseysDropdown.add("Custom Jerseys");
        jerseysDropdown.setBounds(450, 140, 220, 20);
        add(jerseysDropdown);

        // Set all dropdowns except products as invisible initially
        teamSportsDropdown.setVisible(false);
        fitnessDropdown.setVisible(false);
        trekkingDropdown.setVisible(false);
        cyclingDropdown.setVisible(false);
        indoorSportsDropdown.setVisible(false);
        accessoriesDropdown.setVisible(false);
        shoesDropdown.setVisible(false);
        jerseysDropdown.setVisible(false);

        // Action Listener to show respective dropdown based on product selection
        products.addItemListener(e -> {
            String selectedProduct = products.getSelectedItem();

            // Hide all dropdowns
            teamSportsDropdown.setVisible(false);
            fitnessDropdown.setVisible(false);
            trekkingDropdown.setVisible(false);
            cyclingDropdown.setVisible(false);
            indoorSportsDropdown.setVisible(false);
            accessoriesDropdown.setVisible(false);
            shoesDropdown.setVisible(false);
            jerseysDropdown.setVisible(false);

            // Show relevant dropdown
            switch (selectedProduct) {
                case "Teams sports":
                    teamSportsDropdown.setVisible(true);
                    break;
                case "Fitness":
                    fitnessDropdown.setVisible(true);
                    break;
                case "Trekking and Hiking":
                    trekkingDropdown.setVisible(true);
                    break;
                case "Cycling":
                    cyclingDropdown.setVisible(true);
                    break;
                case "Indoor Sports":
                    indoorSportsDropdown.setVisible(true);
                    break;
                case "Sports Accessories":
                    accessoriesDropdown.setVisible(true);
                    break;
                case "Shoes":
                    shoesDropdown.setVisible(true);
                    break;
                case "Jerseys":
                    jerseysDropdown.setVisible(true);
                    break;
            }
        });

        JLabel lblid = new JLabel("Select Brand");
        lblid.setFont(new Font("seriff", Font.ITALIC, 16));
        lblid.setBounds(30, 200, 100, 25);
        add(lblid);

        brand = new Choice();
        brand.add("");
        brand.add("Nike");
        brand.add("Adidas");
        brand.add("Puma");
        brand.add("Decathlon");
        brand.add("New Balance");
        brand.add("Reebok");
        brand.add("The North Face");
        brand.add("Asics");
        brand.add("Patagonia");
        brand.add("Salomon");
        brand.setBounds(200, 200, 220, 20);
        add(brand);

        JLabel lblemailid = new JLabel("Quantity");
        lblemailid.setFont(new Font("seriff", Font.ITALIC, 16));
        lblemailid.setBounds(30, 260, 150, 25);
        add(lblemailid);

        tfemailid = new JTextField();
        tfemailid.setBounds(200, 260, 220, 20);
        add(tfemailid);

        JLabel lblphoneno = new JLabel("Warranty Period");
        lblphoneno.setFont(new Font("seriff", Font.ITALIC, 16));
        lblphoneno.setBounds(30, 320, 150, 25);
        add(lblphoneno);

        warrantyperiod = new Choice();
        warrantyperiod.add("");
        warrantyperiod.add("1 year");
        warrantyperiod.add("2 year");
        warrantyperiod.add("3 year");
        warrantyperiod.setBounds(200, 320, 220, 20);
        add(warrantyperiod);

        JLabel lbladdress = new JLabel("Total Price");
        lbladdress.setFont(new Font("seriff", Font.ITALIC, 16));
        lbladdress.setBounds(30, 380, 150, 25);
        add(lbladdress);

        labeladdress = new JLabel();
        labeladdress.setBounds(200, 380, 220, 20);
        add(labeladdress);

        try {
            Conn conn = new Conn();
            String query = "Select * from customer1 where CustomerID = '" + customerid + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelcustomerid.setText(rs.getString("CustomerID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checktotalprice = new JButton("Total Price");
        checktotalprice.setBackground(Color.BLACK);
        checktotalprice.setForeground(Color.white);
        checktotalprice.setBounds(60, 420, 120, 25);
        checktotalprice.addActionListener(this);
        add(checktotalprice);

        addproducts = new JButton("Add Products");
        addproducts.setBackground(Color.BLACK);
        addproducts.setForeground(Color.white);
        addproducts.setBounds(200, 420, 120, 25);
        addproducts.addActionListener(this);
        add(addproducts);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340, 420, 120, 25);
        back.addActionListener(this);
        add(back);

        remove = new JButton("Remove");
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.white);
        remove.setBounds(480, 420, 120, 25);
        remove.addActionListener(this);
        add(remove);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/Add to cart.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(670, 40, 400, 350);
        add(image);

        setVisible(true);
    }

    public void removeSelectedProduct() {
        String selectedProduct = products.getSelectedItem();
        switch (selectedProduct) {
            case "Teams sports" ->
                teamSportsDropdown.remove(teamSportsDropdown.getSelectedItem());
            case "Fitness" ->
                fitnessDropdown.remove(fitnessDropdown.getSelectedItem());
            case "Trekking and Hiking" ->
                trekkingDropdown.remove(trekkingDropdown.getSelectedItem());
            case "Cycling" ->
                cyclingDropdown.remove(cyclingDropdown.getSelectedItem());
            case "Indoor Sports" ->
                indoorSportsDropdown.remove(indoorSportsDropdown.getSelectedItem());
            case "Sports Accessories" ->
                accessoriesDropdown.remove(accessoriesDropdown.getSelectedItem());
            case "Shoes" ->
                shoesDropdown.remove(shoesDropdown.getSelectedItem());
            case "Jerseys" ->
                jerseysDropdown.remove(jerseysDropdown.getSelectedItem());
        }
    }

    public void hideAllSubDropdowns() {
        teamSportsDropdown.setVisible(false);
        fitnessDropdown.setVisible(false);
        trekkingDropdown.setVisible(false);
        cyclingDropdown.setVisible(false);
        indoorSportsDropdown.setVisible(false);
        accessoriesDropdown.setVisible(false);
        shoesDropdown.setVisible(false);
        jerseysDropdown.setVisible(false);
    }

    public void hideAllDropdowns() {
        products.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        int cost = 0;
        String sproducts = products.getSelectedItem();
        if (ae.getSource() == checktotalprice) {
            switch (sproducts) {
                case "Teams sports":
                    String teamSports = teamSportsDropdown.getSelectedItem();
                    switch (teamSports) {
                        case "Cricket Kit":
                            cost += 15000;
                            break;
                        case "Football Kit":
                            cost += 9000;
                            break;
                        case "Badminton Kit":
                            cost += 5000;
                            break;
                        case "Basketball Kit":
                            cost += 5000;
                            break;
                        case "Volleyball Kit":
                            cost += 4000;
                            break;
                        case "Hockey Kit":
                            cost += 8000;
                            break;
                    }
                    break;

                case "Fitness":
                    String fitness = fitnessDropdown.getSelectedItem();
                    switch (fitness) {
                        case "Gym Equipment Kit":
                            cost += 12000;
                            break;
                        case "Adjustable Dumbbells":
                            cost += 8000;
                            break;
                        case "Treadmill":
                            cost += 40000;
                            break;
                        case "Benchpress Machine":
                            cost += 15000;
                            break;
                        case "Legs Equipments":
                            cost += 12000;
                            break;
                        case "Exercise Bike":
                            cost += 20000;
                            break;
                        case "Gym Bags":
                            cost += 1500;
                            break;
                    }
                    break;

                case "Trekking and Hiking":
                    String trekking = trekkingDropdown.getSelectedItem();
                    switch (trekking) {
                        case "Trekking Jackets":
                            cost += 5000;
                            break;
                        case "Trekking Shoes":
                            cost += 7000;
                            break;
                        case "Tents":
                            cost += 8000;
                            break;
                        case "Backpack":
                            cost += 3500;
                            break;
                        case "Waist Bags":
                            cost += 1500;
                            break;
                        case "Compass":
                            cost += 700;
                            break;
                        case "Binoculars":
                            cost += 2500;
                            break;
                        case "Gloves":
                            cost += 1000;
                            break;
                    }
                    break;

                case "Cycling":
                    String cycling = cyclingDropdown.getSelectedItem();  // Fixed: Retrieve from correct dropdown
                    switch (cycling) {
                        case "Cycles":
                            cost += 35000;
                            break;
                        case "Foldable Cycles":
                            cost += 25000;
                            break;
                        case "Helmets":
                            cost += 1500;
                            break;
                        case "Cycling Clothing":
                            cost += 2000;
                            break;
                        case "Air Pump":
                            cost += 800;
                            break;
                        case "Locks":
                            cost += 1000;
                            break;
                        case "Cycling Accessories":
                            cost += 2000;
                            break;
                    }
                    break;

                case "Indoor Sports":
                    String indoorSports = indoorSportsDropdown.getSelectedItem();
                    switch (indoorSports) {
                        case "Table Tennis Kit":
                            cost += 2500;
                            break;
                        case "TT Table":
                            cost += 30000;
                            break;
                        case "Badminton":
                            cost += 1500;
                            break;
                        case "Squash Rackets":
                            cost += 2500;
                            break;
                        case "Carrom":
                            cost += 1800;
                            break;
                        case "Chess":
                            cost += 1200;
                            break;
                        case "Boxing Kit":
                            cost += 5000;
                            break;
                        case "Dart Board":
                            cost += 2000;
                            break;
                    }
                    break;

                case "Sports Accessories":
                    String accessories = accessoriesDropdown.getSelectedItem();
                    switch (accessories) {
                        case "Water Bottles":
                            cost += 700;
                            break;
                        case "Sunglasses":
                            cost += 1500;
                            break;
                        case "Gloves":
                            cost += 800;
                            break;
                        case "Resistance Bands":
                            cost += 1000;
                            break;
                        case "First-Aid Kit":
                            cost += 1200;
                            break;
                        case "Socks":
                            cost += 500;
                            break;
                        case "Micro-Fiber Towels":
                            cost += 600;
                            break;
                        case "Massagers":
                            cost += 2000;
                            break;
                        case "Protein Powder":
                            cost += 3500;
                            break;
                        case "Protein Bars":
                            cost += 100;
                            break;
                    }
                    break;

                case "Shoes":
                    String shoes = shoesDropdown.getSelectedItem();
                    switch (shoes) {
                        case "Running Shoes":
                            cost += 7000;
                            break;
                        case "Casual Shoes":
                            cost += 8000;
                            break;
                        case "Cleats":
                            cost += 4000;
                            break;
                        case "Football Studs":
                            cost += 7000;
                            break;
                        case "Football Trainers":
                            cost += 2500;
                            break;
                        case "Cricket Shoes":
                            cost += 3000;
                            break;
                        case "Badminton Shoes":
                            cost += 3000;
                            break;
                        case "Basketball Shoes":
                            cost += 5000;
                            break;
                        case "Sneakers":
                            cost += 10000;
                            break;
                    }
                    break;

                case "Jerseys":
                    String jerseys = jerseysDropdown.getSelectedItem();
                    switch (jerseys) {
                        case "Team Jerseys":
                            cost += 4000;
                            break;
                        case "Training Jerseys":
                            cost += 2200;
                            break;
                        case "Custom Jerseys":
                            cost += 2000;
                            break;
                    }
                    break;
            }
            int quantity = Integer.parseInt(tfemailid.getText());
            int totalprice = cost * quantity;
            labeladdress.setText("Rs " + totalprice);
        } else if (ae.getSource() == addproducts) {
            try {
                if (products.getSelectedItem() == null || brand.getSelectedItem().equals("")
                        || products.getSelectedItem().equals("Select Product")
                        || (teamSportsDropdown.getSelectedItem() == null
                        && fitnessDropdown.getSelectedItem() == null
                        && trekkingDropdown.getSelectedItem() == null
                        && cyclingDropdown.getSelectedItem() == null
                        && indoorSportsDropdown.getSelectedItem() == null
                        && accessoriesDropdown.getSelectedItem() == null
                        && shoesDropdown.getSelectedItem() == null
                        && jerseysDropdown.getSelectedItem() == null)) {
                    JOptionPane.showMessageDialog(null, "No Products Added");
                } else {
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into products1234567 values('" + labelcustomerid.getText() + "','" + products.getSelectedItem() + "','" + brand.getSelectedItem() + "','" + tfemailid.getText() + "','" + warrantyperiod.getSelectedItem() + "','" + labeladdress.getText() + "',CURRENT_TIMESTAMP)");
                    c.s.executeUpdate("insert into subproduct12345 values('" + labelcustomerid.getText() + "','" + teamSportsDropdown.getSelectedItem() + "','" + fitnessDropdown.getSelectedItem() + "','" + trekkingDropdown.getSelectedItem() + "','" + cyclingDropdown.getSelectedItem() + "','" + indoorSportsDropdown.getSelectedItem() + "','" + accessoriesDropdown.getSelectedItem() + "','" + shoesDropdown.getSelectedItem() + "','" + jerseysDropdown.getSelectedItem() + "')");
                    JOptionPane.showMessageDialog(null, "Products Added Sucessfully!!");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == remove) {
            removeSelectedProduct();
            hideAllSubDropdowns();
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new AddtoCart("omi3107");
    }
}
