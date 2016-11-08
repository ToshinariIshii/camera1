package com.example.simplecropviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by b1014001 on 2016/11/08.
 */

public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView textview =(TextView) findViewById(R.id.textView1);
    }
}
