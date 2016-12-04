package com.example.simplecropviewsample;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.graphics.Color.rgb;
import static com.example.simplecropviewsample.SubActivity.selectedText_date;
import static com.example.simplecropviewsample.TestgraphActivity.barlabel;
import static com.example.simplecropviewsample.TestgraphActivity.bubblelabel;

public class MainTabActivity extends FragmentActivity implements TabHost.OnTabChangeListener, OnChartValueSelectedListener {
public static int chart=0;
	// TabHost
    private TabHost mTabHost;
    // Last selected tabId
    private String mLastTabId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startTextActivity();
//                startSubActivity();
            }
        });
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        /* Tab1 */
        TabSpec tab1 = mTabHost.newTabSpec("tab1");
        tab1.setIndicator("Home");
        tab1.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab1);

        // Tab2 */
        TabSpec tab2 = mTabHost.newTabSpec("tab2");
        tab2.setIndicator("Camera");
        tab2.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab2);

        // Tab3 */
        TabSpec tab3 = mTabHost.newTabSpec("tab3");
        tab3.setIndicator("Milk");
//        tab3.setIndicator("Milk",ResourcesCompat.getDrawable(getResources(), R.drawable.ic_android_black_24dp, null));
        tab3.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab3);


        mTabHost.setOnTabChangedListener(this);

        onTabChanged("tab1");
    }


    public void onTabChanged(String tabId) {
    	Log.d("TAB_FRAGMENT_LOG","tabId:" + tabId);
    	if(mLastTabId != tabId){
            FragmentTransaction fragmentTransaction
                 = getSupportFragmentManager().beginTransaction();
            if("tab1" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new Tab1Fragment());
            }else if("tab2" == tabId){
//            	fragmentTransaction
//            		.replace(R.id.realtabcontent, new Tab2Fragment());
                startCamera2Activity();
            }else if("tab3" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new SeekBar_Activity());
            }
    		mLastTabId = tabId;
    		fragmentTransaction.commit();
    	}
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }


    private static class DummyTabFactory implements TabContentFactory {

        /* Context */
        private final Context mContext;
        DummyTabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            return v;
        }
    }

    public double Windowsize_X() {
                WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        // ディスプレイのインスタンス生成
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        return size.x;
//        String width = "Width = " + size.x;
//        String height = "Height = " + size.y;
    }

    //グラフ表示画面で機種によって違う画面の大きさを取得する（削除予定かも）
    public double Windowsize_Y() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        // ディスプレイのインスタンス生成
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        return size.y;
//        String width = "Width = " + size.x;
//        String height = "Height = " + size.y;
    }
    // creating list of x-axis values
    public ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList();
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milkseek", "r", "g", "b", "resultnumber"}, null,
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

    public void startCamera2Activity() {
        Intent intent = new Intent(this,Camera2Activity.class);
        startActivity(intent);
    }
    public void startTextActivity() {
        Intent intent = new Intent(this,TextActivity.class);
        startActivity(intent);
    }
    public void startSubActivity() {
        Intent intent = new Intent(this,SubActivity.class);
        startActivity(intent);
    }
    public void starttesttestActivity() {
        Intent intent = new Intent(this,testtext.class);
        startActivity(intent);
    }

    // this method is used to create data for Bar graph
