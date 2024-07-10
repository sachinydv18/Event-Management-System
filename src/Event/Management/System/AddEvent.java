package  Event.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEvent extends JFrame implements ActionListener {

    JTextField tfProjectName, tfClientName, tfStartDate, tfEndDate, tfBudget, tfProjectManager, tfStatus;
    JButton add, back;

    AddEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add New Project");
        heading.setBounds(150, 30, 200, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lblProjectName = new JLabel("Project Name");
        lblProjectName.setBounds(50, 80, 100, 30);
        add(lblProjectName);

        tfProjectName = new JTextField();
        tfProjectName.setBounds(200, 80, 150, 30);
        add(tfProjectName);

        JLabel lblClientName = new JLabel("Client Name");
        lblClientName.setBounds(50, 130, 100, 30);
        add(lblClientName);

        tfClientName = new JTextField();
        tfClientName.setBounds(200, 130, 150, 30);
        add(tfClientName);

        JLabel lblStartDate = new JLabel("Start Date (YYYY-MM-DD)");
        lblStartDate.setBounds(50, 180, 150, 30);
        add(lblStartDate);

        tfStartDate = new JTextField();
        tfStartDate.setBounds(200, 180, 150, 30);
        add(tfStartDate);

        JLabel lblEndDate = new JLabel("End Date (YYYY-MM-DD)");
        lblEndDate.setBounds(50, 230, 150, 30);
        add(lblEndDate);

        tfEndDate = new JTextField();
        tfEndDate.setBounds(200, 230, 150, 30);
        add(tfEndDate);

        JLabel lblBudget = new JLabel("Budget");
        lblBudget.setBounds(50, 280, 100, 30);
        add(lblBudget);

        tfBudget = new JTextField();
        tfBudget.setBounds(200, 280, 150, 30);
        add(tfBudget);

        JLabel lblProjectManager = new JLabel("Project Manager");
        lblProjectManager.setBounds(50, 330, 150, 30);
        add(lblProjectManager);

        tfProjectManager = new JTextField();
        tfProjectManager.setBounds(200, 330, 150, 30);
        add(tfProjectManager);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(50, 380, 100, 30);
        add(lblStatus);

        tfStatus = new JTextField();
        tfStatus.setBounds(200, 380, 150, 30);
        add(tfStatus);

        add = new JButton("Add");
        add.setBounds(70, 430, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(500, 550);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String projectName = tfProjectName.getText();
            String clientName = tfClientName.getText();
            String startDate = tfStartDate.getText();
            String endDate = tfEndDate.getText();
            String budget = tfBudget.getText();
            String projectManager = tfProjectManager.getText();
            String status = tfStatus.getText();

            try {
                conn c = new conn();
                String query = "INSERT INTO events(projectName, clientName, startDate, endDate, budget, projectManager, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, projectName);
                pstmt.setString(2, clientName);
                pstmt.setDate(3, java.sql.Date.valueOf(startDate));
                pstmt.setDate(4, java.sql.Date.valueOf(endDate));
                pstmt.setDouble(5, Double.parseDouble(budget));
                pstmt.setString(6, projectManager);
                pstmt.setString(7, status);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Project Added Successfully");
                setVisible(false);
                new Home();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEvent();
    }
}
