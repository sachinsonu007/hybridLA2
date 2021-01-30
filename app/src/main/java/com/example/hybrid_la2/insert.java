package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class insert  extends AppCompatActivity {


    EditText name,usn;
    Button insert, backButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        name = findViewById(R.id.name);
        usn = findViewById(R.id.usn);

        db = new DBHelper(this);
        insert = findViewById(R.id.insertBtn);
        backButton = findViewById(R.id.backBtn);


        insert.setOnClickListener((view) ->{
            String n1 = name.getText().toString();
            String u1 = usn.getText().toString();

            if(n1.equals("") || u1.equals("")){
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean insert = db.insertDetails(n1,u1);
                if(insert == true){
                    Toast.makeText(getApplicationContext(), "Details inserted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(insert.this, Contents.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener((view)-> {
            Intent intent = new Intent(insert.this, Contents.class);
            startActivity(intent);
        });



    }
}
