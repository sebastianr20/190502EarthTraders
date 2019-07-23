package com.example.spacetraders190502.Model;

public class Login {
    private String username;
    private String password;
    private CurrentCity city;
    private Player player;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean verify(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public Player getPlayer() {
        return player;
    }
    public CurrentCity getCity() {
        return city;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setCity(CurrentCity city) {
        this.city = city;
    }
}
