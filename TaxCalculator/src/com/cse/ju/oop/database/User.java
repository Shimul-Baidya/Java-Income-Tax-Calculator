package com.cse.ju.oop.database;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private double income; // Field to store user's income
    private String taxCategory; // Field to store the tax category

    // Constructor with tax category
    public User(String username, String password, String email, double income, String taxCategory) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.income = income; // Initialize income
        this.taxCategory = taxCategory; // Set tax category
    }

    // Existing constructor (without tax category)
    public User(String username, String password, String email, double income) {
        this(username, password, email, income, calculateTaxCategory(income)); // Default tax category
    }

    // Getters and Setters
    public double getIncome() {
        return income;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIncome(double income) {
        this.income = income;
        this.taxCategory = calculateTaxCategory(income); // Update tax category if income changes
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    // Method to calculate tax category based on income
    private static String calculateTaxCategory(double income) {
        if (income < 30000) {
            return "Low";
        } else if (income < 70000) {
            return "Medium";
        } else {
            return "High";
        }
    }

    // toString method to display user information
    @Override
    public String toString() {
        return username + "," + password + "," + email + "," + income + "," + taxCategory;
    }
}
