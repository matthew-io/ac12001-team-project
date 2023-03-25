package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProfileFrame implements ActionListener {
    private JPanel Main;
    private JLabel usernameLabel;
    private JButton editProfileButton;
    private JButton aboutButton;
    private JButton friendsButton;
    private JButton activityButton;
    private JPanel activityPanel;
    private JLabel activityLabel;
    private JPanel friendsPanel;
    private JPanel aboutPanel;
    private JPanel headerPanel;
    private JLabel locationLabel;
    private JLabel jobLabel;
    private JLabel nameLabel;
    private JLabel friendsLabel;
    private JPanel buttonPanel;
    private JLabel iconLabel;
    private JLabel bioLabel;
    private JTextArea bioTextArea;
    private JScrollBar scrollBar1;
    private Profile user;
    private Network network;

    private static final String WORKPLACE_LABEL_FORMAT = "Workplace: %s";
    private static final String HOMETOWN_LABEL_FORMAT = "Hometown: %s";
    private static final String USERNAME_LABEL_FORMAT = "Username: %s";

    public ProfileFrame(Profile p) {
        this.user = p;
        friendsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        bioLabel.setText(p.getFirstName() + " " + p.getSurname() + "'s Biography");
        friendsButton.addActionListener(this);
        aboutButton.addActionListener(this);
        activityButton.addActionListener(this);
        jobLabel.setText(String.format(WORKPLACE_LABEL_FORMAT, p.getWorkplace()));
        locationLabel.setText(String.format(HOMETOWN_LABEL_FORMAT, p.getHometown()));
        nameLabel.setText(String.format(USERNAME_LABEL_FORMAT, p.getUsername()));
        usernameLabel.setText(user.getFirstName() + " " + user.getSurname());
    }
    public void displayFrame() {
        JFrame frame = new JFrame(user.getFirstName() + " " + user.getSurname() + " | The Social Network");
        frame.add(activityPanel);
        frame.setResizable(false);
        frame.setContentPane(new ProfileFrame(user).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");

        if (e.getSource() == friendsButton) {
            activityPanel.setVisible(false);
            aboutPanel.setVisible(false);
            friendsPanel.setVisible(true);
        }
        if (e.getSource() == aboutButton) {
            activityPanel.setVisible(false);
            aboutPanel.setVisible(true);
            friendsPanel.setVisible(false);
        }
        if (e.getSource() == activityButton) {
            aboutPanel.setVisible(false);
            friendsPanel.setVisible(false);
            activityPanel.setVisible(true);
        }

    }

}
