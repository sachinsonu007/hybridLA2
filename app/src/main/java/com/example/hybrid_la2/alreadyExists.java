package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class alreadyExists extends AppCompatActivity {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alreadyexists);

        backButton = findViewById(R.id.backBtn);


        backButton.setOnClickListener((view)-> {
            Intent intent = new Intent(alreadyExists.this, MainActivity.class);
            startActivity(intent);
        });
    }
}