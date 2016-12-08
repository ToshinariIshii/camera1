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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;
import static com.example.simplecropviewsample.R.drawable.genki;
import static com.example.simplecropviewsample.R.drawable.genki_no;
import static com.example.simplecropviewsample.R.drawable.gero;
import static com.example.simplecropviewsample.R.drawable.gero_no;
import static com.example.simplecropviewsample.R.drawable.hassin;
import static com.example.simplecropviewsample.R.drawable.hassin_no;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_0;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_100;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_25;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_50;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_75;
import static com.example.simplecropviewsample.R.drawable.ic_bonyu_no;
import static com.example.simplecropviewsample.R.drawable.ic_milk_0;
import static com.example.simplecropviewsample.R.drawable.ic_milk_100;
import static com.example.simplecropviewsample.R.drawable.ic_milk_25;
import static com.example.simplecropviewsample.R.drawable.ic_milk_50;
import static com.example.simplecropviewsample.R.drawable.ic_milk_75;
import static com.example.simplecropviewsample.R.drawable.ic_milk_no;
import static com.example.simplecropviewsample.R.drawable.kigen;
import static com.example.simplecropviewsample.R.drawable.kigen_no;
import static com.example.simplecropviewsample.R.drawable.no_status;
import static com.example.simplecropviewsample.R.drawable.seki;
import static com.example.simplecropviewsample.R.drawable.seki_no;


public class SubActivity extends AppCompatActivity {

    String resultDate = "";

    private TextView label;
    ImageButton bt;
    int color_flag = 0;
    int r = 128, g = 128, b = 128;
    public static String selectedText_date;//date
    int [] SelectedColor ={255,255,255};
    String memo;
    int resultMilcSeek = 100;

    String resultSmell = "";
    int resultAmount = 0;
    public static String resultAmountText = "";
    int resultMizu = 0;
    String resultMizuText;

    int resultGero = 0;
    int selectedStatusGero = 0;
    int resultSeki = 0;
    int selectedStatusSeki = 0;
    int resultHassin = 0;
    int selectedStatusHassin = 0;
    int resultGenki = 0;
    int selectedStatusGenki = 0;
    int resultKigen = 0;
    int selectedStatusKigen = 0;
    int resultStatus = 0;

    String resultImagePass = "";
    int resultBonyu = 0;
    int resultMilks = 0;
    int resultNumber = 0;
    String resultMilkKind = "";
    int resultMilkKindPoint = 0;
    int resultMilkValue = 0;


    private static final int[] bonyus = {
            ic_bonyu_0,
            ic_bonyu_25,
            ic_bonyu_50,
            ic_bonyu_75,
            ic_bonyu_100,
            ic_bonyu_no
    };

