package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount implements ActionListener {
    private Network network;
    private JPanel Main;
    private JTextField usernameText;
    private JTextField firstNameText;
    private JTextField surnameText;
    private JTextField workplaceText;
    private JTextField hometownText;
    private JButton createAccountButton;

    public CreateAccount(Network n) {
        this.createAccountButton.addActionListener(this);
        this.network = n;
    }

    public void displayFrame() {
            JFrame frame = new JFrame("Create an Account | The Social Network");
            frame.setResizable(false);
            frame.setContentPane(new CreateAccount(network).Main);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String username, firstName, surname, workplace, hometown;

        if (e.getSource() == createAccountButton) {
            username = usernameText.getText();
            firstName = firstNameText.getText();
            surname = surnameText.getText();
            workplace = workplaceText.getText();
            hometown = hometownText.getText();
            String defaultText = "";
            if (username.equals(defaultText) || firstName.equals(defaultText) || surname.equals(defaultText) || workplace.equals(defaultText) || hometown.equals(defaultText)) {
                System.out.println("MISSING VALUES");
            } else {
                Profile p = new Profile(username, firstName, surname, workplace, hometown, network.getTotalProfiles() + 1);
                network.addNode(p);
                System.out.println("NEW ACCOUNT ID IS: " + p.getUserID());
            }
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
            frame.dispose();
        }
    }
}
