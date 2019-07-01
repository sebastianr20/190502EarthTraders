package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.spacetraders190502.Model.CurrentItem;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Model.GoodsList;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyItem extends AppCompatActivity {

    private static final String TAG = "BuyItem";
    public Player newPlayer = ConfigurationActivity.getNewPlayer();

    //vars
    private static GoodsList[] list = GoodsList.values();
    private List<Object> itemList = new ArrayList<Object>();
    public TextView creditScoreTV;
    public TextView cargoSpaceTV;
    public static CurrentItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);

        creditScoreTV = findViewById(R.id.creditScoreDisplay);
        cargoSpaceTV = findViewById(R.id.cargoSpaceDisplay);
        Log.d(TAG, "onCreate: started.");
        updateInfo();


        for (GoodsList item: list) {
            if (item.getMtlp().getOrder() >= RegionActivity.getCurrCity().techLevel.getOrder()) {
                this.setPriceItem(item);
                itemList.add(item);
            }
        }

        Spinner spinner = (Spinner) findViewById(R.id.item_spinner);
        ArrayAdapter<Object> dataAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item, itemList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        GoodsList chosen = GoodsList.valueOf(spinner.getSelectedItem().toString().toUpperCase());
        currentItem = new CurrentItem(chosen.getOrder());
        currentItem.setItem(chosen);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        String item = "Select an Item";
    }

    public void onBuy(View view) {
        if (newPlayer.canBuy(currentItem.getItem().getOrder())) {
            Intent intent = new Intent(BuyItem.this, PurchaseConfirm.class);
            startActivity(intent);
        } else {
            Toast.makeText(BuyItem.this, "Cannot buy " + ConfigurationActivity.getNewPlayer().getItemName(currentItem.getItem().getOrder()), Toast.LENGTH_SHORT).show();
        }
    }

    private void setPriceItem(GoodsList item) {
        int sign = this.getSign();
        item.setPrice(item.getBase() + (item.getIpl() * (RegionActivity.getCurrCity().techLevel.getOrder() - item.getMtlp().getOrder()) + (item.getVar() * sign)));
    }

    private int getSign() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return 1;
        } else {
            return -1;
        }
    }

    public void updateInfo() {
        creditScoreTV.setText("Your credit score is: " + newPlayer.getCreditScore());
        cargoSpaceTV.setText("Remaining cargo space is: " + (20 - newPlayer.getPlayerGoods().size()));
    }

    public static CurrentItem getCurrentItem() {
        return currentItem;
    }
}