    private static final int[] milks = {
            ic_milk_0,
            ic_milk_25,
            ic_milk_50,
            ic_milk_75,
            ic_milk_100,
            ic_milk_no
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
            kigen,
            kigen_no,
            genki,
            genki_no,
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
        Cursor c = db.query("person", new String[]{"date","milkseek","milkkind","milkvalue","imagepass","r", "g", "b",
                        "resultnumber","resultsmell","resultamount","resultmizu","outo","seki","hassin","genki","kigen","memo"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(c.getString(0).equals(selectedText_date)){
                resultDate=c.getString(0);
                resultMilcSeek=c.getInt(1);
                resultMilkKind=c.getString(2);
                resultMilkValue=c.getInt(3);
                resultImagePass = c.getString(4);
                SelectedColor[0]=c.getInt(5);
                SelectedColor[1]=c.getInt(6);
                SelectedColor[2]=c.getInt(7);
                resultNumber=c.getInt(8);
                resultSmell=c.getString(9);
                resultAmount=c.getInt(10);
                resultMizu=c.getInt(11);
                resultGero=c.getInt(12);
                resultSeki=c.getInt(13);
                resultHassin=c.getInt(14);
                resultGenki=c.getInt(15);
                resultKigen=c.getInt(16);
                memo=c.getString(17);
                break;
            }
            mov = c.moveToNext();
        }
        c.close();
        db.close();

        if( (resultGero != 0) || (resultSeki != 0) || (resultHassin != 0) || (resultKigen != 0) || (resultGenki != 0) ) {
            resultStatus = 1;
        }

        if( resultMilkKind != null ) {
            if(resultMilkKind.equals("母乳")) {
                resultMilkKindPoint = 1;
            }
            else if(resultMilkKind == "粉ミルク") {
                resultMilkKindPoint = 2;
            }
            else if(resultMilkKind == "両方") {
                resultMilkKindPoint = 3;
            }
        }

        TextView showDate = (TextView)findViewById(R.id.show_date);
        showDate.setText(resultDate);
        //ImageView  imageView = (ImageView) findViewById(R.id.selected_photo);
        //imageView.setImageResource(selectedPhoto);

        TextView textView2 = (TextView)findViewById(R.id.selected_text2);
        textView2.setText(memo);//testのために着けてます

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);
        layout.setWeightSum(1);

        ImageView showBonyu = (ImageView)findViewById(R.id.selected_photo2);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind == null) ) {
            resultBonyu = statuses[10];
            showBonyu.getLayoutParams().height = 0;
        }
        else if(resultMilkKind.equals("母乳") || (resultMilkKind.equals("両方"))) {
            resultBonyu = bonyus[resultMilcSeek];
        }
        else {
            resultBonyu = bonyus[5];
        }
        showBonyu.setImageResource(resultBonyu);


        ImageView showMilk = (ImageView)findViewById(R.id.selected_milk);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind == null) ) {
            resultMilks = statuses[10];
            showMilk.getLayoutParams().height = 0;
        }
        else if(resultMilkKind.equals("粉ミルク") || (resultMilkKind.equals("両方"))) {
            resultMilks = milks[resultMilcSeek];
        }
        else {
            resultMilks = milks[5];
        }
        showMilk.setImageResource(resultMilks);

        TextView showMilkAmount = (TextView)findViewById(R.id.show_milk_amount);
        if( resultMilkValue != 0 ) {
            showMilkAmount.setText("おおよその授乳量 : ");
        }
        else {
            showMilkAmount.setText("");
            showMilkAmount.setTextSize(0);
            showMilkAmount.setHeight(0);
        }

        TextView milkAmountText = (TextView)findViewById(R.id.selected_milk_amount);
        milkAmountText.setText(Integer.toString(resultMilkValue) + " ml");
        if(resultMilkValue == 0) {
            milkAmountText.setHeight(0);
        }



        TextView showComment = (TextView)findViewById(R.id.selected_comment);
        if(  (resultStatus != 1) && (resultMilkKind == null)) {
            showComment.setText(Functions.outputResult(resultNumber) );
        }
        else {
            showComment.setText("");
            showComment.setTextSize(0);
            showComment.setHeight(0);
        }


        TextView showSmell = (TextView)findViewById(R.id.show_smell);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            showSmell.setText("臭い : ");
        }
        else {
            showSmell.setText("");
            showSmell.setTextSize(0);
            showSmell.setHeight(0);
        }

        TextView smellText = (TextView)findViewById(R.id.selected_smell);
        smellText.setText(resultSmell);
        if(resultSmell == null) {
            smellText.setHeight(0);
        }

        TextView showAmount = (TextView)findViewById(R.id.show_amount);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            showAmount.setText("量 : ");
        }
        else {
            showAmount.setText("");
            showAmount.setTextSize(0);
            showAmount.setHeight(0);
        }

        TextView amountText = (TextView)findViewById(R.id.selected_amount);
        if( resultAmount != 0 ) {
            resultAmountText = resultAmountTexts[resultAmount];
        }
        else {
            resultAmountText = "";
            amountText.setHeight(0);
        }
        amountText.setText(resultAmountText);

        TextView showMizu = (TextView)findViewById(R.id.show_mizu);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) ) {
            showMizu.setText("状態 : ");
        }
        else {
            showMizu.setText("");
            showMizu.setTextSize(0);
            showMizu.setHeight(0);
        }

        TextView mizuText = (TextView)findViewById(R.id.selected_status);
        if( resultMizu != 0) {
            resultMizuText = Functions.valueOfMizupposa(resultMizu);
            resultMizuText = resultMizuText.substring(3);
        }
        else {
            resultMizuText = "";
            mizuText.setHeight(0);
        }

        mizuText.setText(resultMizuText);

/*
        TextView showTextGero = (TextView)findViewById(R.id.show_gero);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            showTextGero.setText("");
            showTextGero.setHeight(0);
        }
        else {
            showTextGero.setText("嘔吐");
        }

        ImageView statusImageGero = (ImageView)findViewById(R.id.selected_gero);
        if( resultOuto == 1 ) {
            selectedStatusGero = statuses[0];
        }
        else if(resultOuto == 0){
            selectedStatusGero = statuses[1];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            selectedStatusGero = statuses[10];
            statusImageGero.getLayoutParams().height = 0;
        }
        statusImageGero.setImageResource(selectedStatusGero);
*/


        /*　------------------------------
            嘔吐の有無を表示する
            ------------------------------*/
        TextView showTextGero = (TextView)findViewById(R.id.show_gero);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null)) {
            showTextGero.setText("");
            showTextGero.setHeight(0);
        }
        else {
            showTextGero.setText("嘔吐");
        }

        ImageView statusImageGero = (ImageView)findViewById(R.id.selected_gero);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null) ) {
            selectedStatusGero = statuses[10];
            statusImageGero.getLayoutParams().height = 0;
        }
        else if (resultGero == 1) {
            selectedStatusGero = statuses[0];
        }
        else if (resultGero == 0) {
            selectedStatusGero = statuses[1];
        }
        statusImageGero.setImageResource(selectedStatusGero);

