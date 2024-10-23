package com.cse.ju.oop.views.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    private static final String appName = "Tax Calculator";
    private JButton registerButton;
    private JButton loginButton;

    public HomeScreen() {
        super();
        this.setTitle(appName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());  // Using GridBagLayout for flexibility
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        this.setBackground(Color.WHITE);

        // Create buttons
        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        // Set button styles (optional)
        customizeButton(registerButton);
        customizeButton(loginButton);

        // Adding buttons to the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);  // Padding around buttons

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(registerButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(loginButton, gbc);

        // Action listeners for buttons
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistrationScreen();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginScreen();
            }
        });
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }

    private void openRegistrationScreen() {
        // Logic to open the registration screen
        new RegistrationScreen(this).setVisible(true);
        this.setVisible(false);  // Hide current screen
    }

    private void openLoginScreen() {
        // Logic to open the login screen
        new LoginScreen(this).setVisible(true);
        this.setVisible(false);  // Hide current screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen screen = new HomeScreen();
            screen.setVisible(true);
        });
    }
}
