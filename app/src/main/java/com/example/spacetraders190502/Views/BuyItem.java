package com.example.spacetraders190502.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Model.GoodsList;

import java.util.ArrayList;
import android.util.Log;
import java.util.Random;

public class BuyItem extends AppCompatActivity {

    private static final String TAG = "BuyItem";

    //vars
    private static ArrayList<GoodsList> itemNames = new ArrayList<>();
    private static ArrayList<Integer> itemPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);
        Log.d(TAG, "onCreate: started.");
        updateInfo();
        initItems();
    }

    private void initItems() {
        Log.d(TAG, "initItems, preparing.");
        for (GoodsList item : GoodsList.values()) {
            if (RegionActivity.getCurrCity().techLevel.getOrder() == item.getMtlp().getOrder()) {
                Random r = new Random();
                int sign;
                if (r.nextBoolean()) {
                    sign = 1;
                } else {
                    sign = -1;
                }
                itemNames.add(item);
                item.setPrice(item.getBase() + (item.getIpl() * (RegionActivity.getCurrCity().techLevel.getOrder() - item.getMtlp().getOrder()) + (item.getVar() * sign)));
                itemPrices.add(item.getPrice());
                Button b = new Button(this);
                b.setId(item.getOrder());
                b.setText("Item: " + item.getName() + "\nPrice: " + item.getPrice());
                b.setId(item.getOrder());
                LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
                layout.addView(b);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ConfigurationActivity.getNewPlayer().buy(view.getId());
                    }
                });
            }
        }
    }


    public void updateInfo() {
        //creditScore
        TextView creditScoreTV = findViewById(R.id.creditScoreDisplay);
        creditScoreTV.setText("Your credit score is: " + ConfigurationActivity.getNewPlayer().getCreditScore());
        //cargo space
        TextView cargoSpaceTV = findViewById(R.id.cargoSpaceDisplay);
        cargoSpaceTV.setText("Remaining cargo space is: " + (20 - ConfigurationActivity.getNewPlayer().getPlayerGoods().size()));
    }
}
