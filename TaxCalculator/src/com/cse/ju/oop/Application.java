package com.cse.ju.oop;

import com.cse.ju.oop.views.screens.HomeScreen;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and display the home screen
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}
