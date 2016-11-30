package com.example.simplecropviewsample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by b1014001 on 2016/11/29.
 */

public class testtext extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        MyOpenHelper helper = new MyOpenHelper(this);
        String test="";
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk", "r", "g", "b", "resultnumber","memo"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            test=c.getString((6));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(test);
    }
    }

