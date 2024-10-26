import java.awt.*;
import javax.swing.*;

public class Admin_Loading extends JFrame implements Runnable {

    Thread t;

    public void run() {
        try {
            Thread.sleep(6500);
            setVisible(false);
            new Admin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Admin_Loading() {

        t = new Thread(this);

        setBounds(500, 200, 650, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/download.gif"));
        Image i2 = i1.getImage().getScaledInstance(650, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 650, 400);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/admin_img.gif"));
        Image i5 = i4.getImage().getScaledInstance(250, 130, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        icon.setBounds(215, 90, 200, 200);
        image.add(icon);

        JLabel loading = new JLabel("Loading and Please Wait...");
        loading.setBounds(410, 415, 220, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        t.start();

        setVisible(true);
    }

    public static void main(String args[]) {
        new Admin_Loading();
    }
}
