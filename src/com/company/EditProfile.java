package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile implements ActionListener {
    private JPanel Main;
    private JTextField bioField;
    private JButton updateAccountButton;
    private Network network;
    private Profile p;

    public EditProfile(Network n, Profile p) {
        this.network = n;
        this.p = p;
        updateAccountButton.addActionListener(this);
    }

    public void displayFrame() {
        JFrame frame = new JFrame("Edit Profile | The Social Network");
        frame.setResizable(false);
        frame.setContentPane(new EditProfile(network, p).Main);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateAccountButton) {
            String bio = bioField.getText();
            p.setBio(bio);
            JOptionPane.showMessageDialog(Main, "Updated bio successfully.");
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
            frame.repaint();
        }
    }
}
