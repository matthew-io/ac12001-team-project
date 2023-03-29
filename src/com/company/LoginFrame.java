package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener {
    private JPanel Main;
    private JButton logInButton;
    private JButton createAccountButton;
    private JTextField textField1;
    private Network network;

    public LoginFrame(Network n) {
        this.network = n;
        logInButton.addActionListener(this);
        createAccountButton.addActionListener(this);
    }

    public void displayFrame() {
        JFrame frame = new JFrame("Log In | The Social Network");
        frame.setResizable(false);
        frame.setContentPane(new LoginFrame(network).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton) {
            Profile p = network.root;
            try {
                String userName = (textField1.getText());
                if (network.findByUserName(p, userName) == null) {
                    JOptionPane.showMessageDialog(Main, "User does not exist");
                    textField1.setText("");
                } else {
                    p = network.findByUserName(p, userName);
                    JOptionPane.showMessageDialog(Main, "Logged in successfully.");
                    Home home = new Home(network, p);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Main);
                    frame.dispose();
                    home.displayFrame();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Main, "User ID must be a number.");
                textField1.setText("");
            }
        }
        if (e.getSource() == createAccountButton) {
            CreateAccount createAccount = new CreateAccount(network);
            createAccount.displayFrame();
        }

    }
}