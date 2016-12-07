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
                + "imagepass text,"+"r integer,"+"g integer,"+"b integer,"+"resultnumber integer,"
                +"resultsmell text,"+"resultamount integer,"+"resultmizu integer,"
                +"outo integer,"+"seki integer,"+"hassin integer,"+"kigen integer,"+"genki integer,"+"memo text"+");");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/01 2','開始日','0','0','191','153','49','5','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/01 9','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/01 11','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/01 12','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/01 15','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/01 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/01 18','開始日','0','0','210','200','74','4','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/01 19','開始日','4','140','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/01 20','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/02 2:20.11','12/02 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 9:20.11','12/02 9','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 11:11.14','12/02 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 12:26.31','12/02 12','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 15:40.15','12/02 15','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 17:20.39','12/02 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 18:32.21','12/02 18','開始日','4','140','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 19:27.19','12/02 19','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 20:15.38','12/02 20','開始日','5','150','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/03 2:20.11','12/03 2','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 9:20.11','12/03 9','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 11:11.14','12/03 11','開始日','0','0','255','255','255','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 12:26.31','12/03 12','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 15:40.15','12/03 15','開始日','0','0','201','190','134','2','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 17:20.39','12/03 17','開始日','0','0','255','255','255','0','0','0','0','0','(調子が悪そう病気かもしれない)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 18:32.21','12/03 18','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 19:27.19','12/03 19','開始日','0','0','201','190','134','2','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 20:15.38','12/03 20','開始日','5','150','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/04 2:20.11','12/04 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 9:20.11','12/04 9','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 11:11.14','12/04 11','開始日','0','0','255','255','255','0','0','0','1','1','(今日は調子良さそう)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 12:26.31','12/04 12','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 15:40.15','12/04 15','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 17:20.39','12/04 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 18:32.21','12/04 18','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 19:27.19','12/04 19','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 20:15.38','12/04 20','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/05 2:20.11','12/05 2','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 9:20.11','12/05 9','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 11:11.14','12/05 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(メモ)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 12:26.31','12/05 12','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 15:40.15','12/05 15','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 17:20.39','12/05 17','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 18:32.21','12/05 18','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 19:27.19','12/05 19','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 20:15.38','12/05 20','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/06 2:20.11','12/06 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 9:20.11','12/06 9','開始日','3','100','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 11:11.14','12/06 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 12:26.31','12/06 12','開始日','3','110','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 15:40.15','12/06 15','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 17:20.39','12/06 17','開始日','1','40','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 18:32.21','12/06 18','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 19:27.19','12/06 19','開始日','4','140','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 20:15.38','12/06 20','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/07 2:20.11','12/07 2','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 9:20.11','12/07 9','開始日','2','80','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 11:11.14','12/07 11','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 12:26.31','12/07 12','開始日','3','110','180','140','45','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 15:40.15','12/07 15','開始日','0','0','255','255','255','0','0','0','0','1','11','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 17:20.39','12/07 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 18:32.21','12/07 18','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 19:27.19','12/07 19','開始日','3','120','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 20:15.38','12/07 20','開始日','0','0','255','255','255','0','0','0','0','0','1','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/08 2:20.11','12/08 2','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 9:20.11','12/08 9','開始日','1','50','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 11:11.14','12/08 11','開始日','0','0','185','150','46','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 12:26.31','12/08 12','開始日','1','40','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 15:40.15','12/08 15','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 17:20.39','12/08 17','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 18:32.21','12/08 18','開始日','2','60','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 19:27.19','12/08 19','開始日','0','0','215','210','75','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 20:15.38','12/08 20','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");

        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/09 2:20.11','12/09 2','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 9:20.11','12/09 9','開始日','1','20','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 11:11.14','12/09 11','開始日','0','0','201','190','134','2','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO person(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 12:26.31','12/09 12','開始日','0','0','200','200','170','1','1','1','1','1','1','たぶんやべえ');");

        db.execSQL("create table haribote("
                + "date text," + "date_hour text,"+ "date_day text,"+"milkkind text,"+ "milkseek integer,"+"milkvalue integer,"
                +"r integer,"+"g integer,"+"b integer,"+"resultnumber integer,"
                +"resultsmell text,"+"resultamount integer,"+"resultmizu integer,"
                +"outo integer,"+"seki integer,"+"hassin integer,"+"kigen integer,"+"genki integer,"+"memo text"+");");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/01 2:20.11','12/01 2','開始日','0','0','191','153','49','5','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 9:20.11','12/01 9','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 11:11.14','12/01 11','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/01 12','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 15:40.15','12/01 15','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 17:20.39','12/01 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 18:32.21','12/01 18','開始日','0','0','210','200','74','4','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 19:27.19','12/01 19','開始日','4','140','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 20:15.38','12/01 20','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/02 2:20.11','12/02 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 9:20.11','12/02 9','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 11:11.14','12/02 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 12:26.31','12/02 12','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 15:40.15','12/02 15','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 17:20.39','12/02 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 18:32.21','12/02 18','開始日','4','140','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 19:27.19','12/02 19','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/02 20:15.38','12/02 20','開始日','5','150','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/03 2:20.11','12/03 2','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 9:20.11','12/03 9','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 11:11.14','12/03 11','開始日','0','0','255','255','255','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 12:26.31','12/03 12','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 15:40.15','12/03 15','開始日','0','0','201','190','134','2','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 17:20.39','12/03 17','開始日','0','0','255','255','255','0','0','0','0','0','(調子が悪そう病気かもしれない)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 18:32.21','12/03 18','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 19:27.19','12/03 19','開始日','0','0','201','190','134','2','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/03 20:15.38','12/03 20','開始日','5','150','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/04 2:20.11','12/04 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 9:20.11','12/04 9','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 11:11.14','12/04 11','開始日','0','0','255','255','255','0','0','0','1','1','(今日は調子良さそう)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 12:26.31','12/04 12','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 15:40.15','12/04 15','開始日','3','130','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 17:20.39','12/04 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 18:32.21','12/04 18','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 19:27.19','12/04 19','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/04 20:15.38','12/04 20','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/05 2:20.11','12/05 2','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 9:20.11','12/05 9','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 11:11.14','12/05 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(メモ)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 12:26.31','12/05 12','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 15:40.15','12/05 15','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 17:20.39','12/05 17','開始日','1','60','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 18:32.21','12/05 18','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 19:27.19','12/05 19','開始日','2','75','255','255','255','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/05 20:15.38','12/05 20','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/06 2:20.11','12/06 2','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 9:20.11','12/06 9','開始日','3','100','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 11:11.14','12/06 11','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 12:26.31','12/06 12','開始日','3','110','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 15:40.15','12/06 15','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 17:20.39','12/06 17','開始日','1','40','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 18:32.21','12/06 18','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 19:27.19','12/06 19','開始日','4','140','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/06 20:15.38','12/06 20','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/07 2:20.11','12/07 2','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 9:20.11','12/07 9','開始日','2','80','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 11:11.14','12/07 11','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 12:26.31','12/07 12','開始日','3','110','180','140','45','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 15:40.15','12/07 15','開始日','0','0','255','255','255','0','0','0','0','1','11','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 17:20.39','12/07 17','開始日','0','0','191','153','49','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 18:32.21','12/07 18','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 19:27.19','12/07 19','開始日','3','120','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/07 20:15.38','12/07 20','開始日','0','0','255','255','255','0','0','0','0','0','1','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/08 2:20.11','12/08 2','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 9:20.11','12/08 9','開始日','1','50','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 11:11.14','12/08 11','開始日','0','0','185','150','46','5','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 12:26.31','12/08 12','開始日','1','40','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 15:40.15','12/08 15','開始日','0','0','210','200','74','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 17:20.39','12/08 17','開始日','0','0','255','255','255','0','0','0','0','1','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 18:32.21','12/08 18','開始日','2','60','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 19:27.19','12/08 19','開始日','0','0','215','210','75','4','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/08 20:15.38','12/08 20','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");

        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                " values ('12/09 2:20.11','12/09 2','開始日','0','0','255','255','255','0','0','0','0','1','1','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 9:20.11','12/09 9','開始日','1','20','255','255','255','0','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 11:11.14','12/09 11','開始日','0','0','201','190','134','2','0','0','0','0','0','(未入力)');");
        db.execSQL("INSERT INTO haribote(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/09 12:26.31','12/09 12','開始日','0','0','200','200','170','1','1','1','1','1','1','たぶんやべえ');");


        db.execSQL("create table hariboteday("
                + "date text," + "date_hour text,"+ "date_day text,"+"milkkind text,"+ "milkseek integer,"+"milkvalue integer,"
                +"r integer,"+"g integer,"+"b integer,"+"resultnumber integer,"
                +"resultsmell text,"+"resultamount integer,"+"resultmizu integer,"
                +"outo integer,"+"seki integer,"+"hassin integer,"+"kigen integer,"+"genki integer,"+"memo text"+");");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/1','3','0','210','200','74','4','0','0','0','1','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/2','4','0','191','153','49','5','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/3','2','0','201','190','134','2','0','0','0','1','1','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/4','2','0','191','153','49','5','0','0','0','1','1','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/5','4','0','191','153','49','5','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/6','5','0','210','200','74','4','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/7','3','0','191','153','49','5','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/8','2','0','210','200','74','4','0','0','0','0','0','(ダミー)');");
        db.execSQL("INSERT INTO hariboteday(date,date_hour,date_day,milkseek,milkvalue,r,g,b,resultnumber,outo,seki,hassin,kigen,genki,memo)" +
                "  values ('12/01 12:26.31','12/09 12','12/9','1','0','200','200','170','1','1','1','1','1','1','(ダミー)');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
