package com.example.moviestreamingapp;

public class User {
    public String fullName;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}



