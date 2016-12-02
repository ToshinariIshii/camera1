package com.example.simplecropviewsample;

/**
 * Created by b1014246 on 2016/11/09.
 */


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.data.BubbleEntry;

import static android.graphics.Color.rgb;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_0_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_100_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_25_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_50_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_75_150px;

public class SubActivity extends AppCompatActivity {

    private TextView label;
    ImageButton bt;
    int color_flag = 0;
    int r = 128, g = 128, b = 128;
    public static String selectedText_date;//date
public  static int [] SelectedColor ={255,255,255};

    private static final int[] milks = {
            ic_milk_vertical_0_150px,
            ic_milk_vertical_25_150px,
            ic_milk_vertical_50_150px,
            ic_milk_vertical_75_150px,
            ic_milk_vertical_100_150px
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        String selectedText="";
//        Intent intent = getIntent();
//        String selectedText ="";//date
//        int selectedPhoto = intent.getIntExtra("Photo", 0);
//        String selectedText2 = intent.getStringExtra("Memo");
//        int selectedPhoto2 = intent.getIntExtra("Milk", 0);
//        String selectedComment = intent.getStringExtra("PoopComment");
//        String selectedSmell = intent.getStringExtra("PoopSmell");
//        String selectedAmount = intent.getStringExtra("PoopAmount");
//        String selectedStatus = intent.getStringExtra("PoopStatus");
//        int selectedColorR = intent.getIntExtra("ColorR", 0);
//        int selectedColorG = intent.getIntExtra("ColorG", 0);
//        int selectedColorB = intent.getIntExtra("ColorB", 0);
        //String selectedColorCode = intent.getStringExtra("Color");
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date","milkseek","r", "g", "b","resultnumber","memo"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(c.getString(0).equals(selectedText_date)){
        SelectedColor[0]=c.getInt(2);
        SelectedColor[1]=c.getInt(3);
        SelectedColor[2]=c.getInt(4);
            break;
            }
            mov = c.moveToNext();
        }
        c.close();
        db.close();

        TextView textView = (TextView)findViewById(R.id.selected_text);
        textView.setText(selectedText);
        //ImageView  imageView = (ImageView) findViewById(R.id.selected_photo);
        //imageView.setImageResource(selectedPhoto);

        TextView textView2 = (TextView)findViewById(R.id.selected_text2);
//        textView2.setText(selectedText2);
        ImageView imageView2 = (ImageView)findViewById(R.id.selected_photo2);
//        imageView2.setImageResource(selectedPhoto2);

        TextView textView3 = (TextView)findViewById(R.id.selected_comment);
//        textView3.setText(selectedComment);

        TextView textView4 = (TextView)findViewById(R.id.selected_smell);
//        textView4.setText(selectedSmell);

        TextView textView5 = (TextView)findViewById(R.id.selected_amount);
//        textView5.setText(selectedAmount);

        TextView textView6 = (TextView)findViewById(R.id.selected_status);
//        textView6.setText(selectedStatus);

//        String hexR = String.format("%02X", selectedColorR & 0xFF);
//        String hexG = String.format("%02X", selectedColorG & 0xFF);
//        String hexB = String.format("%02X", selectedColorB & 0xFF);

        //String hexR = Integer.toHexString( 128 );
        //String hexG = Integer.toHexString( 128 );
        //String hexB = Integer.toHexString( 128 );

//        String selectedColorCode = "#" + hexR + hexG + hexB;

        bt = (ImageButton)findViewById(R.id.picture);
        bt.setBackgroundResource(R.drawable.round_button_selector);


        GradientDrawable d = new GradientDrawable();
//        d.setColor(Color.parseColor(selectedColorCode));
        d.setColor(rgb(SelectedColor[0],SelectedColor[1],SelectedColor[2]));
        d.setShape(GradientDrawable.OVAL);
        bt.setBackgroundDrawable(d);
        //bt.setBackgroundColor(Color.parseColor("#ffffff"));









        /*
        label = (TextView) this.findViewById(R.id.label);
        label.setText("abcd123456789cdefg\n" + "1234567893456978\n" +
                "hijklmnopq012698745rst4565848uvwxlmnopq\n" +
                "\n\n\n012698745rst4565848\nuvwx" );

        c = (TestView) this.findViewById(R.id.test_view);
        */

    }


}

