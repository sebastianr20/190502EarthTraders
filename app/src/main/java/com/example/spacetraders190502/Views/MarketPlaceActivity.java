package com.example.spacetraders190502.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Model.SaveState;
import com.example.spacetraders190502.Views.RegionActivity;

public class MarketPlaceActivity extends AppCompatActivity {
    public SaveState saveState = new SaveState();
    public Player newPlayer = saveState.getSavedPlayer();
    private Button b;
    private TextView fuel;
    CurrentCity currentCity = saveState.getSavedCity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
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
            newPlayer.getSpaceship().setFuelcapacity(100);
            newPlayer.getSpaceship().setFueldistance(50);
            update();
            saveGame();
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

    private void saveGame() {
        saveState.saveGame(newPlayer, currentCity);
    }
}
