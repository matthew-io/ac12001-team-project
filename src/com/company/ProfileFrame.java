package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

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
    private JButton submitButton;
    private JLabel dateLabel;
    private JPanel postPanel;
    private JLabel postLabel;
    private JTextArea postTextArea;
    private JScrollPane friendsScroll;
    private Profile user;
    private Network network;

    private static final String WORKPLACE_LABEL_FORMAT = "Workplace: %s";
    private static final String HOMETOWN_LABEL_FORMAT = "Hometown: %s";
    private static final String USERNAME_LABEL_FORMAT = "Username: %s";

    public ProfileFrame(Network n, Profile p) {
        this.user = p;
        this.network = n;
        submitButton.addActionListener(this);
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
                    friendLabel = new JLabel();
                    friendLabel.setForeground(Color.decode("#D1603D"));
                    friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
                    friendLabel.setSize(20, 20);
                    friendLabel.setText("No friends :(");
                    friendsButton.setText("FRIENDS - 0");
                    friendsPanel.setBackground(Color.WHITE);
                    friendsPanel.add(friendLabel);
                }
            }
        }

        JTextArea mostRecentPost = new JTextArea();
        mostRecentPost.setForeground(Color.decode("#D1603D"));
        mostRecentPost.setSize(20, 20);
        mostRecentPost.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        Boolean hasPosts = false;
        BufferedReader reader;

        try {
            File file = new File("src/com/company/postInfo.txt");
            Scanner scan = new Scanner(file);
            String[] lineArr = null;

            postTextArea.setLineWrap(true);

            while (scan.hasNextLine()) {
                lineArr = scan.nextLine().split(",,,;;;,,,");
                if (Integer.parseInt(lineArr[2]) == user.getUserID()) {
                    postTextArea.setText(lineArr[0]);
                    dateLabel.setText("Posted on - " + lineArr[1]);
                    dateLabel.setSize(20, 20);
                    postTextArea.setSize(20, 20);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("src/com/company/user_bios.txt");
            Scanner scan = new Scanner(file);
            String userBio = "Enter a bio here...";
            JLabel bioLabel = new JLabel();
            while (scan.hasNextLine()) {
                String[] lineArr = scan.nextLine().split("----------");
                if (Integer.parseInt(lineArr[1]) == user.getUserID()) {
                    userBio = lineArr[0];
                }
            }
            bioTextArea.setText(userBio);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        if (p.getPosts().isEmpty()) {
//            mostRecentPost.setText("No Posts :(");
//            activityPanel.add(mostRecentPost);
//            System.out.println("NO POSTS");
//        } else {
//            BufferedReader reader;
//
//            try {
//                reader = new BufferedReader(new FileReader("src/com/company/profiles.txt"));
//                String line = reader.readLine();
//                String[] lineArr = null;
//
//                System.out.println("WILLLLLYS");
//
//                while (line != null) {
//                    lineArr = line.split(",,,;;;,,,");
//                    if (Integer.parseInt(lineArr[2]) == user.getUserID()) {
//                        System.out.println("This user made this post");
//                    }
//                }
//
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            post mostRecent = p.getPosts().getLast();
//            mostRecentPost.setText(mostRecent.getMessage());
//            activityPanel.add(mostRecentPost);
//        }

        friendsPanel.setVisible(false);
        aboutPanel.setVisible(false);
        bioLabel.setText(p.getFirstName() + "" + p.getSurname() + "'s Biography");
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


        if (e.getSource() == submitButton) {
            String bio = bioTextArea.getText();

            if (bio.length() < 5) {
                JOptionPane.showMessageDialog(Main, "Bio needs to be at least 5 characters long.");
            } else {
                try {
                    FileWriter fileWriter = new FileWriter("src/com/company/user_bios.txt", true);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    String textToAppend = (bio + "----------" + user.getUserID());
                    printWriter.println(textToAppend);
                    printWriter.close();
                }
                catch (IOException ex){
                    System.out.println("nothing happened");
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(Main, "Bio updated successfully.");
            }


        }

    }

}
