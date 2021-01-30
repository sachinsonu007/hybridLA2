package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class update extends AppCompatActivity {

    EditText Usn,newName;
    Button updateBtn,backBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatescreen);

        Usn = findViewById(R.id.usn);
        newName = findViewById(R.id.newname);
        db = new DBHelper(this);
        updateBtn = findViewById(R.id.updateBtn);
        backBtn = findViewById(R.id.backBtn);

        updateBtn.setOnClickListener((view) ->{
            String s1 = newName.getText().toString();
            String s2 = Usn.getText().toString();

            if(s1.equals("") || s2.equals(" ")){
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean updt = db.updateDetails(s1, s2);
                if(updt == true){
                    Toast.makeText(getApplicationContext(), "Details updated successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(update.this, Contents.class);
                    startActivity(intent);
                }
            }
        });

        backBtn.setOnClickListener((view)-> {
            Intent intent = new Intent(update.this, Contents.class);
            startActivity(intent);
        });





    }
}

