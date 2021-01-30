package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    Button login, register;
    Handler handler = new Handler();
    Runnable runnable = () -> {
        layout.setVisibility(View.VISIBLE);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = (RelativeLayout) findViewById(R.id.reLay);
        login = findViewById(R.id.loginbttn);
        register = findViewById(R.id.registerbttn);

        handler.postDelayed(runnable, 3000);


        login.setOnClickListener((view) -> {
            Intent i = new Intent(MainActivity.this, loginscreen.class);
            startActivity(i);
        });

        register.setOnClickListener((view) -> {
            Intent i = new Intent(MainActivity.this, register.class);
            startActivity(i);
        });
    }
}
