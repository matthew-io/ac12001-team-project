package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JLabel postField;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel headingLabel;
    private JTextArea friendsPostField;
    private LinkedList<post> friendsPosts;
    private int count = 0;

    public Home(Network n, Profile p) {
        this.network = n;
        this.user = p;
        submitButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        int[] friendsArr = p.getFriends();
        friendsPosts = new LinkedList();


//        for (int i =0;i<friendsArr.length;i++) {
//            if (friendsArr.length > 0) {
//                Profile f = network.findNode(friendsArr[i]);
//                if (f.getPosts() != null) {
//                    LinkedList<post> posts = f.getPosts();
//                    Iterator it = posts.iterator();
//                    while (it.hasNext()) {
//                        friendsPostField.setForeground(Color.BLACK);
//                        post userPost = (post) it.next();
//                        friendsPosts.add(userPost);
//                    }
//        }
//
//        friendsPostField.setText(friendsPosts.get(0).getMessage());
//        headingLabel.setText(friendsPosts.get(0).getUserName() + " - Posted on " + friendsPosts.get(0).getdate());
//        friendsPostField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
//        friendsPostField.setForeground(Color.decode("#D1603D"));
//
//        for (int i =0;i<friendsPosts.size();i++) {
//            Iterator it = friendsPosts.iterator();
//            while (it.hasNext()) {
//                post userPost = (post) it.next();
//                System.out.println(userPost.getMessage());
//            }
//        }
//
//
//        for (int i =0;i<friendsArr.length;i++) {
//            JLabel friendLabel = new JLabel();
//            Profile f = network.findNode(friendsArr[i]);
//            friendLabel.setForeground(Color.getColor("D1603D"));
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
            if (count +1 == friendsPosts.size()) {
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
