import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class RegisteredHotel extends JFrame implements ActionListener {

    JButton back, delete;
    JTextField tfusername;
    JTable table;
    DefaultTableModel model;

    RegisteredHotel() {
        setBounds(450, 200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("BOOKED PACKAGES");
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setBounds(360, 10, 350, 30);
        add(text);

        JLabel lblusername = new JLabel("Enter Hotel Name to DELETE Data :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(70, 80, 350, 25);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(390, 80, 200, 25);
        add(tfusername);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(780, 80, 100, 25);
        back.addActionListener(this);
        add(back);

        delete = new JButton("Delete");
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBounds(650, 80, 100, 25);
        delete.addActionListener(this);
        add(delete);

        String[] columnNames = { "Hotel Name",  "Cost Per Person", "AC Room", "Food Included"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 150, 900, 400);
        add(sp);

        fetchData();
        setVisible(true);
    }

    public void fetchData() {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM hotel";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                String costperperson = rs.getString("costperperson");
                String acroom = rs.getString("acroom");
                String foodincluded = rs.getString("foodincluded");

                model.addRow(new Object[] { name, costperperson, acroom, foodincluded});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == delete) {
            String name = tfusername.getText();
            if (!name.equals("")) {
                deleteAccount(name);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a Hotel Name !");
            }
        }
    }

    public void deleteAccount(String name) {
        try {
            Conn c = new Conn();
            String query = "DELETE FROM hotel WHERE name = '" + name + "'";
            int rowsAffected = c.s.executeUpdate(query);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data Deleted successfully !");
                model.setRowCount(0);
                fetchData();
            } else {
                JOptionPane.showMessageDialog(null, "Data not found !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new RegisteredHotel();
    }
}
