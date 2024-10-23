package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.database.User;
import com.cse.ju.oop.utils.TextFileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegistrationScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField incomeField;

    public RegistrationScreen(JFrame parent) {
        super();
        this.setTitle("Register New User");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        // Fields
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        incomeField = new JTextField(20);

        // Adding components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        addFormFields(gbc);

        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(registerButton, gbc);

        registerButton.addActionListener(e -> registerUser());

        JButton backButton = new JButton("Back");
        gbc.gridx = 0;
        this.add(backButton, gbc);

        backButton.addActionListener(e -> {
            parent.setVisible(true);
            this.setVisible(false);
        });
    }

    private void addFormFields(GridBagConstraints gbc) {
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

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        this.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(new JLabel("Income:"), gbc);

        gbc.gridx = 1;
        this.add(incomeField, gbc);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        // Assuming you have a field to get income during registration
        double income = Double.parseDouble(incomeField.getText());

        User user = new User(username, password, email, income);

        try {
            TextFileHandler.saveUser(user);
            JOptionPane.showMessageDialog(this, "User registered successfully!");
            new TaxCalculatorScreen(user).setVisible(true); // Open Tax Calculator Screen
            this.dispose(); // Close the registration screen
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save user.");
        }
    }

    private String calculateTaxCategory(double income) {
        if (income < 30000) {
            return "Low";
        } else if (income < 70000) {
            return "Medium";
        } else {
            return "High";
        }
    }
}
