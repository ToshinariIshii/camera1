package com.example.simplecropviewsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.isseiaoki.simplecropview.util.Utils;

public class ResultActivity extends AppCompatActivity{
    public static int pixels[];
    public static double rgb[][];// rgb[ピクセル番号][RかGかBか]
    public static double hsv[][];// hsv[ピクセル番号][HかSかVか]
    public static double[] majorHSV = {0, 0, 0};// HSVそれぞれの平均値を格納する
    public static int[] majorRGB = {0, 0, 0};
    public static int dResult;//discriminationResult 判別結果
    private static TextView ika, unkoCheckView, nioi, haisetu, mizupposa, haisetuView, mizupposaView;
    private static ImageView imgView;
    public static Bitmap bitmap;
    public static Button haisetuCancelButton, haisetuSaveButton;
    public static RadioGroup nioiGroup;


    private static int backhome = 0;//ホームに戻る
    public static int reqC;// int requestCode保存しておく
    public static int resC;// int resultCode保存しておく
    public static Intent I;// Intent data保存しておく

    private static int haisetuTri = 0;//初期化
    public static String date;
    public static int bubbleinit;


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
        haisetuCancelButton = (Button) findViewById(R.id.haisetuCancelButton);

        ika = (TextView) findViewById(R.id.ika);
        unkoCheckView = (TextView) findViewById(R.id.unkoCheckView);
        nioi = (TextView) findViewById(R.id.nioi);
        haisetu = (TextView) findViewById(R.id.haisetu);
        mizupposa = (TextView) findViewById(R.id.mizupposa);
        haisetuView = (TextView) findViewById(R.id.haisetuView);
        mizupposaView = (TextView) findViewById(R.id.mizupposaView);
        nioiGroup = (RadioGroup) findViewById(R.id.nioiGroup);

        final Uri uri = getIntent().getData();
        int maxSize = Utils.getMaxSize();
        int requestSize = Math.min(calcImageSize(), maxSize);
        bitmap = Utils.decodeSampledBitmapFromUri(this, uri, requestSize);
        imgView.setImageBitmap(bitmap);

        if (backhome == 0) {
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

        /* 全ピクセルのHSVの平均値を格納 */
            majorHSV = Functions.MajorHSV(hsv, width, height);

            majorRGB = Functions.convertHSVIntoRGB(majorHSV);

            dResult = Functions.result(majorHSV);

            String output = Functions.outputResult(dResult);

//            output += "\nmajorH: " + majorHSV[0] + "\nmajorS: " + majorHSV[1] + "\nmajorV: " + majorHSV[2];
//            output += "\nmajorR: " + majorRGB[0] + "\nmajorG: " + majorRGB[1] + "\nmajorB: " + majorRGB[2];


            TextView textView = (TextView) findViewById(R.id.resultView);
            // テキストビューのテキストを設定します
            textView.setText(output);
            backhome = 1;
        } else {
            backhome = 0;
            Intent intent = new Intent(getApplication(), MainTabActivity.class);
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
    public void ClickHaisetuCancelButton(View view) {
        switch(haisetuTri) {
            case 0:
                Toast.makeText(this, "殺す", Toast.LENGTH_SHORT).show();
                break;
            case 1:

                ika.setVisibility(View.VISIBLE);
                unkoCheckView.setVisibility(View.VISIBLE);
                nioi.setVisibility(View.VISIBLE);
                haisetu.setVisibility(View.VISIBLE);
                mizupposa.setVisibility(View.VISIBLE);
                mizupposaView.setVisibility(View.VISIBLE);

                haisetuView.setVisibility(View.INVISIBLE);

                haisetuTri--;
                break;
            default:
                break;
        }
    }

    public void ClickHaisetuSaveButton(View view) {
        switch(haisetuTri) {
            case 0:

                ika.setVisibility(View.INVISIBLE);
                unkoCheckView.setVisibility(View.INVISIBLE);
                nioi.setVisibility(View.INVISIBLE);
                haisetu.setVisibility(View.INVISIBLE);
                mizupposa.setVisibility(View.INVISIBLE);
                mizupposaView.setVisibility(View.INVISIBLE);

                haisetuView.setVisibility(View.VISIBLE);

                haisetuTri++;
                break;
            case 1:

                Toast.makeText(this, "保存した(してない)", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}