package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    private JTextField userIdField;
    private JTextField accountInfoField;
    private Profile p;
    private Network network;

    public GUI(Network n) {
        super("Social Network");
        this.network = n;
        loginFrame();
    }

    public void loginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);

        // Create welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Social Network");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // Create options message
        JLabel optionsLabel = new JLabel("Please choose an option below:");
        optionsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(optionsLabel, BorderLayout.CENTER);

        // Create buttons
        JButton loginButton = new JButton("Log in");
        loginButton.addActionListener(this);
        JButton createButton = new JButton("Create an account");
        createButton.addActionListener(this);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(loginButton);
        buttonPanel.add(createButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create user ID prompt
        JLabel userIdLabel = new JLabel("Please enter your user ID:");
        userIdLabel.setHorizontalAlignment(JLabel.CENTER);
        userIdField = new JTextField(10);
        JPanel userIdPanel = new JPanel();
        userIdPanel.add(userIdLabel);
        userIdPanel.add(userIdField);

        // Create account info prompt
        JLabel accountInfoLabel = new JLabel("Please enter your account information:");
        accountInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        accountInfoField = new JTextField(10);
        JPanel accountInfoPanel = new JPanel();
        accountInfoPanel.add(accountInfoLabel);
        accountInfoPanel.add(accountInfoField);

        // Add prompts to frame
        add(userIdPanel, BorderLayout.NORTH);
        add(accountInfoPanel, BorderLayout.CENTER);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Log in")) {
            int userId;
            try {
                userId = Integer.parseInt(userIdField.getText());
                if (network.findNode(userId) == null) {
                    JOptionPane.showMessageDialog(this, "User does not exist.");
                } else {
                    p = network.findNode(userId);
                    p.addFriend(2);
                    // Display a new page with the user's profile information
                    JFrame profileFrame = new JFrame(p.getUsername());
                    profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    profileFrame.setSize(600, 500);
                    JLabel nameLabel = new JLabel("Name: " + p.getUsername());
                    nameLabel.setHorizontalAlignment(JLabel.CENTER);
                    JLabel ageLabel = new JLabel("Age: " + p.getHometown());
                    ageLabel.setHorizontalAlignment(JLabel.CENTER);
                    JLabel interestsLabel = new JLabel("Interests: " + p.getFriends());
                    interestsLabel.setHorizontalAlignment(JLabel.CENTER);
                    JPanel panel = new JPanel(new GridLayout(3, 1));
                    panel.add(nameLabel);
                    panel.add(ageLabel);
                    panel.add(interestsLabel);
                    profileFrame.add(panel);
                    profileFrame.setVisible(true);
                    dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid user ID");
            }
        } else if (e.getActionCommand().equals("Create an account")) {
            String accountInfo = accountInfoField.getText();
            // Create account with accountInfo
        } else if (e.getActionCommand().equals("Exit")) {
            dispose();
        }
    }

}
