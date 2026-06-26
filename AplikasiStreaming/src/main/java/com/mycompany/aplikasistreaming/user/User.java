/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplikasistreaming.user;

import com.mycompany.aplikasistreaming.user.InterfaceUser;
import java.util.ArrayList;

/**
 *
 * @author Faiz
 */
import java.util.ArrayList;

public class User implements InterfaceUser {
    private String username;
    private String password;
    private String email;

    // Constructor
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean login(String identifier, String password) {
        return (identifier.equals(this.email) || identifier.equals(this.username)) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", username=" + username + "]";
    }
}


