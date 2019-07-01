package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.R;

public class CannotBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_cannot_buy);
    }

    public void backToMKP(View view) {
        Intent intent = new Intent(CannotBuy.this, MarketPlaceActivity.class);
        startActivity(intent);
    }

}
