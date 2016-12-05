package com.example.simplecropviewsample;

import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.CombinedData;

import static android.content.Context.WINDOW_SERVICE;
import static com.example.simplecropviewsample.MainTabActivity.chart;
import static com.example.simplecropviewsample.ResultActivity.bubbleinit;

public class Tab1Fragment extends Fragment {
    static View v;
    @Override
    public View onCreateView(
    		LayoutInflater inflater,
    		ViewGroup container,
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1_fragment, container, false);
        if (((MainTabActivity) getActivity()).countINIT() == 1) {
            chart = 1;
            bubbleinit = 1;
        }
//        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
//        // ディスプレイのインスタンス生成
//        Display disp = wm.getDefaultDisplay();
//        Point size = new Point();
//        disp.getSize(size);
////        String width = "Width = " + size.x;
////        String height = "Height = " + size.y;
        double size_x=((MainTabActivity)getActivity()).Windowsize_X();
        double size_y=((MainTabActivity)getActivity()).Windowsize_Y();
        final CombinedChart combinedChart = (CombinedChart)v. findViewById(R.id.CombinedChart);
        final CombinedChart combinedChart_hour = (CombinedChart)v. findViewById(R.id.CombinedChart_hour);
        final CombinedChart combinedChart_day = (CombinedChart)v. findViewById(R.id.CombinedChart_day);

        Button button_ivent = (Button)v.findViewById(R.id.button_ivent);
        button_ivent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combinedChart.setVisibility(View.VISIBLE);
                combinedChart_hour.setVisibility(View.INVISIBLE);
                combinedChart_day.setVisibility(View.INVISIBLE);
            }
        });
        Button button_hour = (Button)v.findViewById(R.id.button_hour);
        button_hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combinedChart.setVisibility(View.INVISIBLE);
                combinedChart_hour.setVisibility(View.VISIBLE);
                combinedChart_day.setVisibility(View.INVISIBLE);
            }
        });
        Button button_day = (Button)v.findViewById(R.id.button_day);
        button_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combinedChart.setVisibility(View.INVISIBLE);
                combinedChart_hour.setVisibility(View.INVISIBLE);
                combinedChart_day.setVisibility(View.VISIBLE);
            }
        });

        CombinedData data = new CombinedData(((MainTabActivity)getActivity()).getXAxisValues());
        CombinedData data_hour = new CombinedData(((MainTabActivity)getActivity()).getXAxisValues());
        CombinedData data_day = new CombinedData(((MainTabActivity)getActivity()).getXAxisValues());
//        if(chart==1) {
            data.setData(((MainTabActivity) getActivity()).barData());
        data_hour.setData(((MainTabActivity) getActivity()).barData());
        data_day.setData(((MainTabActivity) getActivity()).barData());
//            data.setData(((MainTabActivity) getActivity()).CandleData());
//
            if (bubbleinit == 1) {
                data.setData(((MainTabActivity) getActivity()).BubbleData());
                data_hour.setData(((MainTabActivity) getActivity()).BubbleData());
                data_day.setData(((MainTabActivity) getActivity()).BubbleData());
            }

                combinedChart.setData(data);
//        combinedChart.animateY(5000);//アニメーション
                combinedChart.setVisibleXRangeMaximum(10);
//        combinedChart.getAxisLeft().setDrawGridLines(false);//グラフの線の除去
                combinedChart.getAxisRight().setDrawGridLines(false);//グラフの線の除去
                combinedChart.getXAxis().setDrawGridLines(false);//グラフの線の除去
                combinedChart.setDescription("");// Hide the description
                combinedChart.setDescriptionPosition((float) size_x / 2, 50);
                combinedChart.getAxisLeft().setAxisMinValue(0);
                XAxis xAxis = combinedChart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                ((MainTabActivity) getActivity()).combine(combinedChart);
//        combinedChart.moveViewToX(0);
                combinedChart.getAxisLeft().setDrawLabels(false);
                combinedChart.getAxisRight().setDrawLabels(false);
//        combinedChart.getXAxis().setDrawLabels(false);
                combinedChart.getLegend().setEnabled(false);   // Hide the legend

        combinedChart_hour.setData(data_hour);
        //        combinedChart.animateY(5000);//アニメーション
        combinedChart_hour.setVisibleXRangeMaximum(10);
//        combinedChart.getAxisLeft().setDrawGridLines(false);//グラフの線の除去
        combinedChart_hour.getAxisRight().setDrawGridLines(false);//グラフの線の除去
        combinedChart_hour.getXAxis().setDrawGridLines(false);//グラフの線の除去
        combinedChart_hour.setDescription("");// Hide the description
        combinedChart_hour.setDescriptionPosition((float) size_x / 2, 50);
        combinedChart_hour.getAxisLeft().setAxisMinValue(0);
        XAxis xAxis_hour = combinedChart_hour.getXAxis();
        xAxis_hour.setPosition(XAxis.XAxisPosition.BOTTOM);
        ((MainTabActivity) getActivity()).combine(combinedChart_hour);
//        combinedChart.moveViewToX(0);
        combinedChart_hour.getAxisLeft().setDrawLabels(false);
        combinedChart_hour.getAxisRight().setDrawLabels(false);
//        combinedChart.getXAxis().setDrawLabels(false);
        combinedChart_hour.getLegend().setEnabled(false);   // Hide the legend

        combinedChart_day.setData(data_day);
//        combinedChart.animateY(5000);//アニメーション
        combinedChart_day.setVisibleXRangeMaximum(10);
//        combinedChart.getAxisLeft().setDrawGridLines(false);//グラフの線の除去
        combinedChart_day.getAxisRight().setDrawGridLines(false);//グラフの線の除去
        combinedChart_day.getXAxis().setDrawGridLines(false);//グラフの線の除去
        combinedChart_day.setDescription("");// Hide the description
        combinedChart_day.setDescriptionPosition((float) size_x / 2, 50);
        combinedChart_day.getAxisLeft().setAxisMinValue(0);
        XAxis xAxis_day = combinedChart_day.getXAxis();
        xAxis_day.setPosition(XAxis.XAxisPosition.BOTTOM);
        ((MainTabActivity) getActivity()).combine(combinedChart_day);
//        combinedChart.moveViewToX(0);
        combinedChart_day.getAxisLeft().setDrawLabels(false);
        combinedChart_day.getAxisRight().setDrawLabels(false);
//        combinedChart.getXAxis().setDrawLabels(false);
        combinedChart_day.getLegend().setEnabled(false);   // Hide the legend
                return v;
            }
}
