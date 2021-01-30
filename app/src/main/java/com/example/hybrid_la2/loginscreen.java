package com.example.hybrid_la2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginscreen extends AppCompatActivity {

    Button loginbtn,backButton;
    EditText e1,e2;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginbtn = findViewById(R.id.loginBtn);
        backButton = findViewById(R.id.backBtn);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        db = new DBHelper(this);

        loginbtn.setOnClickListener((view) ->{
            String username = e1.getText().toString();
            String password = e2.getText().toString();

            if(username.equals("") || password.equals("")){
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            }

            else {
                Boolean chkuserpsw = db.usrpsw(username, password);
                if(chkuserpsw == true){
                    Toast.makeText(getApplicationContext(), "successfully login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginscreen.this, Contents.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext()," Username and password doesnot match", Toast.LENGTH_SHORT).show();
                }
            }
        });


        backButton.setOnClickListener((view)-> {
            Intent intent = new Intent(loginscreen.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
