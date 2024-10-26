import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String about = "Tour and Travel Management System\n\n"
                + "This project is developed using Advanced Java and aims to simplify travel operations "
                + "for agencies and customers. It allows users to browse, book, and manage travel packages, "
                + "while enabling administrators to handle package creation and customer data management. "
                + "The system integrates with a secure database to store and manage bookings, preferences, "
                + "and transactions, providing a seamless experience for both customers and administrators.\n\n"
                + "Key Features:\n"
                + "1. Streamlined travel planning and booking system.\n"
                + "2. Customer profile and booking management.\n"
                + "3. Secure payment integration and transaction handling.\n"
                + "4. Administrator access for managing tour packages and bookings.\n"
                + "5. Database integration for efficient data management.";

        TextArea area = new TextArea(about, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        back = new JButton("Back");
        back.setBounds(200, 420, 80, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
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
