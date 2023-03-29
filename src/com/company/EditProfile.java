package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile implements ActionListener {
    private JPanel Main;
    private JTextField usernameField;
    private JTextField firstNameField;
    private JTextField surnameField;
    private JTextField workplaceField;
    private JTextField hometownField;
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
            String username, firstName, surname, workplace, hometown;
            username = usernameField.getText();
            firstName = firstNameField.getText();
            surname = surnameField.getText();
            workplace = workplaceField.getText();
            hometown = hometownField.getText();

            p.setUsername(username);
            p.setFirstName(firstName);
            p.setSurname(surname);
            p.setWorkplace(workplace);
            p.setHometown(hometown);

            Main.repaint();
        }
    }
}
