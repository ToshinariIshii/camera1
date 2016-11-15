package com.example.simplecropviewsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class SeekBar_Activity extends Fragment {

    /*最終的に渡す値*/
    public static String realTime; // 桁数の関係でStringにした
    public static int breastMilkValue = 0;
    public static int milkValue = 0;

    private SeekBar seekBar;
    private TextView seekText1, breastMilk, checkView, yaku, ml, milkView, degree, weight;//seek, breastMilk, check, yaku, ml, milk
    private Button cancelButton;
    private Button saveButton;
    static int sbTri;
    private EditText editText, editWeight, memo;
    private Spinner spinner;

    private FloatingActionButton fab;

    String s = "うわあぁあぁｳﾝﾁｳﾝﾁｳﾝﾁ";


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_seek, container, false);
        View vtabhost = inflater.inflate(R.layout.activity_tabhost, container, false);

        sbTri = 0;//初期化

        seekBar = (SeekBar)v.findViewById(R.id.SeekBar01);
        seekText1 = (TextView)v. findViewById(R.id.seekText);
        checkView = (TextView)v. findViewById(R.id.checkView1);
        breastMilk = (TextView)v. findViewById(R.id.breastMilkView1);
        milkView = (TextView)v. findViewById(R.id.milkView1);
        yaku = (TextView)v. findViewById(R.id.yaku);
        ml = (TextView)v. findViewById(R.id.ml);

        degree = (TextView)v. findViewById(R.id.degree);
        weight = (TextView)v. findViewById(R.id.weight);

        cancelButton = (Button)v. findViewById(R.id.cancelButton1);
        saveButton = (Button)v. findViewById(R.id.saveButton1);
        editText = (EditText)v. findViewById(R.id.editText);
        editWeight = (EditText)v. findViewById(R.id.editWeight);
        memo = (EditText)v. findViewById(R.id.memo);

        spinner = (Spinner)v.findViewById(R.id.spinner2);

        fab = (FloatingActionButton)vtabhost.findViewById(R.id.fab);



        //TextView textView = (TextView) spinner.getChildAt(0);
        //textView.setTextColor(Color.rgb(0,0,0));


        degree.setVisibility(View.INVISIBLE);
        weight.setVisibility(View.INVISIBLE);
        editWeight.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);

        memo.setVisibility(View.INVISIBLE); // checkView1 の非表示
        checkView.setVisibility(View.INVISIBLE); // checkView1 の非表示

        seekText1.setText(s);

        seekBar.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        /* 渡す値の格納 */
                        s = FunctionsSeek.valueOfBreastMilk(progress);
                        breastMilkValue = progress;
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
                //非表示
                seekText1.setVisibility(View.INVISIBLE);
                breastMilk.setVisibility(View.INVISIBLE);
                yaku.setVisibility(View.INVISIBLE);
                milkView.setVisibility(View.INVISIBLE);
                seekBar.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                ml.setVisibility(View.INVISIBLE);

                degree.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                weight.setVisibility(View.VISIBLE);
                editWeight.setVisibility(View.VISIBLE);

                sbTri++;

                break;

            case 1:
                checkView.setVisibility(View.VISIBLE);// checkView1 の表示

                /* 渡す値の格納 */
                realTime = FunctionsSeek.realTime(1);
                if(editText.getText().toString().length() != 0)
                    milkValue = Integer.parseInt(editText.getText().toString());
                else milkValue = 0;

                checkView.setText("以下の内容で保存してもよろしいですか？\n\n"
                        + "--------------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "母乳: " + s + "\n\n"
                        + "粉ミルク: 約 " + milkValue + " ml\n"
                        + "--------------------------------------------------------------\n");
                //非表示
                seekText1.setVisibility(View.INVISIBLE);
                breastMilk.setVisibility(View.INVISIBLE);
                yaku.setVisibility(View.INVISIBLE);
                milkView.setVisibility(View.INVISIBLE);
                seekBar.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                ml.setVisibility(View.INVISIBLE);

                degree.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                weight.setVisibility(View.INVISIBLE);
                editWeight.setVisibility(View.INVISIBLE);

                ////////
                fab.setVisibility(View.INVISIBLE);

                cancelButton.setText("戻る");
                saveButton.setText("保存");

                sbTri++;
                break;
            case 2:
                ((MainTabActivity)getActivity()).SeekToast1();
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
                breastMilk.setVisibility(View.VISIBLE);
                checkView.setVisibility(View.VISIBLE);
                yaku.setVisibility(View.VISIBLE);
                milkView.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                ml.setVisibility(View.VISIBLE);

                cancelButton.setText("戻る");
                saveButton.setText("進む");
                checkView.setVisibility(View.INVISIBLE);
                degree.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                weight.setVisibility(View.INVISIBLE);
                editWeight.setVisibility(View.INVISIBLE);

                sbTri--;
                break;

            case 2:
                checkView.setVisibility(View.INVISIBLE);// checkView1 の非表示

                degree.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                weight.setVisibility(View.VISIBLE);
                editWeight.setVisibility(View.VISIBLE);

                cancelButton.setText("戻る");
                saveButton.setText("進む");

                sbTri--;
                break;
            default:
                break;
        }
    }


}
