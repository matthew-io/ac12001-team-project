package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfileFrame implements ActionListener {
    private JPanel Main;
    private JLabel usernameLabel;
    private JButton aboutButton;
    private JButton friendsButton;
    private JButton activityButton;
    private JPanel activityPanel;
    private JPanel friendsPanel;
    private JPanel aboutPanel;
    private JPanel headerPanel;
    private JLabel locationLabel;
    private JLabel jobLabel;
    private JLabel nameLabel;
    private JPanel buttonPanel;
    private JLabel iconLabel;
    private JLabel bioLabel;
    private JTextArea bioTextArea;
    private JScrollBar scrollBar1;
    private JLabel editProfile;
    private JScrollPane friendsScroll;
    private Profile user;
    private Network network;

    private static final String WORKPLACE_LABEL_FORMAT = "Workplace: %s";
    private static final String HOMETOWN_LABEL_FORMAT = "Hometown: %s";
    private static final String USERNAME_LABEL_FORMAT = "Username: %s";

    public ProfileFrame(Network n, Profile p) {
        this.user = p;
        this.network = n;
        int[] friendsArr = user.getFriends();
        editProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        bioTextArea.setText(p.getBio());
        friendsButton.setText("FRIENDS - " + friendsArr.length);
//        for (int i =0;i<friendsArr.length;i++) {
//            Profile friend = network.findNode(friendsArr[i]);
//            JLabel friendLabel = new JLabel();
//            if (i != friendsArr.length -1) {
//                friendLabel.setText(friend.getFirstName() + " " + friend.getSurname() + " | ");
//            } else{
//                friendLabel.setText(friend.getFirstName() + " " + friend.getSurname());
//            }
//            friendLabel.setForeground(Color.WHITE);
//            friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
//            friendLabel.setSize(20, 20);
//            friendsPanel.add(friendLabel);
//        }
        for (int i =0;i<15;i++) {
            JLabel friendLabel = new JLabel();
            friendLabel.setText("Matthew");
            friendLabel.setForeground(Color.WHITE);
            friendLabel.setSize(20, 20);
            friendsPanel.add(friendLabel);
        }
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
        editProfile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditProfile editProfile = new EditProfile(network, p);
                editProfile.displayFrame();
            }
        });
    }


    public void displayFrame() {
        JFrame frame = new JFrame(user.getFirstName() + " " + user.getSurname() + " | The Social Network");
        frame.add(activityPanel);
        frame.setResizable(false);
        frame.setContentPane(new ProfileFrame(network, user).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == friendsButton) {
//            int[] friendsArr = user.getFriends();
//            for (int i =0;i<user.getFriends().length;i++) {
//                Profile f = network.findNode(friendsArr[i]);
//                System.out.println(f.getUsername());
//            }
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
        if (e.getSource() == editProfile) {
            System.out.println("Edit profile clicked");
        }

    }

}
