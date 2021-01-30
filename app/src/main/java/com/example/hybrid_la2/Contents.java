package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Contents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contents);

        Button insert, delete, update, display;

        insert  = findViewById(R.id.insertBtn);
        delete  = findViewById(R.id.deleteBtn);
        update  = findViewById(R.id.updateBtn);
        display  = findViewById(R.id.displayBtn);


        insert.setOnClickListener((view)-> {
            Intent intent = new Intent(Contents.this, insert.class);
            startActivity(intent);
        });

        delete.setOnClickListener((view)-> {
            Intent intent = new Intent(Contents.this, delete.class);
            startActivity(intent);
        });

        update.setOnClickListener((view)-> {
            Intent intent = new Intent(Contents.this, update.class);
            startActivity(intent);
        });

        display.setOnClickListener((view)-> {
            Intent intent = new Intent(Contents.this, display.class);
            startActivity(intent);
        });
    }
}