//    public BarData barData(){
//        barlabel=0;
//        ArrayList<BarEntry> group1 = new ArrayList();
//        MyOpenHelper helper = new MyOpenHelper(this);
//        final SQLiteDatabase db = helper.getReadableDatabase();
//        // queryメソッドの実行例
//        Cursor c = db.query("person", new String[]{"date", "milkseek", "r", "g", "b", "resultnumber"}, null,
//                null, null, null, null);
//        boolean mov = c.moveToFirst();
//        while (mov) {
//            group1.add(new BarEntry(c.getInt(1),barlabel));
//            barlabel++;
//            mov = c.moveToNext();
//        }
////        group1.add(new BarEntry(40f,0));
////        group1.add(new BarEntry(80f,1));
////        group1.add(new BarEntry(60f,2));
////        group1.add(new BarEntry(120f,3));
////        group1.add(new BarEntry(180f,4));
////        group1.add(new BarEntry(90f,5));
//        BarDataSet barDataSet = new BarDataSet(group1,"ミルクの量");
//        barDataSet.setDrawValues(false);
//        //barDataSet.setColor(Color.rgb(0, 155, 0));
////        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//        BarData barData = new BarData(getXAxisValues(),barDataSet);
//        c.close();
//        db.close();
//        return barData;
//    }
    // this method is used to create data for Bar graph
    public BarData barData(){
        barlabel=0;
        ArrayList<BarEntry> group1 = new ArrayList<BarEntry>();
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"milkseek","outo","seki","hassin","kigen","genki","memo"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        //各チェックボックスから値を取得しグラフに表示(チェック入れられていないものは白色に
        while (mov) {
            float outotrue=0,outofalth=0,sekitrue=0,sekifalth=0,hassintrue=0,hassinfalth=0,kigentrue=0,kigenfalth=0,genkitrue=0,genkifalth=0,memotrue=0,memofalth=0;
            if(c.getInt(1)==1){
                outotrue=0.1f;
            }else{
                outofalth=0.1f;
            }
            if(c.getInt(2)==1){
                sekitrue=0.1f;
            }else{
                sekifalth=0.1f;
            }
            if(c.getInt(3)==1){
                hassintrue=0.1f;
            }else{
                hassinfalth=0.1f;
            }
            if(c.getInt(4)==1){
                kigentrue=0.1f;
            }else{
                kigenfalth=0.1f;
            }
            if(c.getInt(5)==1){
                genkitrue=0.1f;
            }else{
                genkifalth=0.1f;
            }
            if(c.getString(6).equals("(未入力)")){
                memofalth=0.1f;
            }else{
                memotrue=0.1f;
            }
            group1.add(new BarEntry(new float[]{memotrue, memofalth, outotrue, outofalth, sekitrue, sekifalth,
                    hassintrue, hassinfalth, kigentrue, kigenfalth, genkitrue, genkifalth, Float.valueOf(c.getInt(0))}, barlabel));
            barlabel++;
            mov = c.moveToNext();
        }
//        group1.add(new BarEntry(40f,0));
//        group1.add(new BarEntry(80f,1));
//        group1.add(new BarEntry(60f,2));
//        group1.add(new BarEntry(120f,3));
//        group1.add(new BarEntry(180f,4));
//        group1.add(new BarEntry(90f,5));
        BarDataSet barDataSet = new BarDataSet(group1,"");
//        BarDataSet barDataSet = new BarDataSet(group1,"ミルクの量");
        barDataSet.setDrawValues(false);
        int[] colors = new int[13];
        colors[0]=Color.rgb(255, 0, 0);
        colors[1]=Color.rgb(255, 255, 255);
        colors[2]=Color.rgb(0, 255, 0);
        colors[3]=Color.rgb(255, 255, 255);
        colors[4]=Color.rgb(180, 0, 100);
        colors[5]=Color.rgb(255, 255, 255);
        colors[6]=Color.rgb(125, 125, 0);
        colors[7]=Color.rgb(255, 255, 255);
        colors[8]=Color.rgb(0, 125, 125);
        colors[9]=Color.rgb(255, 255, 255);
        colors[10]=Color.rgb(0, 255, 255);
        colors[11]=Color.rgb(255, 255, 255);
        colors[12]=Color.rgb(50, 125, 50);
        //barDataSet.setColor(Color.rgb(0, 155, 0));
        barDataSet.setStackLabels(new String[]{"メモ","嘔吐", "咳が多い", "発疹","機嫌が悪い","元気がない","空白","ミルク"});
        barDataSet.setColors(colors);
        BarData barData = new BarData(getXAxisValues(),barDataSet);
        c.close();
        db.close();
        return barData;
    }
    public BubbleData BubbleData(){
//        final float[] hsv = new float[]{108,243,135};
        bubblelabel=0;
        List<Integer> colors = new ArrayList();
        ArrayList<BubbleEntry> bubble = new ArrayList();

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date","milkseek","r", "g", "b","resultnumber"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(bubblelabel==0) {
//                bubble.add(new BubbleEntry(bubblelabel,0,0));
//            }else {
//            if(bubblelabel==0) {
                bubble.add(new BubbleEntry(bubblelabel, 1, 0f));
                colors.add(rgb(255, 255, 255));
            }else {
                if (c.getInt(5) == 0) {
                    bubble.add(new BubbleEntry(bubblelabel, 1, 0f));
                    colors.add(rgb(255, 255, 255));
                } else {
                    bubble.add(new BubbleEntry(bubblelabel, 9, 1f));
//            if(bubblelabel%2==0) {
//            colors.add(Color.HSVToColor(hsv));
                    colors.add(rgb(c.getInt(2), c.getInt(3), c.getInt(4)));
//            colors.add(rgb((int)R,(int)G,(int)B));
                }
            }
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