/*
        TextView showTextSeki = (TextView)findViewById(R.id.show_seki);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            showTextSeki.setText("");
            showTextSeki.setHeight(0);
        }
        else {
            showTextSeki.setText("咳");
        }

        ImageView statusImageSeki = (ImageView)findViewById(R.id.selected_seki);
        if( resultSeki == 1 ) {
            selectedStatusSeki = statuses[2];
        }
        else if(resultSeki == 0){
            selectedStatusSeki = statuses[3];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            selectedStatusSeki = statuses[10];
            statusImageSeki.getLayoutParams().height = 0;
        }
        statusImageSeki.setImageResource(selectedStatusSeki);
*/


        /*　------------------------------
            咳の有無を表示する
            ------------------------------*/
        TextView showTextSeki = (TextView)findViewById(R.id.show_seki);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null)) {
            showTextSeki.setText("");
            showTextSeki.setHeight(0);
        }
        else {
            showTextSeki.setText("咳");
        }

        ImageView statusImageSeki = (ImageView)findViewById(R.id.selected_seki);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null) ) {
            selectedStatusSeki = statuses[10];
            statusImageSeki.getLayoutParams().height = 0;
        }
        else if (resultSeki == 1) {
            selectedStatusSeki = statuses[2];
        }
        else if (resultSeki == 0) {
            selectedStatusSeki = statuses[3];
        }
        statusImageSeki.setImageResource(selectedStatusSeki);

/*
        TextView showTextHassin = (TextView)findViewById(R.id.show_hassin);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            showTextHassin.setText("");
            showTextHassin.setHeight(0);
        }
        else {
            showTextHassin.setText("発疹");
        }

        ImageView statusImageHassin = (ImageView)findViewById(R.id.selected_hassin);
        selectedStatusHassin = statuses[10];
        if( resultHassin == 1 ) {
            selectedStatusHassin = statuses[4];
        }
        else if(resultHassin == 0){
            selectedStatusHassin = statuses[5];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            selectedStatusHassin = statuses[10];
            statusImageHassin.getLayoutParams().height = 0;
        }
        statusImageHassin.setImageResource(selectedStatusHassin);
*/


        /*　------------------------------
            発疹の有無を表示する
            ------------------------------*/
        TextView showTextHassin = (TextView)findViewById(R.id.show_hassin);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null)) {
            showTextHassin.setText("");
            showTextHassin.setHeight(0);
        }
        else {
            showTextHassin.setText("発疹");
        }

        ImageView statusImageHassin = (ImageView)findViewById(R.id.selected_hassin);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null) ) {
            selectedStatusHassin = statuses[10];
            statusImageHassin.getLayoutParams().height = 0;
        }
        else if (resultHassin == 1) {
            selectedStatusHassin = statuses[4];
        }
        else if (resultHassin == 0) {
            selectedStatusHassin = statuses[5];
        }
        statusImageHassin.setImageResource(selectedStatusHassin);

/*
        TextView showTextKigen = (TextView)findViewById(R.id.show_kigen);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            showTextKigen.setText("");
            showTextKigen.setHeight(0);
        }
        else {
            showTextKigen.setText("不機嫌");
        }

        ImageView statusImageKigen = (ImageView)findViewById(R.id.selected_kigen);
        if( resultKigen == 1 ) {
            selectedStatusKigen = statuses[6];
        }
        else if(resultKigen== 0){
            selectedStatusKigen = statuses[7];
        }

        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilcSeek != 0) ) {
            selectedStatusKigen = statuses[10];
            statusImageKigen.getLayoutParams().height = 0;
        }
        statusImageKigen.setImageResource(selectedStatusKigen);
*/


        /*　------------------------------
            不機嫌かどうかを表示する
            ------------------------------*/
        TextView showTextKigen = (TextView)findViewById(R.id.show_kigen);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null)) {
            showTextKigen.setText("");
            showTextKigen.setHeight(0);
        }
        else {
            showTextKigen.setText("不機嫌");
        }

        ImageView statusImageKigen = (ImageView)findViewById(R.id.selected_kigen);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null) ) {
            selectedStatusKigen = statuses[10];
            statusImageKigen.getLayoutParams().height = 0;
        }
        else if (resultKigen == 1) {
            selectedStatusKigen = statuses[6];
        }
        else if (resultKigen == 0) {
            selectedStatusKigen = statuses[7];
        }
        statusImageKigen.setImageResource(selectedStatusKigen);


        /*　------------------------------
            元気の有無を表示する
            ------------------------------*/
        TextView showTextGenki = (TextView)findViewById(R.id.show_genki);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null)) {
            showTextGenki.setText("");
            showTextGenki.setHeight(0);
        }
        else {
            showTextGenki.setText("元気なし");
        }

        ImageView statusImageGenki = (ImageView)findViewById(R.id.selected_genki);
        if( (SelectedColor[0] != 255) || (SelectedColor[1] != 255) || (SelectedColor[2] != 255) || (resultMilkKind != null) ) {
            selectedStatusGenki = statuses[10];
            statusImageGenki.getLayoutParams().height = 0;
        }
        else if (resultGenki == 1) {
            selectedStatusGenki = statuses[8];
        }
        else if (resultGenki == 0) {
            selectedStatusGenki = statuses[9];
        }
        statusImageGenki.setImageResource(selectedStatusGenki);

//        TextView test = (TextView)findViewById(R.id.test);
//        test.setText("aaa,"+resultMilkKind+","+resultMilcSeek+","+Integer.toString(resultMilkKindPoint));

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

