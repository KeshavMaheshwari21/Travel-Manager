import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payments extends JFrame implements ActionListener{
    
    JButton pay, back;

    Payments()
    {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        back = new JButton("Back");
        back.setBounds(690, 20, 80, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
        pay = new JButton("Pay");
        pay.setBounds(690, 80, 80, 40);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        image.add(pay);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
        } else {
            new Paytm();
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Payments();
    }
}
