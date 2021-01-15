package com.example.loginApi.dto;


public class UserDto {
    private Boolean isLogged;
    private String login;
    private String password;

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
        this.isLogged = false;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
