package com.example.simplecropviewsample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by b1014001 on 2016/11/10.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "DateMilkHSVDB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person("
                + "date text," + "milkseek integer,"
                +"r integer,"+"g integer,"+"b integer,"
                +"resultnumber integer,"+"memo text"+");");
        db.execSQL("INSERT INTO person(date,milkseek,r,g,b,resultnumber,memo) values ('開始日','0','255','255','255','0','no data');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
