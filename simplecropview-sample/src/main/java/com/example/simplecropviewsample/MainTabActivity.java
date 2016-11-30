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
import static com.example.simplecropviewsample.R.drawable.boku;
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
        tab1.setIndicator("Home",ResourcesCompat.getDrawable(getResources(), R.drawable.ic_android_black_24dp, null));
        tab1.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab1);

        // Tab2 */
        TabSpec tab2 = mTabHost.newTabSpec("tab2");
        tab2.setIndicator("Camera",getResources().getDrawable(android.R.drawable.ic_btn_speak_now));
        tab2.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab2);

        // Tab3 */
        TabSpec tab3 = mTabHost.newTabSpec("tab3");
        tab3.setIndicator("Milk",getResources().getDrawable(android.R.drawable.ic_btn_speak_now));
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
        Cursor c = db.query("person", new String[]{"date", "milk", "r", "g", "b", "resultnumber"}, null,
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
    public BarData barData(){
        barlabel=0;
        ArrayList<BarEntry> group1 = new ArrayList();
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk", "r", "g", "b", "resultnumber"}, null,
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
    public CandleData CandleData(){
        bubblelabel=0;
        List<Integer> colors = new ArrayList();
        ArrayList<CandleEntry> entries= new ArrayList();
//        entries.add(new CandleEntry(0, 4.62f, 2.02f, 2.70f, 4.13f));
//                entries.add(new CandleEntry(1, 5.50f, 2.70f, 3.35f, 4.96f));
//                entries.add(new CandleEntry(2, 5.25f, 3.02f, 3.50f, 4.50f));
//                entries.add(new CandleEntry(3, 6f,    3.25f, 4.40f, 5.0f));
//                entries.add(new CandleEntry(4, 5.57f, 2f,    2.80f, 4.5f));
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date","milk","r", "g", "b","resultnumber"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
                entries.add(new CandleEntry(bubblelabel, 4.62f, 2.02f, 2.70f, 4.13f));
            bubblelabel++;
            colors.add(rgb(255,0,0
            ));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
        CandleDataSet dataset = new CandleDataSet(entries,"Candle");
        dataset.setDrawValues(false);
        dataset.setColors(colors);

        CandleData data = new CandleData(getXAxisValues(),dataset);
        return data;
    }
    public BubbleData BubbleData(){
//        final float[] hsv = new float[]{108,243,135};
        bubblelabel=0;
        List<Integer> colors = new ArrayList();
        ArrayList<BubbleEntry> bubble = new ArrayList();

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date","milk","r", "g", "b","resultnumber"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(c.getInt(5)==0){
//                bubble.add(new BubbleEntry(bubblelabel,0,0));
//            }else {
//            if(bubblelabel==0) {
                bubble.add(new BubbleEntry(bubblelabel, c.getInt(5), 0f));
            }else{
                bubble.add(new BubbleEntry(bubblelabel, c.getInt(5), 1f));
            }
//            if(bubblelabel%2==0) {
//            colors.add(Color.HSVToColor(hsv));
                colors.add(rgb(c.getInt(2), c.getInt(3), c.getInt(4)));
//            colors.add(rgb((int)R,(int)G,(int)B));
//            }
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
    public void DBsave(int milk) {//DBの保存機能の設定予定いいいいいい
        MyOpenHelper helper = new MyOpenHelper(this);
    final SQLiteDatabase db = helper.getReadableDatabase();
        // 現在日時の取得
        Date now = new Date(System.currentTimeMillis());
        // 日時のフォーマットオブジェクト作成
        DateFormat formatter = new SimpleDateFormat("MM/dd HH:mm.ss");
        formatter =new SimpleDateFormat("dd日 HH:mm.ss");
        formatter =new SimpleDateFormat("HH:mm.ss");
        // フォーマット
        String date = formatter.format(now);
        ContentValues insertValues = new ContentValues();
        insertValues.put("date", date);
        insertValues.put("milk", milk);
        insertValues.put("r", 0);
        insertValues.put("g", 0);
        insertValues.put("b", 0);
        insertValues.put("resultnumber", 0);
        insertValues.put("memo","no data");

        long id = db.insert("person", date, insertValues);
    }



    public void SeekToast1() {
        Toast.makeText(this, "保存した(してない)", Toast.LENGTH_SHORT).show();
    }

    public void SeekToast2() {
        Toast.makeText(this, "保存してない", Toast.LENGTH_SHORT).show();
    }

    public int countINIT(){//bubblechartとbarchartのデータがあるかの判定
        int i=0;
        int milkcount=0;
        int resultcount=0;
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("person", new String[]{"date", "milk", "r", "g", "b", "resultnumber"}, null,
                null, null, null, null);
        boolean mov = c.moveToFirst();
        while (mov) {
            if(c.getInt(1)>0){
                milkcount=1;
            }
            if(c.getInt(5)>0){
                resultcount=2;
            }
            mov = c.moveToNext();
        }
        c.close();
        db.close();
        if(milkcount>0 && resultcount>0){
            i=3;
        }else if(milkcount>0 && resultcount==0){//milkのみでーたある
            i=1;
        }else if(milkcount==0&&resultcount>0){//画像１ッ回取ってる
            i=2;
        }
        return i;
    }
}
