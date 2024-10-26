package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.database.User;

import javax.swing.*;
import java.awt.*;

public class TaxCalculatorScreen extends JFrame {
    private JLabel resultLabel, taxAmountLabel;
    private JButton logoutButton;

    public TaxCalculatorScreen(User user) {
        super("Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(400, 250);
        setLocationRelativeTo(null);

        resultLabel = new JLabel("Tax Category: " + user.getTaxCategory());
        taxAmountLabel = new JLabel("Tax Amount: $" + calculateTaxAmount(user.getIncome()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(resultLabel, gbc);

        gbc.gridy = 1;
        add(taxAmountLabel, gbc);

        logoutButton = new JButton("Logout");
        customizeButton(logoutButton);
        gbc.gridy = 2;
        add(logoutButton, gbc);

        logoutButton.addActionListener(e -> {
            new HomeScreen().setVisible(true);
            dispose();
        });
    }

    private double calculateTaxAmount(double income) {
        if (income < 30000) return income * 0.05;
        else if (income < 70000) return income * 0.15;
        else return income * 0.25;
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 30));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(255, 69, 0)); // Orange-Red
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }
}
