package com.devmohamedibrahim1997.ibnakeel.model;

public class User {

    private String UserId;
    private String Password;

    public User(String userId, String password) {
        UserId = userId;
        Password = password;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
