package Event.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    private JLabel heading;

    Splash() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("EVENT MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1000, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 40));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton clickHere = new JButton("CLICK HERE TO CONTINUE");
        clickHere.setBounds(400, 400, 300, 70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);
        image.add(clickHere);

        setSize(1170, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Prevent resizing
        setVisible(true);

        animateHeading();
    }

    private void animateHeading() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    SwingUtilities.invokeLater(() -> heading.setVisible(false));
                    Thread.sleep(500);
                    SwingUtilities.invokeLater(() -> heading.setVisible(true));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login(); // Ensure Login class is adapted for event management system
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Splash());
    }
}
