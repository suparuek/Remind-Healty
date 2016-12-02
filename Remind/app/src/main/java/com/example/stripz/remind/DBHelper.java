package com.example.stripz.remind;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "remind.db";
    private static final int DATABASE_VERSION = 1;
    private static final String USER_TABLE = "create table loginTABLE(_id integer primary key, " +
            " Username text, Password text, Name text, Age integer, Gender integer, Weight double, Height double);";
    private static final String FOOD_TABLE = "create table foodTABLE(_id integer primary key, " +
            " Food text, Calories text);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE);
        db.execSQL(FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
