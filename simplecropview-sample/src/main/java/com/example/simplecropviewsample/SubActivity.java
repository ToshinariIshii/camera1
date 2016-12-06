package com.example.simplecropviewsample;

/**
 * Created by b1014246 on 2016/11/09.
 */


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;
import static com.example.simplecropviewsample.R.drawable.genki;
import static com.example.simplecropviewsample.R.drawable.genki_no;
import static com.example.simplecropviewsample.R.drawable.gero;
import static com.example.simplecropviewsample.R.drawable.gero_no;
import static com.example.simplecropviewsample.R.drawable.hassin;
import static com.example.simplecropviewsample.R.drawable.hassin_no;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_0_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_100_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_25_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_50_150px;
import static com.example.simplecropviewsample.R.drawable.ic_milk_vertical_75_150px;
import static com.example.simplecropviewsample.R.drawable.kigen;
import static com.example.simplecropviewsample.R.drawable.kigen_no;
import static com.example.simplecropviewsample.R.drawable.no_status;
import static com.example.simplecropviewsample.R.drawable.seki;
import static com.example.simplecropviewsample.R.drawable.seki_no;


public class SubActivity extends AppCompatActivity {

    private TextView label;
    ImageButton bt;
    int color_flag = 0;
    int r = 128, g = 128, b = 128;
    public static String selectedText_date;//date
    int [] SelectedColor ={255,255,255};
    String memo;

    String resultSmell = "";
    int resultAmount = 0;
    public static String resultAmountText = "";
    int resultMizu = 0;
    String resultMizuText;

    int resultOuto = 0;
    int selectedStatusGero = 0;
    int resultSeki = 0;
    int selectedStatusSeki = 0;
    int resultHassin = 0;
    int selectedStatusHassin = 0;
    int resultGenki = 0;
    int selectedStatusGenki = 0;
    int resultKigen = 0;
    int selectedStatusKigen = 0;

    String resultImagePass = "";


    private static final int[] milks = {
            ic_milk_vertical_0_150px,
            ic_milk_vertical_25_150px,
            ic_milk_vertical_50_150px,
            ic_milk_vertical_75_150px,
            ic_milk_vertical_100_150px
    };

    private static String[] resultAmountTexts = {
        "ぜんぜん出ていない", "少し出た", "いつもくらい", "けっこう出た", "ものすごく出た", "うんちまみれ"
        // 例外処理
    };

    private static final int[] statuses = {
            gero,
            gero_no,
            seki,
            seki_no,
            hassin,
            hassin_no,
            genki,
            genki_no,
            kigen,
            kigen_no,
            no_status
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
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
        Cursor c = db.query("person", new String[]{"date","milkseek","milkkind","imagepass","r", "g", "b","resultnumber","resultsmell","resultamount","resultmizu","outo","seki","hassin","genki","kigen","memo"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(c.getString(0).equals(selectedText_date)){
                resultImagePass = c.getString(3);
                SelectedColor[0]=c.getInt(4);
                SelectedColor[1]=c.getInt(5);
                SelectedColor[2]=c.getInt(6);
                resultSmell=c.getString(8);
                resultAmount=c.getInt(9);
                resultMizu=c.getInt(10);
                resultOuto=c.getInt(11);
                resultSeki=c.getInt(12);
                resultHassin=c.getInt(13);
                resultGenki=c.getInt(14);
                resultKigen=c.getInt(15);
                memo=c.getString(16);
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
        textView2.setText(memo);//testのために着けてます
        ImageView imageView2 = (ImageView)findViewById(R.id.selected_photo2);
//        imageView2.setImageResource(selectedPhoto2);

        TextView textView3 = (TextView)findViewById(R.id.selected_comment);
//        textView3.setText(selectedComment);

        TextView textView4 = (TextView)findViewById(R.id.selected_smell);
        textView4.setText(resultSmell);

        TextView textView5 = (TextView)findViewById(R.id.selected_amount);
        if( resultAmount != 0 ) {
            resultAmountText = resultAmountTexts[resultAmount - 1];
        }
        else {
            resultAmountText = "";
        }
        textView5.setText(resultAmountText);

        TextView textView6 = (TextView)findViewById(R.id.selected_status);
        if( resultMizu != 0) {
            resultMizuText = Functions.valueOfMizupposa(resultMizu - 1);
            resultMizuText = resultMizuText.substring(3);
        }
        else {
            resultMizuText = "";
        }

        textView6.setText(resultMizuText);

        ImageView statusImageGero = (ImageView)findViewById(R.id.selected_gero);
        if( resultOuto == 1 ) {
            selectedStatusGero = statuses[0];
        }
        else if(resultOuto == 0){
            selectedStatusGero = statuses[1];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            selectedStatusGero = statuses[10];
        }
        statusImageGero.setImageResource(selectedStatusGero);


        ImageView statusImageSeki = (ImageView)findViewById(R.id.selected_seki);
        if( resultSeki == 1 ) {
            selectedStatusSeki = statuses[2];
        }
        else if(resultSeki == 0){
            selectedStatusSeki = statuses[3];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            selectedStatusSeki = statuses[10];
        }
        statusImageSeki.setImageResource(selectedStatusSeki);


        ImageView statusImageHassin = (ImageView)findViewById(R.id.selected_hassin);
        if( resultHassin == 1 ) {
            selectedStatusHassin = statuses[4];
        }
        else if(resultHassin == 0){
            selectedStatusHassin = statuses[5];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            selectedStatusHassin = statuses[10];
        }
        statusImageHassin.setImageResource(selectedStatusHassin);


        ImageView statusImageGenki = (ImageView)findViewById(R.id.selected_genki);
        if( resultGenki == 1 ) {
            selectedStatusGenki = statuses[6];
        }
        else if(resultGenki== 0){
            selectedStatusGenki = statuses[7];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            selectedStatusGenki = statuses[10];
        }
        statusImageGenki.setImageResource(selectedStatusGenki);


        ImageView statusImageKigen = (ImageView)findViewById(R.id.selected_kigen);
        if( resultKigen == 1 ) {
            selectedStatusKigen = statuses[8];
        }
        else if(resultKigen == 0){
            selectedStatusKigen = statuses[9];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            selectedStatusKigen = statuses[10];
        }
        statusImageKigen.setImageResource(selectedStatusKigen);

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

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("pass", resultImagePass);
                intent.setClassName("com.example.simplecropviewsample","com.example.simplecropviewsample.PoopImageView");
                Toast.makeText(SubActivity.this, "ボタンが押されました。", Toast.LENGTH_SHORT).show();
                //遷移先の画面を起動
                startActivity(intent);
            }
        });
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

