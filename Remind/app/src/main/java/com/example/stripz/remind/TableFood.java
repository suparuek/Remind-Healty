package com.example.stripz.remind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableFood {

    private DBHelper helper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String TABLE_FOOD = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_CALORIES = "Calories";

    public TableFood(Context context) {
        helper = new DBHelper(context);
        writeSQLite = helper.getWritableDatabase();
        readSQLite = helper.getReadableDatabase();
    }

    public String[] listCal(){
        String strListCal[] = null;
        Cursor objCursor = readSQLite.query(TABLE_FOOD,
                new String[]{COLUMN_ID_FOOD,COLUMN_CALORIES},
                null, null, null, null, null);
        objCursor.moveToFirst();
        strListCal = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListCal[i] = "Calories : " + objCursor.getString(objCursor.getColumnIndex(COLUMN_CALORIES));
            objCursor.moveToNext();
        }
        objCursor.close();
        return strListCal;
    }

    public String[] listFood() {
        String strListFood[] = null;
        Cursor objCursor = readSQLite.query(TABLE_FOOD,
                new String[]{COLUMN_ID_FOOD, COLUMN_FOOD},
                null, null, null, null, null);
        objCursor.moveToFirst();
        strListFood = new String[objCursor.getCount()];
        for (int i = 0; i < objCursor.getCount(); i++) {
            strListFood[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOOD));
            objCursor.moveToNext();
        }
        objCursor.close();
        return strListFood;
    }

    public long addNewValueToSQLite(String name, String cal) {
        ContentValues objContentValue = new ContentValues();
        objContentValue.put(COLUMN_FOOD, name);
        objContentValue.put(COLUMN_CALORIES, cal);
        return writeSQLite.insert(TABLE_FOOD, null, objContentValue);
    }
}
