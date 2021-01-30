package com.example.hybrid_la2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key, password text)");
        db.execSQL("Create table details(name text, usn text primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS user" );
        db.execSQL("drop table if EXISTS details");

    }

    public boolean insert(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1) return false;
        else
            return true;
    }

    public boolean chkuserName(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username = ?", new String[] {username});
        if(cursor.getCount() >0) return false;
        else
            return true;
    }

    public boolean usrpsw(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount() >0) return true;
        else
            return false;
    }

    public boolean insertDetails(String name, String usn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("usn", usn);
        long ins = db.insert("details", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public boolean deleteDetails(String usn){
        SQLiteDatabase db = this.getWritableDatabase();
        long dlt = db.delete("details", "usn = ?", new String[] {usn});
        if(dlt == -1) return false;
        else
            return true;
    }

    public boolean updateDetails(String name, String usn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("usn", usn);
        long upd = db.update("details", contentValues, "usn = ?", new String[] {usn});
        if(upd == -1) return false;
        else
            return true;
    }

    public Cursor displayData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from details", null);
        return cursor;
    }


}
