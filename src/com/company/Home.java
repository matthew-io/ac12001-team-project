package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

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
    private JTextField postField;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel headingLabel;
    private LinkedList<post> friendsPosts;

    public Home(Network n, Profile p) {
        this.network = n;
        this.user = p;
        submitButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        int[] friendsArr = p.getFriends();
        friendsPosts = new LinkedList();

//        for (int i =0;i<friendsArr.length;i++) {
//            Profile f = network.findNode(friendsArr[i]);
//            LinkedList<post> posts = f.getPosts();
//            Iterator it = posts.iterator();
//            while (it.hasNext()) {
//                postField.setForeground(Color.WHITE);
//                postField.setHorizontalAlignment(JLabel.LEFT);
//                post userPost = (post) it.next();
//                postField.setText(userPost.getMessage());
//                headingLabel.setText(userPost.getUserName() + " - " + userPost.getdate());
//            }
//        }
//
//        for (int i =0;i<friendsArr.length;i++) {
//            JLabel friendLabel = new JLabel();
//            Profile f = network.findNode(friendsArr[i]);
//            friendLabel.setForeground(Color.WHITE);
//            friendLabel.setText(f.getFirstName() + " " + f.getSurname());
//            friendLabel.setSize(20, 20);
//            friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
//            friendsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//            friendsPanel.add(friendLabel);
//        }


        userLabel.setText(p.getFirstName() + " " + p.getSurname());
        userLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ProfileFrame profileFrame = new ProfileFrame(network, user);
                profileFrame.displayFrame();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String postText = postTextField.getText();
            user.createPost(postText);
            postTextField.setText("");
            JOptionPane.showMessageDialog(Main, "Post created.");
        }

        if (e.getSource() == nextButton) {
//            for (int i =0;i<friendsArr.length;i++) {
//                Profile f = network.findNode(friendsArr[i]);
//                LinkedList<post> posts = f.getPosts();
//                Iterator it = posts.iterator();
//                while (it.hasNext()) {
//                    postField.setForeground(Color.WHITE);
//                    postField.setHorizontalAlignment(JLabel.LEFT);
//                    post userPost = (post) it.next();
//                    postField.setText(userPost.getMessage());
//                    headingLabel.setText(userPost.getUserName() + " - " + userPost.getdate());
//                }
//            }

            postField.setText("ashdfaishdf");
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
