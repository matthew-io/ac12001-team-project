package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class addFriend extends Component implements ActionListener {
    private JPanel Main;
    private JButton addFriendButton;
    private JTextField friendField;
    private JLabel usernameLabel;
    private Network network;
    private Profile user;
    private JFrame frame;

    public addFriend(Network n, Profile p) {
        addFriendButton.addActionListener(this);
        network = n;
        user = p;
    }

    public void displayFrame() {
        frame = new JFrame("addFriend");
        frame.setContentPane(new addFriend(network, user).Main);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFriendButton) {
            String friendText = friendField.getText();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
            try {
                FileWriter fw = new FileWriter("src/com/company/friends.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                String textToAppend = user.getUserID() + "------" + friendText;
                pw.println(textToAppend);
                pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Profile p = network.findByUserName(network.root, friendText);
            if (p != null) {
                network.addFriends(user.getUserID(), p.getUserID());
                JOptionPane.showMessageDialog(Main, "Friend added successfully.");
            } else {
                JOptionPane.showMessageDialog(Main, "User not found.");
            }
        }
    }
}
