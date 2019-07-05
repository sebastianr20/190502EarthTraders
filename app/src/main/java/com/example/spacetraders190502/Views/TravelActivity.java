package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.Model.CurrentCity;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.Model.Region;
import com.example.spacetraders190502.R;

import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity {
    public Player newPlayer = ConfigurationActivity.getNewPlayer();
    CurrentCity currentCity = RegionActivity.getCurrCity();
    public int maxTravelDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        TextView fuel = (TextView) findViewById(R.id.fuel);
        TextView location = (TextView) findViewById(R.id.location);
        fuel.setText("Current Fuel Capacity = " + newPlayer.getSpaceship().getFuelcapacity() + "%");
        location.setText("Current Location: " + currentCity.name);
        maxTravelDistance = newPlayer.getSpaceship().getFueldistance();

        List<Object> listR = new ArrayList<>();
        listR.add(Region.NEWDELHI);
        listR.add(Region.BANGKOK);
        listR.add(Region.NEWYORK);
        listR.add(Region.AMSTERDAM);
        listR.add(Region.ROME);
        listR.add(Region.ATHENS);
        listR.add(Region.JOHANNESBURG);
        listR.add(Region.BOGOTA);
        listR.add(Region.CAIRO);
        listR.add(Region.SYDNEY);

        ArrayList<Button> list = new ArrayList<>();
        Button b1 = (Button) findViewById(R.id.newdelhi);
        list.add(b1);
        Button b2 = (Button) findViewById(R.id.bangkok);
        list.add(b2);
        Button b3 = (Button) findViewById(R.id.newyork);
        list.add(b3);
        Button b4 = (Button) findViewById(R.id.amsterdam);
        list.add(b4);
        Button b5 = (Button) findViewById(R.id.rome);
        list.add(b5);
        Button b6 = (Button) findViewById(R.id.athens);
        list.add(b6);
        Button b7 = (Button) findViewById(R.id.johannesburg);
        list.add(b7);
        Button b8 = (Button) findViewById(R.id.bogota);
        list.add(b8);
        Button b9 = (Button) findViewById(R.id.cairo);
        list.add(b9);
        Button b10 = (Button) findViewById(R.id.sydney);
        list.add(b10);

        int count = 0;
        for (Button b: list) {
            Region r = (Region) listR.get(count);
            if (r.getName() == currentCity.name) {
                b.setText(r.getName() + " : You are here");
            } else if (canTravel(r)) {
                b.setText(r.getName() + " : Enough fuel");
            } else {
                b.setText(r.getName() + " : Not enough fuel");
            }
            count++;
        }
    }

    public void newdelhi(View view) {
        if (canTravel(Region.NEWDELHI)) {
            updateFuel(Region.NEWDELHI);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "0");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void bangkok(View view) {
        if (canTravel(Region.BANGKOK)) {
            updateFuel(Region.BANGKOK);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "1");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void newyork(View view) {
        if (canTravel(Region.NEWYORK)) {
            updateFuel(Region.NEWYORK);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "2");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void amsterdam(View view) {
        if (canTravel(Region.AMSTERDAM)) {
            updateFuel(Region.AMSTERDAM);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "3");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void rome(View view) {
        if (canTravel(Region.ROME)) {
            updateFuel(Region.ROME);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "4");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void athens(View view) {
        if (canTravel(Region.ATHENS)) {
            updateFuel(Region.ATHENS);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "5");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void johannesburg(View view) {
        if (canTravel(Region.JOHANNESBURG)) {
            updateFuel(Region.JOHANNESBURG);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "6");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void bogota(View view) {
        if (canTravel(Region.BOGOTA)) {
            updateFuel(Region.BOGOTA);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "7");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void cairo(View view) {
        if (canTravel(Region.CAIRO)) {
            updateFuel(Region.CAIRO);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "8");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }
    public void sydney(View view) {
        if (canTravel(Region.SYDNEY)) {
            updateFuel(Region.SYDNEY);
            Intent intent = new Intent(this, RegionActivity.class);
            intent.putExtra("message", "9");
            startActivity(intent);
        } else {
            Toast.makeText(TravelActivity.this, "Not enough fuel!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean canTravel(Region region) {
        int x = currentCity.x;
        int y = currentCity.y;
        int x2 = region.getX();
        int y2 = region.getY();
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        if (distance == 0) {
            return false;
        }
        return distance < newPlayer.getSpaceship().getFueldistance();
    }
    private void updateFuel(Region region) {
        int x = currentCity.x;
        int y = currentCity.y;
        int x2 = region.getX();
        int y2 = region.getY();
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        newPlayer.getSpaceship().setFueldistance(maxTravelDistance - (int) distance);
        newPlayer.getSpaceship().setFuelcapacity(newPlayer.getSpaceship().getFueldistance() * 2);
    }

    public void onBack(View view) {
        Intent intent = new Intent(TravelActivity.this, MarketPlaceActivity.class);
        startActivity(intent);
    }
}
