package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.Model.CurrentItem;
import com.example.spacetraders190502.R;

public class PurchaseConfirm extends AppCompatActivity {

    CurrentItem currentItem = BuyItem.getCurrentItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
    }

    public void yes(View view) {
        ConfigurationActivity.getNewPlayer().buy(BuyItem.currentItem.getItem().getOrder());
        Toast.makeText(PurchaseConfirm.this, "Bought " + ConfigurationActivity.getNewPlayer().getItemName(BuyItem.currentItem.getItem().getOrder()), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        startActivity(intent);
    }

    public void no(View view) {
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        startActivity(intent);
    }
}
