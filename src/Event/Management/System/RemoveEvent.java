package Event.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEvent extends JFrame implements ActionListener {

    Choice cEventId;
    JButton delete, back;

    RemoveEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelEventId = new JLabel("Event Id");
        labelEventId.setBounds(50, 50, 100, 30);
        add(labelEventId);

        cEventId = new Choice();
        cEventId.setBounds(200, 50, 150, 30);
        add(cEventId);

        try {
            conn c = new conn();
            String query = "select * from events";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEventId.add(rs.getString("eventId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelEventName = new JLabel("Event Name");
        labelEventName.setBounds(50, 100, 100, 30);
        add(labelEventName);

        JLabel lblEventName = new JLabel();
        lblEventName.setBounds(200, 100, 100, 30);
        add(lblEventName);

        JLabel labelStartDate = new JLabel("Start Date");
        labelStartDate.setBounds(50, 150, 100, 30);
        add(labelStartDate);

        JLabel lblStartDate = new JLabel();
        lblStartDate.setBounds(200, 150, 100, 30);
        add(lblStartDate);

        JLabel labelEndDate = new JLabel("End Date");
        labelEndDate.setBounds(50, 200, 100, 30);
        add(labelEndDate);

        JLabel lblEndDate = new JLabel();
        lblEndDate.setBounds(200, 200, 100, 30);
        add(lblEndDate);

        try {
            conn c = new conn();
            String query = "select * from events where eventId = '" + cEventId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblEventName.setText(rs.getString("eventName"));
                lblStartDate.setText(rs.getString("startDate"));
                lblEndDate.setText(rs.getString("endDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEventId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from events where eventId = '" + cEventId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblEventName.setText(rs.getString("eventName"));
                        lblStartDate.setText(rs.getString("startDate"));
                        lblEndDate.setText(rs.getString("endDate"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 250, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 250, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);

        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                conn c = new conn();
                String query = "delete from events where eventId = '" + cEventId.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Event Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEvent();
    }
}

