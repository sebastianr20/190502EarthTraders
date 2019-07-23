package com.example.spacetraders190502.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Region;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.google.gson.Gson;

import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegionActivity extends AppCompatActivity {
    public static CurrentCity currCity;
    public static Player newPlayer;
    public Gson gson;
    public Login login = new Login("poop", "ooop");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_region);
        Intent intent = getIntent();
        int n1 = Integer.parseInt(intent.getStringExtra("message"));
        if (n1 < 0) {
            Log.i("Universe created", "We created a universe");
            List<Object> list = new ArrayList<>();
            list.add(Region.NEWDELHI);
            list.add(Region.BANGKOK);
            list.add(Region.NEWYORK);
            list.add(Region.AMSTERDAM);
            list.add(Region.ROME);
            list.add(Region.ATHENS);
            list.add(Region.JOHANNESBURG);
            list.add(Region.BOGOTA);
            list.add(Region.CAIRO);
            list.add(Region.SYDNEY);
            currCity = new CurrentCity(0);
            newPlayer = ConfigurationActivity.getNewPlayer();

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
                    login = gson.fromJson(contents, Login.class);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            login.setPlayer(newPlayer);
            String json = gson.toJson(login);
            Log.d("Current File", json);

            path = getApplicationContext().getFilesDir();
            file = new File(path, "Login.json");

            try {
                FileOutputStream stream = new FileOutputStream(file);
                stream.write(json.getBytes());
                stream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            TextView welcome = (TextView) findViewById(R.id.welcome);
            welcome.setText("Welcome to " + currCity.name + "!");
        } else {

            currCity = new CurrentCity(n1);

            TextView welcome = (TextView) findViewById(R.id.welcome);
            welcome.setText("Welcome to " + currCity.name + "!");
        }
        newPlayer = ConfigurationActivity.getNewPlayer();

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
                login = gson.fromJson(contents, Login.class);
                newPlayer = login.getPlayer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        login.setCity(currCity);
        String json = gson.toJson(login);
        Log.d("Current File", json);

        path = getApplicationContext().getFilesDir();
        file = new File(path, "Login.json");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void toMarketPlace(View view) {
        Intent intent = new Intent(this, MarketPlaceActivity.class);
        startActivity(intent);
    }
    public static CurrentCity getCurrCity() {
        return currCity;
    }

    public void onSave(View view) {
        String json = gson.toJson(login);
        Log.d("Current File", json);

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Login.json");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}