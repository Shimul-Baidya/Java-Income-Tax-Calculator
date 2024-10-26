package com.cse.ju.oop.utils;

import com.cse.ju.oop.database.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileHandler {
    private static final String FILE_PATH = "users.txt";

    public static void saveUser(User user) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.toString());
            writer.newLine();
        }
    }

    public static List<User> loadUsers() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                User user = new User(userData[0], userData[1], userData[2], Double.parseDouble(userData[3]),
                        userData[4], userData.length > 5 ? userData[5] : "", userData.length > 6 ? userData[6] : "");
                users.add(user);
            }
        }
        return users;
    }

    public static User findUserByUsername(String username) throws IOException {
        for (User user : loadUsers()) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }
}
