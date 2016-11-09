package com.example.simplecropviewsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBar_Activity extends Fragment {

    /*最終的に渡す値*/
    public static String realTime; // 桁数の関係でStringにした
    public static int breastMilkValue = 0;
    public static int milkValue = 0;

    private SeekBar seekBar;
    private TextView st1, bm, cv1, yaku, ml, mv;//seek, breastMilk, check, yaku, ml, milk
    private Button cb;
    private Button sb;
    static int sbTri = 0;
    private EditText et;

    String s = "うわあぁあぁｳﾝﾁｳﾝﾁｳﾝﾁ";


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_seek, container, false);

        seekBar = (SeekBar)v.findViewById(R.id.SeekBar01);
        st1 = (TextView)v. findViewById(R.id.seekText);
        cv1 = (TextView)v. findViewById(R.id.checkView1);
        bm = (TextView)v. findViewById(R.id.breastMilkView1);
        mv = (TextView)v. findViewById(R.id.milkView1);
        yaku = (TextView)v. findViewById(R.id.yaku);
        ml = (TextView)v. findViewById(R.id.ml);

        cb = (Button)v. findViewById(R.id.cancelButton1);
        sb = (Button)v. findViewById(R.id.saveButton1);
        et = (EditText)v. findViewById(R.id.editText);


        cv1.setVisibility(View.INVISIBLE); // checkView1 の非表示

        st1.setText(s);

        seekBar.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        /* 渡す値の格納 */
                        s = FunctionsSeek.valueOfBreastMilk(progress);
                        breastMilkValue = progress;
                        st1.setText(s);
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
                cv1.setVisibility(View.VISIBLE);// checkView1 の表示

                /* 渡す値の格納 */
                realTime = FunctionsSeek.realTime(1);
                if(et.getText().toString().length() != 0)
                    milkValue = Integer.parseInt(et.getText().toString());
                else milkValue = 0;

                cv1.setText("以下の内容で保存してもよろしいですか？\n\n"
                        + "---------------------------------------------------------\n"
                        + FunctionsSeek.realTime(2) + "\n\n"
                        + "母乳: " + s + "\n\n"
                        + "粉ミルク: 約 " + milkValue + " ml\n"
                        + "---------------------------------------------------------\n");
                //非表示
                st1.setVisibility(View.INVISIBLE);
                bm.setVisibility(View.INVISIBLE);
                yaku.setVisibility(View.INVISIBLE);
                mv.setVisibility(View.INVISIBLE);
                seekBar.setVisibility(View.INVISIBLE);
                et.setVisibility(View.INVISIBLE);
                ml.setVisibility(View.INVISIBLE);
                cb.setText("やっぱだめ");
                sb.setText("いいよ");

                sbTri++;
                break;
            case 1:
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
                st1.setVisibility(View.VISIBLE);
                bm.setVisibility(View.VISIBLE);
                cv1.setVisibility(View.VISIBLE);
                yaku.setVisibility(View.VISIBLE);
                mv.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                et.setVisibility(View.VISIBLE);
                ml.setVisibility(View.VISIBLE);

                cb.setText("CANCEL");
                sb.setText("SAVE");
                cv1.setVisibility(View.INVISIBLE);

                sbTri--;
                break;
            default:
                break;
        }
    }


}
