package com.example.spacetraders190502.Views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

import com.example.spacetraders190502.Model.CurrentCity;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.example.spacetraders190502.Model.Login;
import com.example.spacetraders190502.Model.Player;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spacetraders190502.R;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button button;
    private Login loginObj;
    private Login savedLogin;
    private String savedUser;
    private String savedPass;
    private CurrentCity savedCity;
    private int savedOrdinal;
    private Player savedPlayer;
    private String cred1;
    private String cred2;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.loginButton);
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
            button.setText("Login");
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedLogin = gson.fromJson(contents, Login.class);
                savedUser = savedLogin.getUsername();
                savedPass = savedLogin.getPassword();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        path = getApplicationContext().getFilesDir();
        file = new File(path, "Player.json");
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedPlayer = gson.fromJson(contents, Player.class);
                ConfigurationActivity.setNewPlayer(savedPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        path = getApplicationContext().getFilesDir();
        file = new File(path, "City.json");
        try {
            int length = (int) file.length();
            byte[] bytes = new byte[length];
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            String contents = new String(bytes);
            in.close();
            Log.d("FileFromLastInstance", contents);
            if (!contents.equals("")) {
                savedCity = gson.fromJson(contents, CurrentCity.class);
                savedOrdinal = savedCity.getOrdinal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onLogin(View view) {
        cred1 = username.getText().toString();
        cred2 = password.getText().toString();
        System.out.println(cred1 + cred2);
        if (savedUser == null && savedPass == null) {
            if (cred1 == "") {
                Toast.makeText(LoginActivity.this, "Username Field Not Complete", Toast.LENGTH_SHORT).show();
            } else if (cred2.length() < 6) {
                Toast.makeText(LoginActivity.this, "Password Too Short", Toast.LENGTH_SHORT).show();
            } else {
                loginObj = new Login(cred1, cred2);
                String json = gson.toJson(loginObj);
                Log.d("Current File", json);

                File path = getApplicationContext().getFilesDir();
                File file = new File(path, "Login.json");

                try {
                    FileOutputStream stream = new FileOutputStream(file);
                    stream.write(json.getBytes());
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(this, ConfigurationActivity.class);
                startActivity(intent);
            }
        } else {
            if (savedLogin.verify(cred1, cred2)) {
                Toast.makeText(LoginActivity.this, "Welcome Back " + cred1, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, RegionActivity.class);
                String ordinal = "" + savedOrdinal;
                intent.putExtra("message", ordinal);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Credentials Incorrect" + savedUser + cred1 + savedPass + cred2, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
