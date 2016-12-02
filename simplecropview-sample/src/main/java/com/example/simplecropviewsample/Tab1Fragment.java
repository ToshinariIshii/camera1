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
        if(((MainTabActivity) getActivity()).countINIT()==3){
            chart=1;
            bubbleinit=1;
        }else if(((MainTabActivity) getActivity()).countINIT()==2){
            bubbleinit=1;
        }else if(((MainTabActivity) getActivity()).countINIT()==1){
            chart=1;
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
        CombinedChart combinedChart = (CombinedChart)v. findViewById(R.id.CombinedChart);
        CombinedData data = new CombinedData(((MainTabActivity)getActivity()).getXAxisValues());
//        if(chart!=0) {
            data.setData(((MainTabActivity) getActivity()).barData());
//            data.setData(((MainTabActivity) getActivity()).CandleData());
//
//            if(bubbleinit==1) {
                data.setData(((MainTabActivity) getActivity()).BubbleData());
//            }
//        }
        combinedChart.setData(data);
//        combinedChart.animateY(5000);//アニメーション
        combinedChart.setVisibleXRangeMaximum(10);
//        combinedChart.getAxisLeft().setDrawGridLines(false);//グラフの線の除去
        combinedChart.getAxisRight().setDrawGridLines(false);//グラフの線の除去
        combinedChart.getXAxis().setDrawGridLines(false);//グラフの線の除去
        combinedChart.setDescription("12月02日");// Hide the description
        combinedChart.setDescriptionPosition((float)size_x/2,50);
        combinedChart.getAxisLeft().setAxisMinValue(0);
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        ((MainTabActivity) getActivity()).combine(combinedChart);
//        combinedChart.moveViewToX(0);
//
        combinedChart.getAxisLeft().setDrawLabels(false);
        combinedChart.getAxisRight().setDrawLabels(false);
//        combinedChart.getXAxis().setDrawLabels(false);
        combinedChart.getLegend().setEnabled(false);   // Hide the legend
        return v;
    }
}
