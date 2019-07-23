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

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.CurrentItem;
import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.example.spacetraders190502.Model.GoodsList;
import com.google.gson.Gson;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyItem extends AppCompatActivity {

    private static final String TAG = "BuyItem";
    public Player newPlayer = ConfigurationActivity.getNewPlayer();
    CurrentCity currentCity = RegionActivity.getCurrCity();
    Login login = new Login("poop", "ooop");

    //vars
    private static GoodsList[] list = GoodsList.values();
    private List<Object> itemList = new ArrayList<Object>();
    public TextView creditScoreTV;
    public TextView cargoSpaceTV;
    public TextView display;
    public static CurrentItem currentItem;
    public TextView selectedInfo;
    public Spinner spinner;
    public Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);

        gson = new Gson();


        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Login.json");
        try {
            login = new Login("poop", "ooop");
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                System.out.println("in if");
                login = gson.fromJson(contents, Login.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        newPlayer = login.getPlayer();
        currentCity = login.getCity();

        creditScoreTV = findViewById(R.id.creditScoreDisplay);
        selectedInfo = findViewById(R.id.selectedInfo);
        cargoSpaceTV = findViewById(R.id.cargoSpaceDisplay);
        display = findViewById(R.id.list);
        Log.d(TAG, "onCreate: started.");
        updateInfo();


        for (GoodsList item: list) {
            if (item.getMtlp().getOrder() <= currentCity.techLevel.getOrder()) {
                this.setPriceItem(item);
                itemList.add(item);
            }
        }

        if (itemList.size() == 0) {
            Intent intent = new Intent(BuyItem.this, CannotBuy.class);
            startActivity(intent);
        }
        String dispMessage = "Available Items:";
        for (Object item: itemList) {
            dispMessage += "\n" + ((GoodsList) item).getName() + "     Price: " + ((GoodsList) item).getPrice();
        }
        display.setText(dispMessage);

        spinner = (Spinner) findViewById(R.id.item_spinner);
        ArrayAdapter<Object> dataAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item, itemList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        GoodsList chosen = GoodsList.valueOf(spinner.getSelectedItem().toString().toUpperCase());
        currentItem = new CurrentItem(chosen);
        currentItem.setItem(chosen);
        selectedInfo.setText("Selected Item: " + currentItem.getItem().getName() + "\nPrice: " + currentItem.getItem().getPrice());
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        String item = "Select an Item";
    }

    public void onBuy(View view) {
        if (newPlayer.canBuy(currentItem.getItem())) {
            Intent intent = new Intent(BuyItem.this, PurchaseConfirm.class);
            startActivity(intent);
        } else {
            Toast.makeText(BuyItem.this, "Cannot buy " + currentItem.getItem().getName(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setPriceItem(GoodsList item) {
        int sign = this.getSign();
        item.setPrice(item.getBase() + (item.getIpl() * (currentCity.techLevel.getOrder() - item.getMtlp().getOrder()) + (item.getVar() * sign)));
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

    public void back(View view) {
        Intent intent = new Intent(BuyItem.this, MarketPlaceActivity.class);
        startActivity(intent);
    }

    public void onSelect(View view) {
        GoodsList chosen = GoodsList.valueOf(spinner.getSelectedItem().toString().toUpperCase());
        currentItem = new CurrentItem(chosen);
        currentItem.setItem(chosen);
        selectedInfo.setText("Selected Item: " + currentItem.getItem().getName() + "\nPrice: " + currentItem.getItem().getPrice());
    }
}