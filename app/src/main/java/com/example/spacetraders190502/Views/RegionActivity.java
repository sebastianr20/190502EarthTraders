package com.example.spacetraders190502.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.Region;
import com.example.spacetraders190502.R;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegionActivity extends AppCompatActivity {
    public static CurrentCity currCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_region);


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

        Random rand = new Random();

        int n = rand.nextInt(10);

        currCity = new CurrentCity(n);

        TextView welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("Welcome to " + currCity.name + "!");

    }
    public void toMarketPlace(View view) {
        Intent intent = new Intent(this, MarketPlaceActivity.class);
        startActivity(intent);
    }
    public static CurrentCity getCurrCity() {
        return currCity;
    }
}
