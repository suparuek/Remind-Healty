package com.example.stripz.remind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableLogin {

    private DBHelper helper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String TABLE_USER = "loginTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER = "username";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";

    private String activeUser;

    public TableLogin(Context context) {
        helper = new DBHelper(context);
        writeSQLite = helper.getWritableDatabase();
        readSQLite = helper.getReadableDatabase();
    }

    public String lastLogin() {
        Cursor objCursor = readSQLite.query(TABLE_USER,
                new String[]{COLUMN_ID, COLUMN_USER},
                null, null, null, null, null);
        if (objCursor != null) {
            activeUser = objCursor.getString(objCursor.getColumnIndex(COLUMN_USER));
        }

        return activeUser;
    }

    public String[] searchUser(String strUser) {
        try {
            String data[] = null;
            Cursor objCursor = readSQLite.query(TABLE_USER,
                    new String[]{COLUMN_ID,COLUMN_USER,COLUMN_PASS,COLUMN_NAME,COLUMN_AGE,COLUMN_GENDER,COLUMN_WEIGHT,COLUMN_HEIGHT},
                    COLUMN_USER + "=?", new String[]{String.valueOf(strUser)}, null, null, null, null);
            if (objCursor != null) {
                if (objCursor.moveToFirst()) {
                    data = new String[objCursor.getColumnCount()];
                    data[0] = objCursor.getString(0); //id
                    data[1] = objCursor.getString(1); //username
                    data[2] = objCursor.getString(2); //password
                    data[3] = objCursor.getString(3); //name
                    data[4] = objCursor.getString(4); //age
                    data[5] = objCursor.getString(5); //gender
                    data[6] = objCursor.getString(6); //weight
                    data[7] = objCursor.getString(7); //height
                }
                objCursor.close();
                return data;
            }
        } catch (Exception e) {
            return null;
        }
        return new String[0];
    }

    public long addNewValueToSQLite(String strUser, String strPass, String strName,
                                    int age, int gender, double weight, double height) {

        ContentValues objContentValue = new ContentValues();
        objContentValue.put(COLUMN_USER, strUser);
        objContentValue.put(COLUMN_PASS, strPass);
        objContentValue.put(COLUMN_NAME, strName);
        objContentValue.put(COLUMN_AGE, age);
        objContentValue.put(COLUMN_GENDER, gender);
        objContentValue.put(COLUMN_WEIGHT, weight);
        objContentValue.put(COLUMN_HEIGHT, height);

        return writeSQLite.insert(TABLE_USER, null, objContentValue);
    }
}
