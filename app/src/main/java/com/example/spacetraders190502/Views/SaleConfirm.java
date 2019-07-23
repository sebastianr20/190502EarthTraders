package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.CurrentItem;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.Model.SaveState;
import com.example.spacetraders190502.R;

public class SaleConfirm extends AppCompatActivity {

    public SaveState saveState = new SaveState();
    public Player newPlayer = saveState.getSavedPlayer();
    public CurrentCity city = saveState.getSavedCity();

    CurrentItem currentItem = BuyItem.getCurrentItem();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
    }

    public void yes(View view) {
        newPlayer.sell(SellItem.currentItem.getItem());
        Toast.makeText(SaleConfirm.this, "Sold " + currentItem.getItem().getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SaleConfirm.this, SellItem.class);
        saveGame();
        startActivity(intent);
    }

    public void no(View view) {
        Intent intent = new Intent(SaleConfirm.this, SellItem.class);
        startActivity(intent);
    }
    public void saveGame() {
        saveState.writePlayer(newPlayer);
        saveState.writeCity(city);
    }
}
