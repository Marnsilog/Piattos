package com.example.nutricount;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbConnection extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbPiattos";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tblUser";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public dbConnection(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE test (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_num TEXT)
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_USERNAME + " TEXT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}