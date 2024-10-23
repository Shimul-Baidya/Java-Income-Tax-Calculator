package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.database.User;
import com.cse.ju.oop.utils.TextFileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen(JFrame parent) {
        super();
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        this.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        this.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(loginButton, gbc);

        loginButton.addActionListener(e -> loginUser());

        JButton backButton = new JButton("Back");
        gbc.gridx = 0;
        this.add(backButton, gbc);

        backButton.addActionListener(e -> {
            parent.setVisible(true);
            this.setVisible(false);
        });
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            User user = TextFileHandler.findUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new TaxCalculatorScreen(user).setVisible(true); // Open Tax Calculator Screen
                this.dispose(); // Close the login screen
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user data.");
        }
    }
}
