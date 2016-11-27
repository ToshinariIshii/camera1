package com.example.simplecropviewsample;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import static com.example.simplecropviewsample.MainTabActivity.chart;

public class SeekBar_Activity extends Fragment {

//    MyOpenHelper helper = new MyOpenHelper(getActivity());
//    final SQLiteDatabase db = helper.getReadableDatabase();

    /*最終的に渡す値*/
    public static String realTime; // 桁数の関係でStringにした "yyyyMMddHHmm"
    public static int SeekMilkValue = 0; // シークバーで選択した0~4の整数
    public static int milkValue = 0; // 「約 ○○ ml」で入力した整数
    public static String StrCheckedButton; // 母乳 or ミルク


    private SeekBar seekBar;
    private TextView seekText1, background1, background2, breastMilk, checkView, yaku, ml, milkView,milkView2;//seek, breastMilk, check, yaku, ml, milk
    private Button cancelButton;
    private Button saveButton;
    static int sbTri;
    private EditText editText;
    private RadioGroup milkGroup;

//    private FloatingActionButton fab;
    static View v;

    String s = "(未入力)";//"うわあぁあぁｳﾝﾁｳﾝﾁｳﾝﾁ";


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_seek, container, false);
        View vtabhost = inflater.inflate(R.layout.activity_tabhost, container, false);
        sbTri = 0;//初期化

        seekBar = (SeekBar)v.findViewById(R.id.SeekBar01);
        background1= (TextView)v. findViewById(R.id.background1);
        background2= (TextView)v. findViewById(R.id.background2);
        seekText1 = (TextView)v. findViewById(R.id.seekText);
        checkView = (TextView)v. findViewById(R.id.checkView1);
        breastMilk = (TextView)v. findViewById(R.id.breastMilkView1);
        milkView = (TextView)v. findViewById(R.id.milkView1);
        milkView2 = (TextView)v. findViewById(R.id.milkView2);
        yaku = (TextView)v. findViewById(R.id.yaku);
        ml = (TextView)v. findViewById(R.id.ml);

        cancelButton = (Button)v. findViewById(R.id.cancelButton1);
        saveButton = (Button)v. findViewById(R.id.saveButton1);
        editText = (EditText)v. findViewById(R.id.editText);

        milkGroup = (RadioGroup)v.findViewById(R.id.milkGroup);
        // 指定した ID のラジオボタンをチェックします
        milkGroup.check(R.id.RadioButton1);
        ///////////

//        fab = (FloatingActionButton)vtabhost.findViewById(R.id.fab);

        checkView.setVisibility(View.INVISIBLE); // checkView1 の非表示

        seekText1.setText(s);

        seekBar.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        /* 渡す値の格納 */
                        s = FunctionsSeek.valueOfBreastMilk(progress);
                        SeekMilkValue = progress;
                        seekText1.setText(s);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    }
                }

        );
        Button saveButton = (Button)v.findViewById(R.id.saveButton1);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickSave(v);
            }
        });

        Button cancelButton = (Button)v.findViewById(R.id.cancelButton1);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickCancel(v);
            }
        });
        return v;
    }

    public void ClickSave(View view) {
        switch (sbTri) {
            case 0:
                checkView.setVisibility(View.VISIBLE);// checkView1 の表示
                /* 渡す値の格納 */
                realTime = FunctionsSeek.realTime(1);
                if(editText.getText().toString().length() != 0)
                    milkValue = Integer.parseInt(editText.getText().toString());
                else milkValue = 0;
                RadioButton checkedButton = (RadioButton)v. findViewById(milkGroup.getCheckedRadioButtonId());
                StrCheckedButton = checkedButton.getText().toString();


                checkView.setText("\n　　　　　　 [内容確認]\n以下の入力内容で保存してもよろしいでしょうか？\n\n"
                        + "--------------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "摂取物: 「" + StrCheckedButton + "」\n\n"
                        + "摂取量(主観): 「" + s + "」\n\n"
                        + "摂取量(測量): 「約 " + milkValue + " ml」\n"
                        + "--------------------------------------------------------------\n");
                //非表示
                seekText1.setVisibility(View.INVISIBLE);
                background1.setVisibility(View.INVISIBLE);
                background2.setVisibility(View.INVISIBLE);
                breastMilk.setVisibility(View.INVISIBLE);
                yaku.setVisibility(View.INVISIBLE);
                milkView.setVisibility(View.INVISIBLE);
                milkView2.setVisibility(View.INVISIBLE);

                seekBar.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                ml.setVisibility(View.INVISIBLE);

                ////////
//                fab.setVisibility(View.INVISIBLE);
                milkGroup.setVisibility(View.INVISIBLE);

                cancelButton.setText("戻る");
                saveButton.setText("保存");

                sbTri++;
                break;
            case 1:
                ((MainTabActivity)getActivity()).SeekToast1();
                ((MainTabActivity)getActivity()).DBsave(milkValue);
            chart=1;
                break;
            default:
                break;
        }
    }

    public void ClickCancel(View view) {
        switch (sbTri) {
            case 0:
                ((MainTabActivity)getActivity()).SeekToast2();
                break;
            case 1:
                //非表示
                seekText1.setVisibility(View.VISIBLE);
                background1.setVisibility(View.VISIBLE);
                background2.setVisibility(View.VISIBLE);
                breastMilk.setVisibility(View.VISIBLE);
                checkView.setVisibility(View.VISIBLE);
                yaku.setVisibility(View.VISIBLE);
                milkView.setVisibility(View.VISIBLE);
                milkView2.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                ml.setVisibility(View.VISIBLE);
                milkGroup.setVisibility(View.VISIBLE);

                cancelButton.setText("戻る");
                saveButton.setText("進む");
                checkView.setVisibility(View.INVISIBLE);

                sbTri--;
                break;

            case 2:
                checkView.setVisibility(View.INVISIBLE);// checkView1 の非表示

                cancelButton.setText("戻る");
                saveButton.setText("進む");

                sbTri--;
                break;
            default:
                break;
        }
    }


}
