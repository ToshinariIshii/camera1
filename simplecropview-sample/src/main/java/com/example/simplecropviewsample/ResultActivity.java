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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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
    private static TextView unkoCheckView, nioi, haisetu, mizupposa, resultView, haisetuView, mizupposaView;
    private static ImageView imgView;

    public static RadioGroup nioiGroup;
    static RadioButton musyuu;
    private  static SeekBar haisetuSeek, mizupposaSeek;

    public static int haisetuValue = 0; // シークバーで選択した0~4の整数
    public static int mizupposaValue = 0; // 「約 ○○ ml」で入力した整数

    String haisetuS = "(未入力)";
    String mizupposaS = "(未入力)";

    public static String StrCheckedButton = "(未入力)";

    public static Bitmap bitmap;
//    private static int backhome = 0;//ホームに戻る
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

        unkoCheckView = (TextView) findViewById(R.id.unkoCheckView);
        nioi = (TextView) findViewById(R.id.nioi);
        haisetu = (TextView) findViewById(R.id.haisetu);
        mizupposa = (TextView) findViewById(R.id.mizupposa);
        haisetuView = (TextView) findViewById(R.id.haisetuView);
        mizupposaView = (TextView) findViewById(R.id.mizupposaView);
        resultView = (TextView) findViewById(R.id.resultView);

        nioiGroup = (RadioGroup) findViewById(R.id.nioiGroup);
        // 指定した ID のラジオボタンをチェックします
        nioiGroup.check(R.id.RadioButton1);
        musyuu = (RadioButton) findViewById(R.id.musyuu);
        musyuu.setChecked(true);

        haisetuSeek = (SeekBar)findViewById(R.id.haisetuSeek);
        mizupposaSeek = (SeekBar)findViewById(R.id.mizupposaSeek);

        unkoCheckView.setVisibility(View.INVISIBLE);

        final Uri uri = getIntent().getData();
        int maxSize = Utils.getMaxSize();
        int requestSize = Math.min(calcImageSize(), maxSize);
        bitmap = Utils.decodeSampledBitmapFromUri(this, uri, requestSize);
        imgView.setImageBitmap(bitmap);

//        if (backhome == 0) {
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
/*            backhome = 1;
        } else {
            backhome = 0;
            Intent intent = new Intent(getApplication(), MainTabActivity.class);
            startActivity(intent);
        }
*/

        haisetuView.setText(haisetuS);
        mizupposaView.setText(mizupposaS);

        haisetuSeek.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        /* 渡す値の格納 */
                        haisetuS = Functions.valueOfHaisetu(progress);
                        haisetuValue = progress;
                        haisetuView.setText(haisetuS);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    }
                }

        );

        mizupposaSeek.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        /* 渡す値の格納 */
                        mizupposaS = Functions.valueOfMizupposa(progress);
                        mizupposaValue = progress;
                        mizupposaView.setText(mizupposaS);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    }
                }

        );
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
                Intent intent2 = new Intent();
                intent2.setClassName("com.example.simplecropviewsample", "com.example.simplecropviewsample.MainTabActivity");
                startActivity(intent2);
                break;
            case 1:

//                ika.setVisibility(View.VISIBLE);
                nioi.setVisibility(View.VISIBLE);
                haisetu.setVisibility(View.VISIBLE);
                haisetuView.setVisibility(View.VISIBLE);
                mizupposa.setVisibility(View.VISIBLE);
                mizupposaView.setVisibility(View.VISIBLE);
                nioiGroup.setVisibility(View.VISIBLE);
                haisetuSeek.setVisibility(View.VISIBLE);
                mizupposaSeek.setVisibility(View.VISIBLE);
                imgView.setVisibility(View.VISIBLE);
                resultView.setVisibility(View.VISIBLE);


                unkoCheckView.setVisibility(View.INVISIBLE);

                haisetuTri = 0;
                break;
            default:
                break;
        }
    }

    public void ClickHaisetuSaveButton(View view) {
        switch(haisetuTri) {
            case 0:

                unkoCheckView.setVisibility(View.VISIBLE);

//                ika.setVisibility(View.INVISIBLE);
                nioi.setVisibility(View.INVISIBLE);
                haisetu.setVisibility(View.INVISIBLE);
                mizupposa.setVisibility(View.INVISIBLE);
                mizupposaView.setVisibility(View.INVISIBLE);
                nioiGroup.setVisibility(View.INVISIBLE);
                haisetuSeek.setVisibility(View.INVISIBLE);
                mizupposaSeek.setVisibility(View.INVISIBLE);
                haisetuView.setVisibility(View.INVISIBLE);
                imgView.setVisibility(View.INVISIBLE);
                resultView.setVisibility(View.INVISIBLE);

                RadioButton checkedButton = (RadioButton) findViewById(nioiGroup.getCheckedRadioButtonId());
                StrCheckedButton = checkedButton.getText().toString();

                unkoCheckView.setText("　　　　　　 [内容確認]\n以下の入力内容で保存してもよろしいでしょうか？\n"
                        + "--------------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "　におい:\n　　　　「" + StrCheckedButton + "」\n"
                        + "　排泄量:\n　　　　「" + haisetuS + "」\n"
                        + "　水っぽさ:\n　　　　「" + mizupposaS + "」\n"
                        + "　メモ:\n　" + "うんちたべた" + "\n"
                        + "--------------------------------------------------------------\n");

                haisetuTri = 1;
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
}