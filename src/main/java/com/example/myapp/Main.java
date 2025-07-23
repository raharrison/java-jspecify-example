package com.example.myapp;

public class Main {

    public static void main(String[] args) {
        var repo = new UserRepo();

        User user = repo.getUserById("1");
//         System.out.println(user.username()); // possible NPE!
        if (user != null) {
            System.out.println("Found user: " + user.username());
        } else {
            System.out.println("User not found.");
        }

        // Using getUsersWithEmail to fetch all users with non-null emails
        System.out.println("Users with email:");
        for (User u : repo.getUsersWithEmail()) {
            System.out.println(u.username() + " - " + u.email());
        }

    }

}