public void combine(CombinedChart combinedChart) {
    combinedChart.setOnChartValueSelectedListener(this);
    combinedChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
        @Override
        public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
            if (e == null)
                return;
            Toast.makeText(MainTabActivity.this, getXAxisValues().get(e.getXIndex()), Toast.LENGTH_SHORT).show();
//            Intent dbIntent = new Intent(this,TestgraphActivity.class);
//            startActivity(dbIntent);

            selectedText_date=getXAxisValues().get(e.getXIndex());
            startSubActivity();
        }

        @Override
        public void onNothingSelected() {

        }
    });
}
    public void DBsave(String milkkind,int milkseek,int milkvalue,String StrHitokotomemo) {//DBの保存機能の設定予定いいいいいい
        MyOpenHelper helper = new MyOpenHelper(this);
    final SQLiteDatabase db = helper.getReadableDatabase();
        // 現在日時の取得
        Date now = new Date(System.currentTimeMillis());
        // 日時のフォーマットオブジェクト作成
        DateFormat formatter = new SimpleDateFormat("MM/dd HH:mm");
//        formatter =new SimpleDateFormat("dd日 HH:mm.ss");
//        formatter =new SimpleDateFormat("HH:mm.ss");
//        // フォーマット
        String date = formatter.format(now);
        ContentValues insertValues = new ContentValues();
        insertValues.put("date", date);
        insertValues.put("milkkind", milkkind);
        insertValues.put("milkseek", milkseek);
        insertValues.put("milkvalue", milkvalue);
        insertValues.put("r", 255);
        insertValues.put("g", 255);
        insertValues.put("b", 255);
        insertValues.put("resultnumber", 0);
        insertValues.put("memo",StrHitokotomemo);

        long id = db.insert("person", date, insertValues);
    }



    public void SeekToast1() {
        Toast.makeText(this, "保存した", Toast.LENGTH_SHORT).show();
    }

    public void SeekToast2() {
        Toast.makeText(this, "入力情報を破棄した", Toast.LENGTH_SHORT).show();
    }

    public void goHome(){
        Intent homeIntent = new Intent(this,MainTabActivity.class);
        startActivity(homeIntent);
    }

    public int countINIT() {//bubblechartとbarchartのデータがあるかの判定
        int i = 0;
        int resultcount = 0;
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milkseek", "r", "g", "b", "resultnumber"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if (c.getInt(5) > 0) {
                resultcount = 1;
            }
            mov = c.moveToNext();
        }
        c.close();
        db.close();
        if (resultcount > 0) {
            i = 1;
        }
        return i;
    }
}
