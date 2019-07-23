package com.example.spacetraders190502.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.Model.Spaceship;
import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Views.RegionActivity;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MarketPlaceActivity extends AppCompatActivity {
    public Player newPlayer = ConfigurationActivity.getNewPlayer();
    private Button b;
    private TextView fuel;
    CurrentCity currentCity = RegionActivity.getCurrCity();
    Login login = new Login("poop", "ooop");
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        gson = new Gson();


        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Login.json");
        try {
            login = new Login("poop", "ooop");
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                System.out.println("in if");
                login = gson.fromJson(contents, Login.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        newPlayer = login.getPlayer();
        currentCity = login.getCity();

        b = (Button) findViewById(R.id.button3);
        b.setText("Spend " + (100 - newPlayer.getSpaceship().getFuelcapacity()) + " credits to refuel completely.");
        TextView mkp = (TextView) findViewById(R.id.marketplace);
        mkp.setText("Welcome to " + currentCity.name + " Market Place!");
        fuel = (TextView) findViewById(R.id.fuel);
        String message = "Current Fuel Capacity: " + newPlayer.getSpaceship().getFuelcapacity() + "%";
        fuel.setText(message);
    }

    public void goToBuy(View v) {
        Intent intent = new Intent(MarketPlaceActivity.this,BuyItem.class);
        startActivity(intent);
    }

    public void goToSell(View v) {
        Intent intent = new Intent(MarketPlaceActivity.this,SellItem.class);
        startActivity(intent);
    }

    public void refuel(View view) {
        if (newPlayer.getCreditScore() >= (100 - newPlayer.getSpaceship().getFuelcapacity())) {
            newPlayer.setCreditScore(newPlayer.getCreditScore() - (100 - newPlayer.getSpaceship().getFuelcapacity()));
            Spaceship ship = newPlayer.getSpaceship();
            ship.setFuelcapacity(100);
            ship.setFueldistance(50);
            newPlayer.setCurrShip(ship);
            login.setPlayer(newPlayer);
            String json = gson.toJson(login);
            Log.d("Current File", json);

            File path = getApplicationContext().getFilesDir();
            File file = new File(path, "Login.json");

            try {
                FileOutputStream stream = new FileOutputStream(file);
                stream.write(json.getBytes());
                stream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            update();
        } else {
            Toast.makeText(MarketPlaceActivity.this, "Not enough credits to refuel.", Toast.LENGTH_SHORT).show();
        }
    }
    private void update() {
        b.setText("Spend " + (100 - newPlayer.getSpaceship().getFuelcapacity()) + " credits to refuel completely.");
        fuel.setText("Current Fuel Capacity: " + newPlayer.getSpaceship().getFuelcapacity() + "%");
    }

    public void travel(View view) {
        Intent intent = new Intent(MarketPlaceActivity.this, TravelActivity.class);
        startActivity(intent);
    }
}