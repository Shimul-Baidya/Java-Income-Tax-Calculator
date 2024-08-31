package com.cse.ju.oop.views.screens;

import com.cse.ju.oop.views.ui.Button;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    private static final String appName = "Tax Calculator";
    private Button saveButton = null;

    public HomeScreen() {
        super();
        this.setTitle(appName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);

        saveButton = new Button();
        this.getContentPane().add(saveButton);
    }
}
