package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    Button registerbtn,backButton;
    EditText e1,e2,e3;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerbtn = findViewById(R.id.registerBtn);
        backButton = findViewById(R.id.backBtn);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        e3 = findViewById(R.id.crmpassword);
        db = new DBHelper(this);


        registerbtn.setOnClickListener((view) -> {
            String u1 = e1.getText().toString();
            String p2 = e2.getText().toString();
            String p3 = e3.getText().toString();

            if (u1.equals("") || p2.equals("")) {
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }
            else{
                if(p2.equals(p3)){
                    Boolean chkuserName = db.chkuserName(u1);
                    if(chkuserName == true){
                        boolean insert = db.insert(u1, p2);
                        if(insert == true)
                        {
                            Toast.makeText(getApplicationContext(), "Register successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(register.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(register.this, alreadyExists.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Password doesnot match", Toast.LENGTH_SHORT).show();
                }
            }
        });


        backButton.setOnClickListener((view)-> {
            Intent intent = new Intent(register.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
