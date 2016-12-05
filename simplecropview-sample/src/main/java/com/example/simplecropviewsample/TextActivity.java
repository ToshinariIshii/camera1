package com.example.simplecropviewsample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.simplecropviewsample.ResultActivity.date;

/**
 * Created by b1014001 on 2016/11/08.
 */

public class TextActivity extends AppCompatActivity {
    /* 渡す値 */
    boolean outocheck, kigencheck, sekicheck, genkicheck, hassincheck;
    public static String realTime; // 桁数の関係でStringにした "yyyyMMddHHmm"
    String editMomoToString;
    int outo=0, kigen=0, seki=0, genki=0, hassin=0;

    public static TextView textViewCheck, textViewMemo, actCheckView;
    public static CheckBox cb1,cb2,cb3,cb4,cb5;
    public static EditText editMemo;

    public static int actTri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        textViewCheck = (TextView) findViewById(R.id.textViewCheck);
        textViewMemo = (TextView) findViewById(R.id.textViewMemo);
        actCheckView = (TextView) findViewById(R.id.actCheckView);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        editMemo = (EditText) findViewById(R.id.editMemo);
        outocheck = cb1.isChecked();
        kigencheck = cb2.isChecked();
        sekicheck = cb3.isChecked();
        genkicheck = cb4.isChecked();
        hassincheck = cb5.isChecked();
        actTri = 0;//初期化

        actCheckView.setVisibility(View.INVISIBLE);

    }

    public void ClickActSave(View view) {
        switch(actTri){
            case 0:
                actCheckView.setVisibility(View.VISIBLE);

                realTime = FunctionsSeek.realTime(1);
                outocheck = cb1.isChecked();
                kigencheck = cb2.isChecked();
                sekicheck = cb3.isChecked();
                genkicheck = cb4.isChecked();
                hassincheck = cb5.isChecked();
                editMomoToString = editMemo.getText().toString();

                String StrChecked = "　　　　　";
                if(outocheck) StrChecked += cb1.getText().toString() + "\n　　　　　";
                if(kigencheck) StrChecked += cb2.getText().toString() + "\n　　　　　";
                if(sekicheck) StrChecked += cb3.getText().toString() + "\n　　　　　";
                if(genkicheck) StrChecked += cb4.getText().toString() + "\n　　　　　";
                if(hassincheck) StrChecked += cb5.getText().toString() + "\n　　　　　";

                if(outocheck) outo=1;
                if(kigencheck) kigen=1;
                if(sekicheck) seki=1;
                if(genkicheck) genki=1;
                if(hassincheck) hassin=1;


//                if(editMemo.getText().toString() == null) editMomoToString = "(未入力)";
//                else editMomoToString = editMemo.getText().toString();
                editMomoToString=editMemo.getText().toString();
                if(editMomoToString.length()==0){
                    editMomoToString="(未入力)";
                }

                actCheckView.setText("　　　　　　 [内容確認]\n以下の入力内容で保存してもよろしいでしょうか？\n"
                        + "--------------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "　チェック済: \n" + StrChecked + "\n"
                        + "　メモ内容: \n　" + editMomoToString + "\n"
                        + "--------------------------------------------------------------\n");

                textViewCheck.setVisibility(View.INVISIBLE);
                textViewMemo.setVisibility(View.INVISIBLE);
                cb1.setVisibility(View.INVISIBLE);
                cb2.setVisibility(View.INVISIBLE);
                cb3.setVisibility(View.INVISIBLE);
                cb4.setVisibility(View.INVISIBLE);
                cb5.setVisibility(View.INVISIBLE);
                editMemo.setVisibility(View.INVISIBLE);
                actTri = 1;
                break;
            case 1:
                //データベースへの保存を行う
                MyOpenHelper helper = new MyOpenHelper(this);
                final SQLiteDatabase db = helper.getWritableDatabase();
                // 現在日時の取得
                Date now = new Date(System.currentTimeMillis());
                // 日時のフォーマットオブジェクト作成
                DateFormat formatter = new SimpleDateFormat("MM/dd HH:mm.ss");
//                formatter =new SimpleDateFormat("dd日 HH:mm.ss");
//                formatter =new SimpleDateFormat("HH:mm.ss");
                // フォーマット
                date = formatter.format(now);
                ContentValues insertValues = new ContentValues();
                insertValues.put("date", date);
                insertValues.put("milkseek", 0);
                insertValues.put("milkvalue", 0);
                insertValues.put("r", 255);
                insertValues.put("g", 255);
                insertValues.put("b", 255);
                insertValues.put("resultnumber", 0);
                insertValues.put("outo", outo);
                insertValues.put("seki", seki);
                insertValues.put("hassin", hassin);
                insertValues.put("kigen", kigen);
                insertValues.put("genki", genki);
                insertValues.put("memo",editMomoToString);
                long id = db.insert("person", date, insertValues);

                Toast.makeText(this, "保存した", Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(this,MainTabActivity.class);
                startActivity(homeIntent);
                break;
            default:
                break;
        }
    }

    public void ClickActCancel(View view) {
        switch(actTri){
            case 0:
                Toast.makeText(this, "入力情報を破棄した", Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(this,MainTabActivity.class);
                startActivity(homeIntent);
                break;
            case 1:
                actCheckView.setVisibility(View.INVISIBLE);
                textViewCheck.setVisibility(View.VISIBLE);
                textViewMemo.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                editMemo.setVisibility(View.VISIBLE);
                actTri = 0;
                break;

            default:
                break;
        }

    }
}
