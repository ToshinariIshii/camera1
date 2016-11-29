package com.example.simplecropviewsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by b1014001 on 2016/11/08.
 */

public class TextActivity extends AppCompatActivity {
    /* 渡す値 */
    public static boolean outo, kigen, seki, genki, hassin;
    public static String realTime, editMomoToString; // 桁数の関係でStringにした "yyyyMMddHHmm"

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

        actTri = 0;//初期化

        actCheckView.setVisibility(View.INVISIBLE);

    }

    public void ClickActSave(View view) {
        switch(actTri){
            case 0:
                actCheckView.setVisibility(View.VISIBLE);

                realTime = FunctionsSeek.realTime(1);
                outo = cb1.isChecked();
                kigen = cb2.isChecked();
                seki = cb3.isChecked();
                genki = cb4.isChecked();
                hassin = cb5.isChecked();
                editMomoToString = editMemo.getText().toString();

                String StrChecked = "　　　　　";
                if(outo) StrChecked += cb1.getText().toString() + "\n　　　　　";
                if(kigen) StrChecked += cb2.getText().toString() + "\n　　　　　";
                if(seki) StrChecked += cb3.getText().toString() + "\n　　　　　";
                if(genki) StrChecked += cb4.getText().toString() + "\n　　　　　";
                if(hassin) StrChecked += cb5.getText().toString() + "\n　　　　　";

                if(editMemo.getText().toString() == null) editMomoToString = "(未入力)";
                else editMomoToString = editMemo.getText().toString();

                actCheckView.setText("　　　　　　 [内容確認]\n以下の入力内容で保存してもよろしいでしょうか？\n"
                        + "--------------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "　チェック済: \n" + StrChecked + "\n"
                        + "　メモ内容: \n　　" + editMomoToString + "\n"
                        + "--------------------------------------------------------------\n");

                editMomoToString = editMemo.getText().toString();

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
                Toast.makeText(this, "保存した(してない)", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                intent2.setClassName("com.example.simplecropviewsample", "com.example.simplecropviewsample.MainTabActivity");
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    public void ClickActCancel(View view) {
        switch(actTri){
            case 0:
                Toast.makeText(this, "殺す", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                intent2.setClassName("com.example.simplecropviewsample", "com.example.simplecropviewsample.MainTabActivity");
                startActivity(intent2);

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
