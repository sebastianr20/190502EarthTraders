package com.example.spacetraders190502.Model;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.google.gson.Gson;

public class SaveState extends AppCompatActivity {
    private Player savedPlayer;
    private CurrentCity savedCity;

    public SaveState(Player player, CurrentCity city) {
        savedPlayer = player;
        savedCity = city;
    }

    public Player getSavedPlayer() {
        return savedPlayer;
    }

    public CurrentCity getSavedCity() {
        return savedCity;
    }

    public void setSavedPlayer(Player player) {
        savedPlayer = player;
    }
    public void setSavedCity(CurrentCity city) {
        savedCity = city;
    }
}
