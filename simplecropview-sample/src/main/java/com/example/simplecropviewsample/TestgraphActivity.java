package com.example.simplecropviewsample;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CombinedData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by b1014001 on 2016/11/25.
 */

public class TestgraphActivity extends Activity {
    public static int bubblelabel;
    public static int barlabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1_fragment);
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        // ディスプレイのインスタンス生成
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
//        String width = "Width = " + size.x;
//        String height = "Height = " + size.y;
        CombinedChart combinedChart = (CombinedChart) findViewById(R.id.CombinedChart);
        CombinedData data = new CombinedData(getXAxisValues());
        data.setData(barData());
//        data.setData(BubbleData());
        combinedChart.setData(data);
//        combinedChart.animateY(5000);//アニメーション
        combinedChart.setVisibleXRangeMaximum(10);
        combinedChart.getAxisLeft().setDrawGridLines(false);//グラフの線の除去
        combinedChart.getAxisRight().setDrawGridLines(false);//グラフの線の除去
        combinedChart.getXAxis().setDrawGridLines(false);//グラフの線の除去
        combinedChart.setDescription("11月25日");    // Hide the description
        combinedChart.setDescriptionPosition((float)size.x/2,100);
//        combinedChart.getAxisLeft().setDrawLabels(false);
//        combinedChart.getAxisRight().setDrawLabels(false);
//        combinedChart.getXAxis().setDrawLabels(false);

        combinedChart.getLegend().setEnabled(false);   // Hide the legend
    }

    // creating list of x-axis values
    private ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList();
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            labels.add(c.getString(0));
            mov = c.moveToNext();
        }
//        labels.add("JAN");
//        labels.add("FEB");
//        labels.add("MAR");
//        labels.add("APR");
//        labels.add("MAY");
//        labels.add("JUNE");
//        labels.add("JAN");
//        labels.add("FEB");
//        labels.add("MAR");
//        labels.add("APR");
//        labels.add("MAY");
//        labels.add("JUNE");
        c.close();
        db.close();
        return labels;
    }
    // this method is used to create data for bubble graph
    public BubbleData BubbleData(){
        final float[] hsv = new float[]{108,243,135};
        bubblelabel=0;
        List<Integer> colors = new ArrayList();
        ArrayList<BubbleEntry> bubble = new ArrayList();

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            bubble.add(new BubbleEntry(bubblelabel,c.getInt(2),0.01f/2));
//            if(bubblelabel%2==0) {
            colors.add(Color.HSVToColor(hsv));
//            colors.add(rgb (210,131,177));
//            colors.add(rgb((int)R,(int)G,(int)B));

            bubblelabel++;
            mov = c.moveToNext();
        }
//        bubble.add(new BubbleEntry(0,10f, 3));
//        bubble.add(new BubbleEntry(1,20f, 6));
//        bubble.add(new BubbleEntry(2,30f, 9));
//        bubble.add(new BubbleEntry(3,40f, 12));
//        bubble.add(new BubbleEntry(4,50f, 15));
//        bubble.add(new BubbleEntry(5,60f, 18));
        c.close();
        db.close();
        BubbleDataSet bubbleDataSet = new BubbleDataSet( bubble ,"色");
        bubbleDataSet.setDrawValues(false);
//        bubbleDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        bubbleDataSet.setColors(colors);
        BubbleDataSet dataSet = bubbleDataSet; // get a dataset
        dataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);//右のy軸を基準に
        BubbleData bubbleData = new BubbleData(getXAxisValues(),bubbleDataSet);
        return bubbleData;
    }
    // this method is used to create data for Bar graph
    public BarData barData(){
        barlabel=0;
        ArrayList<BarEntry> group1 = new ArrayList();
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            group1.add(new BarEntry(c.getInt(1),barlabel));
            barlabel++;
            mov = c.moveToNext();
        }
//        group1.add(new BarEntry(40f,0));
//        group1.add(new BarEntry(80f,1));
//        group1.add(new BarEntry(60f,2));
//        group1.add(new BarEntry(120f,3));
//        group1.add(new BarEntry(180f,4));
//        group1.add(new BarEntry(90f,5));
        BarDataSet barDataSet = new BarDataSet(group1,"ミルクの量");
        barDataSet.setDrawValues(false);
        //barDataSet.setColor(Color.rgb(0, 155, 0));
//        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(getXAxisValues(),barDataSet);
        c.close();
        db.close();
        return barData;
    }

}

