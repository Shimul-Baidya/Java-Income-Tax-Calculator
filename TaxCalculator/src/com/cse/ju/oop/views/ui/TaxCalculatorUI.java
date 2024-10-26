package com.cse.ju.oop.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxCalculatorUI {
    private JFrame frame;
    private JTextField incomeField;
    private JTextArea resultArea;

    public TaxCalculatorUI() {
        frame = new JFrame("Income Tax Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null); // Center the frame

        // Set a color scheme
        Color backgroundColor = new Color(255, 255, 255);
        Color buttonColor = new Color(0, 120, 215);
        frame.getContentPane().setBackground(backgroundColor);

        // Title label
        JLabel titleLabel = new JLabel("Income Tax Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(buttonColor);
        addComponent(titleLabel, 0, 0, 2, 1, GridBagConstraints.CENTER);

        // Income input field
        JLabel incomeLabel = new JLabel("Enter your income:");
        incomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        addComponent(incomeLabel, 0, 1, 1, 1, GridBagConstraints.WEST);

        incomeField = new JTextField(15);
        addComponent(incomeField, 1, 1, 1, 1, GridBagConstraints.WEST);

        // Calculate button
        JButton calculateButton = new JButton("Calculate Tax");
        calculateButton.setBackground(buttonColor);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorderPainted(false);
        addComponent(calculateButton, 0, 2, 2, 1, GridBagConstraints.CENTER);

        // Result area
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        addComponent(scrollPane, 0, 3, 2, 1, GridBagConstraints.CENTER);

        // Button action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTax();
            }
        });

        frame.setVisible(true);
    }

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        frame.add(component, gbc);
    }

    private void calculateTax() {
        try {
            double income = Double.parseDouble(incomeField.getText());
            double tax = 0; // Replace this with your tax calculation logic
            // Example tax logic
            if (income < 30000) {
                tax = income * 0.1; // 10% tax for low income
            } else if (income < 70000) {
                tax = income * 0.2; // 20% tax for medium income
            } else {
                tax = income * 0.3; // 30% tax for high income
            }
            resultArea.setText("Calculated Tax: $" + tax);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid income.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaxCalculatorUI::new);
    }
}
