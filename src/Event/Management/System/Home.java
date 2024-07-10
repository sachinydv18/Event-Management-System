package Event.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton view, add, remove;

    Home() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Event Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Event");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Event");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        // Adjust the position of the "Remove Event" button
        remove = new JButton("Remove Event");
        remove.setBounds(735, 140, 150, 40); // Adjusted position
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEvent();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEvent();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEvent();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
