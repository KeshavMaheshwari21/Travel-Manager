import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Admin extends JFrame implements ActionListener {

    String username;
    JButton viewAccounts, viewBookedPackages, viewBookedHotels, logOut ,registeredHotels, viewCustomerDetails;

    Admin() {
        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Admin");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        viewAccounts = new JButton("View Accounts");
        viewAccounts.setBounds(0, 0, 300, 50);
        viewAccounts.setBackground(new Color(0, 0, 102));
        viewAccounts.setForeground(Color.white);
        viewAccounts.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewAccounts.setMargin(new Insets(0, 0, 0, 100));
        viewAccounts.addActionListener(this);
        p2.add(viewAccounts);
        
        viewCustomerDetails = new JButton("Customer Details");
        viewCustomerDetails.setBounds(0, 50, 300, 50);
        viewCustomerDetails.setBackground(new Color(0, 0, 102));
        viewCustomerDetails.setForeground(Color.white);
        viewCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewCustomerDetails.setMargin(new Insets(0, 0, 0, 85));
        viewCustomerDetails.addActionListener(this);
        p2.add(viewCustomerDetails);
        
        viewBookedHotels = new JButton("View Booked Hotels");
        viewBookedHotels.setBounds(0, 100, 300, 50);
        viewBookedHotels.setBackground(new Color(0, 0, 102));
        viewBookedHotels.setForeground(Color.white);
        viewBookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedHotels.setMargin(new Insets(0, 0, 0, 60));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        viewBookedPackages = new JButton("View Booked Packages");
        viewBookedPackages.setBounds(0, 150, 300, 50);
        viewBookedPackages.setBackground(new Color(0, 0, 102));
        viewBookedPackages.setForeground(Color.white);
        viewBookedPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedPackages.setMargin(new Insets(0, 0, 0, 30));
        viewBookedPackages.addActionListener(this);
        p2.add(viewBookedPackages);

        registeredHotels = new JButton("Registered Hotels");
        registeredHotels.setBounds(0, 200, 300, 50);
        registeredHotels.setBackground(new Color(0, 0, 102));
        registeredHotels.setForeground(Color.white);
        registeredHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        registeredHotels.setMargin(new Insets(0, 0, 0, 80));
        registeredHotels.addActionListener(this);
        p2.add(registeredHotels);

        logOut = new JButton("Log Out");
        logOut.setBounds(0, 250, 300, 50);
        logOut.setBackground(new Color(0, 0, 102));
        logOut.setForeground(Color.white);
        logOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logOut.setMargin(new Insets(0, 0, 0, 165));
        logOut.addActionListener(this);
        p2.add(logOut);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(5, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewAccounts) {
            new ViewAccounts();
        } else if (ae.getSource() == viewBookedPackages) {
            new BookedPackages();
        } else if (ae.getSource() == viewBookedHotels) {
            new BookedHotels();
        } else if (ae.getSource() == registeredHotels) {
            new RegisteredHotel();
        } else if (ae.getSource() == viewCustomerDetails) {
            new CustomerDetails();
        } else if (ae.getSource() == logOut) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String args[]) {
        new Admin();
    }
}
