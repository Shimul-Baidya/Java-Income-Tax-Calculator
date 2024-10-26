package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.database.User;
import com.cse.ju.oop.utils.TextFileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegistrationScreen extends JFrame {
    private JTextField usernameField, emailField, incomeField, phoneField, addressField;
    private JPasswordField passwordField;

    public RegistrationScreen(JFrame parent) {
        super("Register New User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(600, 500);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        incomeField = new JTextField(20);
        phoneField = new JTextField(20);
        addressField = new JTextField(20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        addFormFields(gbc);

        JButton registerButton = new JButton("Register");
        customizeButton(registerButton);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(registerButton, gbc);
        registerButton.addActionListener(e -> registerUser());

        JButton backButton = new JButton("Back");
        customizeButton(backButton);
        gbc.gridx = 0;
        add(backButton, gbc);
        backButton.addActionListener(e -> {
            parent.setVisible(true);
            setVisible(false);
        });
    }

    private void addFormFields(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Income:"), gbc);
        gbc.gridx = 1;
        add(incomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        add(addressField, gbc);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        double income = Double.parseDouble(incomeField.getText());
        String phone = phoneField.getText();
        String address = addressField.getText();

        User user = new User(username, password, email, income, calculateTaxCategory(income), phone, address);
        try {
            TextFileHandler.saveUser(user);
            JOptionPane.showMessageDialog(this, "User registered successfully!");
            new TaxCalculatorScreen(user).setVisible(true);
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save user.");
        }
    }

    private String calculateTaxCategory(double income) {
        if (income < 30000) return "Low";
        else if (income < 70000) return "Medium";
        else return "High";
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); // Steel blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }
}
