package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Home implements ActionListener {
    private Network network;
    private Profile user;
    private JPanel Main;
    private JLabel userLabel;
    private JPanel friendsPanel;
    private JPanel postsPanel;
    private JTextField postTextField;
    private JButton submitButton;
    private JPanel contentPanel;
    private JLabel postField;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel headingLabel;
    private JTextArea friendsPostField;
    private JLabel addFriendLabel;
    private JLabel refreshLabel;
    private JButton refreshButton;
    private LinkedList<post> friendsPosts;
    private int count = 0;

    public Home(Network n, Profile p) {
        this.network = n;
        this.user = p;
        submitButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        friendsPosts = new LinkedList<post>();

        try {
            File file = new File("src/com/company/postInfo.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String[] stringArr = scan.nextLine().split(",,,;;;,,,");
                for (int i =0;i<user.getFriends().length;i++) {
                    int[] friendsArr = user.getFriends();
                    if (friendsArr[i] == Integer.parseInt(stringArr[2])) {
                        Profile f = network.findNode(friendsArr[i]);
                        post post = new post(stringArr[0], "30/03/23", "New Post", f.getUsername());
                        friendsPosts.add(post);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (friendsPosts.size() > 0) {
            friendsPostField.setText(friendsPosts.get(count).getMessage());
            headingLabel.setText(friendsPosts.get(count).getUserName() + " - Posted on " + friendsPosts.get(count).getdate());
        }

        try {
            File file = new File("src/com/company/friends.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String[] stringArr = scan.nextLine().split("------");
                if (Integer.parseInt(stringArr[0]) == user.getUserID()) {
                    JLabel friendLabel = new JLabel();
                    Profile f = network.findByUserName(network.root, stringArr[1]);
                    network.addFriends(user.getUserID(), f.getUserID());
                    friendLabel.setText(stringArr[1]);
                    friendsPanel.add(friendLabel);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        userLabel.setText(p.getFirstName() + " " + p.getSurname());
        userLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ProfileFrame profileFrame = new ProfileFrame(network, user);
                profileFrame.displayFrame();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        File file = new File("src/com/company/friends.txt");

        addFriendLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                addFriend friendFrame = new addFriend(network, user);
                friendFrame.displayFrame();
            }
        });

        refreshLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("REFRESH PRESSED");
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
                frame.dispose();
                displayFrame();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String postText = postTextField.getText();
            user.createPost(postText);
            network.writePostToFile(postText, "30/03/2023", user.getUserID());
            postTextField.setText("");
            JOptionPane.showMessageDialog(Main, "Post created.");
        }

        if (e.getSource() == nextButton) {
            if (count +1 == friendsPosts.size() || friendsPosts.size() == 0) {
                count = count;
            } else {
                count++;
                headingLabel.setText(friendsPosts.get(count).getUserName() + " - Posted on " + friendsPosts.get(count).getdate());
                friendsPostField.setText(friendsPosts.get(count).getMessage());
            }
        } else if (e.getSource() == previousButton) {
            if (count == 0) {
                count = count;
            } else {
                count--;
                headingLabel.setText(friendsPosts.get(count).getUserName() + " - Posted on " + friendsPosts.get(count).getdate());
                friendsPostField.setText(friendsPosts.get(count).getMessage());
            }
        }
    }


    public void displayFrame() {
        JFrame frame = new JFrame("Home | The Social Network");
        frame.setResizable(false);
        frame.setContentPane(new Home(network, user).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
