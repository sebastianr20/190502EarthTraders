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

public class PurchaseConfirm extends AppCompatActivity {
    public SaveState saveState = new SaveState();
    public Player newPlayer = saveState.getSavedPlayer();
    public CurrentCity city = saveState.getSavedCity();
    CurrentItem currentItem = BuyItem.getCurrentItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
    }

    public void yes(View view) {
        newPlayer.buy(BuyItem.currentItem.getItem());
        Toast.makeText(PurchaseConfirm.this, "Bought " + currentItem.getItem().getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        saveGame();
        startActivity(intent);
    }

    public void no(View view) {
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        startActivity(intent);
    }

    public void saveGame() {
        saveState.writePlayer(newPlayer);
        saveState.writeCity(city);
    }
}
