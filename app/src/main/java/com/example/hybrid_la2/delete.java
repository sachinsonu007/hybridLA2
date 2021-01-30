package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete extends AppCompatActivity {

    EditText text1;
    Button backbtn, deletebtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        text1 = findViewById(R.id.text1);
        deletebtn = findViewById(R.id.deleteBtn);
        backbtn = findViewById(R.id.backBtn);
        db = new DBHelper(this);

        deletebtn.setOnClickListener((view) ->{

            String dltusn = text1.getText().toString();

            if(dltusn.equals("")){
                Toast.makeText(getApplicationContext(), "Enter usn", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean dlt = db.deleteDetails(dltusn);
                if(dlt == true){
                    Toast.makeText(getApplicationContext(), "Details deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(delete.this, Contents.class);
                    startActivity(intent);
                }
            }
        });

        backbtn.setOnClickListener((view)-> {
            Intent intent = new Intent(delete.this, Contents.class);
            startActivity(intent);
        });
    }
}
