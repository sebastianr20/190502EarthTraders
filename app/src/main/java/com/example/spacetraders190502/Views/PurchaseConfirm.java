package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.CurrentItem;
import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PurchaseConfirm extends AppCompatActivity {
    public Player newPlayer = ConfigurationActivity.getNewPlayer();
    CurrentCity currentCity = RegionActivity.getCurrCity();
    Login login = new Login("poop", "ooop");
    public Gson gson;

    CurrentItem currentItem = BuyItem.getCurrentItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

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
    }

    public void yes(View view) {
        newPlayer.buy(BuyItem.currentItem.getItem());
        login.setPlayer(newPlayer);
        String json = gson.toJson(login);
        Log.d("Current File", json);

        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "Login.json");

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Toast.makeText(PurchaseConfirm.this, "Bought " + currentItem.getItem().getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        startActivity(intent);
    }

    public void no(View view) {
        Intent intent = new Intent(PurchaseConfirm.this, BuyItem.class);
        startActivity(intent);
    }
}