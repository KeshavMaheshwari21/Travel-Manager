import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(30);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {

        this.username = username;

        t = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel Manager");
        text.setBounds(180, 20, 600, 40);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        JLabel loading = new JLabel("Loading and Please Wait...");
        loading.setBounds(215, 130, 200, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 14));
        add(loading);

        JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(20, 300, 310, 40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblusername);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        t.start();

        setVisible(true);
    }

    public static void main(String args[]) {
        new Loading("");
    }
}
