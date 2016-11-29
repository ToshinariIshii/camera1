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
                + "date text," + "milk integer,"
                +"r integer,"+"g integer,"+"b integer,"
                +"resultnumber integer"+");");
        db.execSQL("INSERT INTO person(date,milk,r,g,b,resultnumber) values ('開始日','0','1','1','1','0');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
