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
    private JLabel editProfile;
    private JPanel mainFrame;
    private JPanel headingPanel;
    private JPanel infoPanel;
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
        activityPanel.setBackground(Color.WHITE);
        activityPanel.setForeground(Color.decode("#D1603D"));
        headingPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);
        headerPanel.setBackground(Color.WHITE);
        infoPanel.setBackground(Color.WHITE);
        iconLabel.setBackground(Color.WHITE);
        bioTextArea.setBackground(Color.WHITE);

        for (int i =0; i<p.getFriends().length;i++) {
            if (p.getFriends().length > 0) {
                JLabel friendLabel = new JLabel();
                Profile f = network.findNode(p.getFriends()[i]);
                if (f != null) {
                    if (i == p.getFriends().length - 1) {
                        friendLabel.setText(f.getFirstName() + " " + f.getSurname());
                    } else {
                        friendLabel.setText(f.getFirstName() + " " + f.getSurname() + " | ");
                    }
                    friendLabel.setForeground(Color.decode("#D1603D"));
                    friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
                    friendLabel.setSize(20, 20);
                    friendsPanel.setBackground(Color.WHITE);
                    friendsPanel.add(friendLabel);
                } else {
                    System.out.println("NO PALS");
                    friendLabel = new JLabel();
                    friendLabel.setForeground(Color.decode("#D1603D"));
                    friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
                    friendLabel.setSize(20, 20);
                    friendLabel.setText("No friends :(");
                    friendsButton.setText("Friends - 0");
                    friendsPanel.setBackground(Color.WHITE);
                    friendsPanel.add(friendLabel);
                }
            }
        }

        JTextArea mostRecentPost = new JTextArea();
        mostRecentPost.setForeground(Color.decode("#D1603D"));
        mostRecentPost.setSize(20, 20);
        mostRecentPost.setFont(new Font("Century Gothic", Font.PLAIN, 12));

        if (p.getPosts().isEmpty()) {
            mostRecentPost.setText("No Posts :(");
            activityPanel.add(mostRecentPost);
        } else {
            post mostRecent = p.getPosts().getLast();
            mostRecentPost.setText(mostRecent.getMessage());
            activityPanel.add(mostRecentPost);
        }
        activityPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
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
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == editProfile) {
            System.out.println("Edit profile clicked");
        }

    }

}
