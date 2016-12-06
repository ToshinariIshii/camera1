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

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/01 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/01 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/01 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/01 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/01 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/01 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/01 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/01 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/01 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/02 2:20.11','12/02 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 9:20.11','12/02 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 11:11.14','12/02 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 12:26.31','12/02 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 15:40.15','12/02 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 17:20.39','12/02 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 18:32.21','12/02 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 19:27.19','12/02 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 20:15.38','12/02 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/03 2:20.11','12/02 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 9:20.11','12/02 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 11:11.14','12/02 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 12:26.31','12/02 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 15:40.15','12/02 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 17:20.39','12/02 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 18:32.21','12/02 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 19:27.19','12/02 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 20:15.38','12/02 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/04 2:20.11','12/03 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 9:20.11','12/03 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 11:11.14','12/03 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 12:26.31','12/03 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 15:40.15','12/03 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 17:20.39','12/03 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 18:32.21','12/03 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 19:27.19','12/03 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 20:15.38','12/03 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/05 2:20.11','12/04 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 9:20.11','12/04 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 11:11.14','12/04 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 12:26.31','12/04 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 15:40.15','12/04 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 17:20.39','12/04 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 18:32.21','12/04 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 19:27.19','12/04 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 20:15.38','12/04 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/06 2:20.11','12/05 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 9:20.11','12/05 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 11:11.14','12/05 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 12:26.31','12/05 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 15:40.15','12/05 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 17:20.39','12/05 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 18:32.21','12/05 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 19:27.19','12/05 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 20:15.38','12/05 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/07 2:20.11','12/06 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 9:20.11','12/06 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 11:11.14','12/06 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 12:26.31','12/06 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 15:40.15','12/06 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 17:20.39','12/06 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 18:32.21','12/06 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 19:27.19','12/06 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 20:15.38','12/06 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/08 2:20.11','12/07 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 9:20.11','12/07 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 11:11.14','12/07 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 12:26.31','12/07 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 15:40.15','12/07 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 17:20.39','12/07 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 18:32.21','12/07 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 19:27.19','12/07 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 20:15.38','12/07 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/09 2:20.11','12/08 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 9:20.11','12/08 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 11:11.14','12/08 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 12:26.31','12/08 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/09 15:40.15','12/08 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/09 17:20.39','12/08 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/09 18:32.21','12/08 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/09 19:27.19','12/08 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/09 20:15.38','12/08 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");



//        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,memo) " +
//                "values ('開始日','開始日','開始日','1','0','255','255','255','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                " values ('12/01 2:20.11','12/01 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("create table haribote("
                + "date text," + "date_hour text,"+ "date_day text,"+"milkkind text,"+ "milkseek integer,"+"milkvalue integer,"
                +"r integer,"+"g integer,"+"b integer,"+"resultnumber integer,"
                +"resultsmell text,"+"resultamount integer,"+"resultmizu integer,"
                +"outo integer,"+"seki integer,"+"hassin integer,"+"kigen integer,"+"genki integer,"+"memo text"+");");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/01 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/01 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/01 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/01 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/01 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/01 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/01 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/01 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/01 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/02 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/02 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/02 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/02 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/02 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/02 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/02 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/02 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/02 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/03 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/03 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/03 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/03 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/03 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/03 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/03 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/03 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/03 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/04 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/04 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/04 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/04 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/04 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/04 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/04 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/04 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/04 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/05 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/05 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/05 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/05 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/05 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/05 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/05 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/05 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/05 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/06 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/06 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/06 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/06 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/06 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/06 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/06 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/06 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/06 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/07 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/07 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/07 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/07 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/07 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/07 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/07 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/07 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/07 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/08 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/08 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/08 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/08 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/08 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/08 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/08 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/08 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/08 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/09 2','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/09 9','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/09 11','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/01 15:40.15','12/09 15','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/01 17:20.39','12/09 17','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/01 18:32.21','12/09 18','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/01 19:27.19','12/09 19','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");
//        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
//                "  values ('12/01 20:15.38','12/09 20','開始日','5','0','255','255','255','0','0','0','0','0','(未入力)');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
