import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ViewAccounts extends JFrame implements ActionListener {

    JButton back, delete;
    JTextField tfusername;
    JTable table;
    DefaultTableModel model;

    ViewAccounts() {
        setBounds(450, 200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("ACCOUNTS");
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setBounds(410, 10, 350, 30);
        add(text);

        JLabel lblusername = new JLabel("Enter Username to DELETE Account :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(80, 80, 350, 25);
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

        String[] columnNames = { "Username", "Name", "Password", "Security Q.", "Answer" };
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
            String query = "SELECT * FROM account";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String security = rs.getString("security");
                String answer = rs.getString("answer");

                model.addRow(new Object[] { username, name, password, security, answer });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == delete) {
            String username = tfusername.getText();
            if (!username.equals("")) {
                deleteAccount(username);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a Username !");
            }
        }
    }

    public void deleteAccount(String username) {
        try {
            Conn c = new Conn();
            String query = "DELETE FROM account WHERE username = '" + username + "'";
            int rowsAffected = c.s.executeUpdate(query);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Account Deleted successfully !");
                model.setRowCount(0);
                fetchData();
            } else {
                JOptionPane.showMessageDialog(null, "Account not found !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new ViewAccounts();
    }
}
