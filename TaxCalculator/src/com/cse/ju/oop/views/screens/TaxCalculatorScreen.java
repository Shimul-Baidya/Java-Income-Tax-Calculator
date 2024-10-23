package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.database.User;

import javax.swing.*;
import java.awt.*;

public class TaxCalculatorScreen extends JFrame {
    private JLabel resultLabel;
    private JLabel taxAmountLabel;

    public TaxCalculatorScreen(User user) {
        super();
        this.setTitle("Tax Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        resultLabel = new JLabel();
        taxAmountLabel = new JLabel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Display user income and tax amount
        String taxCategory = calculateTaxCategory(user.getIncome());
        double taxAmount = calculateTaxAmount(user.getIncome());

        resultLabel.setText("Tax Category: " + taxCategory);
        taxAmountLabel.setText("Tax Amount: $" + taxAmount);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(resultLabel, gbc);

        gbc.gridy = 1;
        this.add(taxAmountLabel, gbc);
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

    private double calculateTaxAmount(double income) {
        if (income < 30000) {
            return income * 0.05; // 5% tax for low income
        } else if (income < 70000) {
            return income * 0.15; // 15% tax for medium income
        } else {
            return income * 0.25; // 25% tax for high income
        }
    }
}
