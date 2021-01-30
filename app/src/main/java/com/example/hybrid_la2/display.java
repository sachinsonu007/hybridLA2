package com.example.hybrid_la2;

import android.app.LauncherActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class display extends AppCompatActivity {

    ListView listView;
    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayscreen);

        db = new DBHelper(this);
        listView = findViewById(R.id.list_item);

        ArrayList<String> theList = new ArrayList<>();
        Cursor cursor = db.displayData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(), "The Database is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            if(cursor.moveToFirst()){
                do{
                    theList.add("NAME: " + cursor.getString(0) +"\n"+ "USN:" + cursor.getString(1));
                    ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                    listView.setAdapter(listAdapter);
                }while(cursor.moveToNext());
            }
        }

    }

}
