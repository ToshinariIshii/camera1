package com.example.simplecropviewsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.isseiaoki.simplecropview.util.Utils;

import java.io.InputStream;
/*
import android.content.res.Resources;
import android.os.Build;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.app.Activity;
import static android.R.attr.id;
*/


public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    public static int pixels[];
    public static double rgb[][];// rgb[ピクセル番号][RかGかBか]
    public static double hsv[][];// hsv[ピクセル番号][HかSかVか]
    public static double[] majorHSV = { 0, 0, 0 };// HSVそれぞれの平均値を格納する
    public static int[] majorRGB = {0, 0, 0};
    public static int dResult;//discriminationResult 判別結果
    private static final int REQUEST_GALLERY = 0;
    private ImageView imgView;
    public static Bitmap bitmap;
    public static Button button1;
    private static int backhome=0;//ホームに戻る
    public static int reqC;// int requestCode保存しておく
    public static int resC;// int resultCode保存しておく
    public static Intent I;// Intent data保存しておく


    public static Intent createIntent(Activity activity, Uri uri) {//画像の受取
        Intent intent = new Intent(activity, ResultActivity.class);
        intent.setData(uri);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        imgView = (ImageView) findViewById(R.id.imageView);
        button1 = (Button)findViewById(R.id.button1);
        final Uri uri = getIntent().getData();
        int maxSize = Utils.getMaxSize();
        int requestSize = Math.min(calcImageSize(), maxSize);
        bitmap = Utils.decodeSampledBitmapFromUri(this, uri, requestSize);
        imgView.setImageBitmap(bitmap);
        // ギャラリー呼び出し
        /*Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_GALLERY);
        */
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        reqC = requestCode;
//        resC = resultCode;
//        I = data;

//        /* ギャラリーから画像ファイル選択 */
//        if(requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
//            try {
//                InputStream in = getContentResolver().openInputStream(data.getData());
//                bitmap = BitmapFactory.decodeStream(in);
//                in.close();
//                // 選択した画像を表示
//                imgView.setImageBitmap(bitmap);
//            } catch (Exception e) {
//
//            }
//        }
@Override
   public void onClick(View view) {
    if(backhome==0) {
        /* ビットマップ取得 */
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        pixels = new int[width * height];
        rgb = new double[width * height][3];// ピクセルのRGB値格納する配列
        hsv = new double[width * height][3];// ピクセルのHSV値格納する配列
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        /* rgb[][]にRGB値を格納 */
        for (int i = 0; i < width * height; i++) {
            rgb[i][0] = Color.red(pixels[i]);
            rgb[i][1] = Color.green(pixels[i]);
            rgb[i][2] = Color.blue(pixels[i]);
        }

        /* RGBをHSVに変換 */
        hsv = Functions.convertRGBIntoHSV(rgb, width, height);

        double[] anal = {325,95,210};

        /* 全ピクセルのHSVの平均値を格納 */
        majorHSV = Functions.MajorHSV(hsv, width, height);
        //majorHSV = anal;

        majorRGB = Functions.convertHSVIntoRGB(majorHSV);

        dResult = Functions.result(majorHSV);

        String output = Functions.outputResult(dResult);
        output += "\nmajorH: " + majorHSV[0] + "\nmajorS: " + majorHSV[1] + "\nmajorV: " + majorHSV[2];
        output += "\nmajorR: " + majorRGB[0] + "\nmajorG: " + majorRGB[1] + "\nmajorB: " + majorRGB[2];

        TextView textView = (TextView) findViewById(R.id.textview1);
        // テキストビューのテキストを設定します
        textView.setText(output);
        button1.setText("もどる");
        backhome = 1;
    }else{
        backhome = 0;
        Intent intent = new Intent(getApplication(),MainTabActivity.class);
        startActivity(intent);
    }
    }

    public int calcImageSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        return Math.min(Math.max(metrics.widthPixels, metrics.heightPixels), 2048);
    }
    /* クリックした時の処理 */
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(this, "ギャラリーへリクエストした", Toast.LENGTH_SHORT).show();
//
//        /* ギャラリー呼び出し */
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, REQUEST_GALLERY);
//
//        /* ギャラリーから画像ファイル選択 */
//        if(reqC == REQUEST_GALLERY && resC == RESULT_OK) {
//            try {
//                InputStream in = getContentResolver().openInputStream(I.getData());
//                bitmap = BitmapFactory.decodeStream(in);
//                in.close();
//                // 選択した画像を表示
//                imgView.setImageBitmap(bitmap);
//            } catch (Exception e) {
//                //うんち
//            }
//        }
//    }
}