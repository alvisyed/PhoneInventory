package com.dynamicdev.phoneinventory.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="PhoneDetail.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="PhoneDetail";
    public static final String COLUMN_YEAR = "Year";
    public static final String COLUMN_MODEL = "Model";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_MANUFACTURE = "Manufacture";
    public static final String COLUMN_PHONE_ID = "Phone_id";
    public DataBase( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCommand=" CREATE TABLE "+TABLE_NAME+" ("+
                COLUMN_PHONE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_MANUFACTURE+" TEXT, "+
                COLUMN_MODEL+" TEXT ,"+
                COLUMN_YEAR+" INTEGER, "+
                COLUMN_PRICE+" INTEGER )";
        db.execSQL(createCommand);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);

    }
    public void insertPhoneDetail(PhoneDetail phoneDetail){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_MODEL,phoneDetail.getModel());
        contentValues.put(COLUMN_YEAR,phoneDetail.getYear());
        contentValues.put(COLUMN_PRICE,phoneDetail.getPrice());
        contentValues.put(COLUMN_MANUFACTURE, phoneDetail.getManufacture().name());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
    }
    public List<PhoneDetail>  getPhoneDetail(){
        List<PhoneDetail>phoneDetailList=new ArrayList<>();
        String getQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor =getReadableDatabase().rawQuery(getQuery,null);
        cursor.move(-1);
        while (cursor.moveToNext()) {
            PhoneDetail phoneDetail = new PhoneDetail(
                    //String model, int year, double price, Manufacture manufacture, String phone_id
                    cursor.getString(cursor.getColumnIndex(COLUMN_MODEL)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_YEAR)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE)),
                    PhoneDetail.Manufacture.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_MANUFACTURE))),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE_ID))

            );
            phoneDetailList.add(phoneDetail);
        }
        return phoneDetailList;
    }
}
