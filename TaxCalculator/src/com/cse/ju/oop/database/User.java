package com.cse.ju.oop.database;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private double income;
    private String taxCategory;
    private String phone;
    private String address;

    // Constructor with all fields
    public User(String username, String password, String email, double income, String taxCategory, String phone, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.income = income;
        this.taxCategory = taxCategory;
        this.phone = phone;
        this.address = address;
    }

    // Existing constructor (without phone and address)
    public User(String username, String password, String email, double income) {
        this(username, password, email, income, calculateTaxCategory(income), "", "");
    }

    // New getters for required fields
    public String getUsername() { return username; }
    public String getPassword() { return password; } // Added getPassword method
    public String getTaxCategory() { return taxCategory; }
    public double getIncome() { return income; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // toString method to include phone and address
    @Override
    public String toString() {
        return username + "," + password + "," + email + "," + income + "," + taxCategory + "," + phone + "," + address;
    }

    private static String calculateTaxCategory(double income) {
        if (income < 30000) return "Low";
        else if (income < 70000) return "Medium";
        else return "High";
    }
}
