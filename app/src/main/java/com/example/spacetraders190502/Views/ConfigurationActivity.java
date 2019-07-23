package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.Model.Difficulty;
import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Player;
import com.example.spacetraders190502.R;
import com.google.gson.Gson;

public class ConfigurationActivity extends AppCompatActivity {
    public static Player newPlayer;
    public Gson gson;
    public Login login = new Login("poop", "ooop");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//             Spinner Drop down elements
        List<Object> categories = new ArrayList<Object>();
        categories.add(Difficulty.BEGINNER);
        categories.add(Difficulty.EASY);
        categories.add(Difficulty.NORMAL);
        categories.add(Difficulty.HARD);
        categories.add(Difficulty.IMPOSSIBLE);
        setContentView(R.layout.activity_configuration);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.difficulty_spinner);
        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);
        // Creating adapter for spinner
        ArrayAdapter<Object> dataAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        String item = "Beginner";
    }
    public void start(View v) {
        EditText contactName = (EditText) findViewById(R.id.input_name);
        String name = contactName.getText().toString();
        if (isEmpty(contactName)) {
            Toast.makeText(ConfigurationActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();

        } else {
            EditText et = (EditText) findViewById(R.id.pilot);
            EditText et1 = (EditText) findViewById(R.id.fighter);
            EditText et2 = (EditText) findViewById(R.id.trader);
            EditText et3 = (EditText) findViewById(R.id.engineer);
            Spinner spinner = (Spinner) findViewById(R.id.difficulty_spinner);
            Difficulty diffLevel = Difficulty.valueOf(spinner.getSelectedItem().toString());
            String p = et.getText().toString();
            String f = et1.getText().toString();
            String t = et2.getText().toString();
            String e = et3.getText().toString();
            if (isEmpty(et) || isEmpty(et1) || isEmpty(et2) || isEmpty(et3)) {
                Toast.makeText(ConfigurationActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();
            } else {
                int pilot = Integer.parseInt(p);
                int fighter = Integer.parseInt(f);
                int trader = Integer.parseInt(t);
                int engineer = Integer.parseInt(e);

                if (pilot + fighter + trader + engineer != 16) {
                    Toast.makeText(ConfigurationActivity.this, "Skill Distribution Error!", Toast.LENGTH_SHORT).show();
                } else {
                    newPlayer = new Player(name, pilot, fighter, trader, engineer, diffLevel);
                    Toast.makeText(ConfigurationActivity.this, newPlayer.toString(), Toast.LENGTH_LONG).show();
                    finish();
                }

            }

        }

    }

    public void onStartPressed(View view) {
        EditText contactName = (EditText) findViewById(R.id.input_name);
        String name = contactName.getText().toString();
        if (isEmpty(contactName)) {
            Toast.makeText(ConfigurationActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();

        } else {
            EditText et = (EditText) findViewById(R.id.pilot);
            EditText et1 = (EditText) findViewById(R.id.fighter);
            EditText et2 = (EditText) findViewById(R.id.trader);
            EditText et3 = (EditText) findViewById(R.id.engineer);
            Spinner spinner = (Spinner) findViewById(R.id.difficulty_spinner);
            Difficulty diffLevel = Difficulty.valueOf(spinner.getSelectedItem().toString());
            String p = et.getText().toString();
            String f = et1.getText().toString();
            String t = et2.getText().toString();
            String e = et3.getText().toString();
            if (isEmpty(et) || isEmpty(et1) || isEmpty(et2) || isEmpty(et3)) {
                Toast.makeText(ConfigurationActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();
            } else {
                int pilot = Integer.parseInt(p);
                int fighter = Integer.parseInt(f);
                int trader = Integer.parseInt(t);
                int engineer = Integer.parseInt(e);

                if (pilot + fighter + trader + engineer != 16) {
                    Toast.makeText(ConfigurationActivity.this, "Skill Distribution Error!", Toast.LENGTH_SHORT).show();
                } else {
                    newPlayer = new Player(name, pilot, fighter, trader, engineer, diffLevel);
                    gson = new Gson();

                    File path = getApplicationContext().getFilesDir();
                    File file = new File(path, "Login.json");
                    try {
                        int length = (int) file.length();
                        byte[] bytes = new byte[length];
                        FileInputStream in = new FileInputStream(file);
                        in.read(bytes);
                        String contents = new String(bytes);
                        in.close();
                        Log.d("FileFromLastInstance", contents);
                        if (!contents.equals("")) {
                            login = gson.fromJson(contents, Login.class);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    login.setPlayer(newPlayer);
                    String json = gson.toJson(login);
                    Log.d("Current File", json);

                    path = getApplicationContext().getFilesDir();
                    file = new File(path, "Login.json");

                    try {
                        FileOutputStream stream = new FileOutputStream(file);
                        stream.write(json.getBytes());
                        stream.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Toast.makeText(ConfigurationActivity.this, newPlayer.toString(), Toast.LENGTH_LONG).show();
                    newPlayer.toString();
                }

            }

        }
        Intent intent = new Intent(this, RegionActivity.class);
        intent.putExtra("message", "-1");
        startActivity(intent);
    }
    public static Player getNewPlayer() {
        return newPlayer;
    }

    public void onClosePressed(View view) {
        finish();
    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}