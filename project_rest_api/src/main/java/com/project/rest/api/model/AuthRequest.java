package com.project.rest.api.model;

public class AuthRequest {
        private String login;
        private String password;

    public AuthRequest() {
    }

    public AuthRequest(String userName, String password) {
        this.login = userName;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String userName) {
        this.login = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
