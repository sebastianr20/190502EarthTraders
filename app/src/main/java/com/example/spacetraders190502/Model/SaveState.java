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
    private  Login savedLogin;
    private Gson gson;

    public SaveState() {
        gson = new Gson();
        savedPlayer = this.initPlayer();
        savedCity = this.initCity();
        savedLogin = this.initLogin();

    }

    private Player initPlayer() {

        gson = new Gson();

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Player.json");
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedPlayer = gson.fromJson(contents, Player.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedPlayer;
    }

    private CurrentCity initCity() {
        gson = new Gson();

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "City.json");
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedCity = gson.fromJson(contents, CurrentCity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedCity;
    }

    private Login initLogin() {
        gson = new Gson();

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Login.json");
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedLogin = gson.fromJson(contents, Login.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedLogin;
    }

    public void writePlayer(Player savedPlayer) {
        String json = gson.toJson(savedPlayer);
        Log.d("Current File", json);

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Player.json");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeCity(CurrentCity savedCity) {
        String json = gson.toJson(savedCity);
        Log.d("Current File", json);

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "City.json");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveGame(Player player, CurrentCity city) {
        writePlayer(player);
        writeCity(city);
    }

    public Player getSavedPlayer() {
        return savedPlayer;
    }

    public CurrentCity getSavedCity() {
        return savedCity;
    }
}
