package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home implements ActionListener {
    private Network network;
    private Profile user;
    private JPanel Main;
    private JLabel userLabel;
    private JPanel friendsPanel;
    private JPanel postsPanel;
    private JTextField textField1;
    private JButton submitButton;

    public Home(Network n, Profile p) {
        this.network = n;
        this.user = p;

        System.out.println(p.getFriends().length);

        int[] friendsArr = p.getFriends();

        for (int i =0;i<friendsArr.length;i++) {
            JLabel friendLabel = new JLabel();
            Profile f = network.findNode(friendsArr[i]);
            friendLabel.setForeground(Color.WHITE);
            friendLabel.setText(f.getFirstName() + " " + f.getSurname());
            friendLabel.setSize(20, 20);
            friendLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
            friendsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            friendsPanel.add(friendLabel);
        }

        userLabel.setText(p.getFirstName() + " " + p.getSurname());
        userLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ProfileFrame profileFrame = new ProfileFrame(network, user);
                profileFrame.displayFrame();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
                frame.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

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
