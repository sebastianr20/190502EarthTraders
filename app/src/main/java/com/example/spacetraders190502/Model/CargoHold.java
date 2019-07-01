package com.example.spacetraders190502.Model;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.spacetraders190502.R;

import com.example.spacetraders190502.Views.ConfigurationActivity;

import java.util.ArrayList;

public class CargoHold extends AppCompatActivity {
    ArrayList<GoodsList> toDisplay = new ArrayList<>();

    public CargoHold() {
        ArrayList<GoodsList> cargoItems = ConfigurationActivity.getNewPlayer().getPlayerGoods();
        for (int i = 0; i< cargoItems.size(); i++) {
            toDisplay.add(cargoItems.get(i));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_hold);
    }
}
