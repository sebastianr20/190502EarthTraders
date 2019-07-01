package com.example.spacetraders190502.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Views.RegionActivity;

public class MarketPlaceActivity extends AppCompatActivity {

    CurrentCity currentCity = RegionActivity.getCurrCity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        TextView mkp = (TextView) findViewById(R.id.marketplace);
        mkp.setText("Welcome to " + currentCity.name + " Market Place!");
    }

    public void goToBuy(View v) {
        Intent intent = new Intent(MarketPlaceActivity.this,BuyItem.class);
        startActivity(intent);
    }

    public void goToSell(View v) {
        Intent intent = new Intent(MarketPlaceActivity.this,SellItem.class);
        startActivity(intent);
    }
}
