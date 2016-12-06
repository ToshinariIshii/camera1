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
                + "date text," + "date_hour text,"+ "date_day text,"+"milkkind text,"+ "milkseek integer,"+"milkvalue integer,"
                +"r integer,"+"g integer,"+"b integer,"+"resultnumber integer,"
                +"resultsmell text,"+"resultamount integer,"+"resultmizu integer,"
                +"outo integer,"+"seki integer,"+"hassin integer,"+"kigen integer,"+"genki integer,"+"memo text"+");");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,memo) " +
                "values ('開始日','開始日','開始日','0','0','255','255','255','','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,memo) " +
//                "values ('開始日','開始日','開始日','0','0','255','255','255','','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,memo) " +
//                "values ('開始日','12/06 10','開始日','5','0','255','255','255','','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,memo) " +
//                "values ('開始日','12/06 10','開始日','5','0','255','255','255','','(未入力)');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
