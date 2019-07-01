package com.example.spacetraders190502.Model;

public enum Difficulty {
    BEGINNER("Beginnner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    private final String returnDifficulty;
    Difficulty (String returnDifficulty){
        this.returnDifficulty = returnDifficulty;
    }

    public String getReturnDifficulty() {
        return returnDifficulty;
    }
}
