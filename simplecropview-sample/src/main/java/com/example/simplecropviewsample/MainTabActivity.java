package com.example.simplecropviewsample;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.simplecropviewsample.TestgraphActivity.barlabel;

public class MainTabActivity extends FragmentActivity implements TabHost.OnTabChangeListener {

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
                startTestgraphActivity();
            }
        });
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        /* Tab1 */
        TabSpec tab1 = mTabHost.newTabSpec("tab1");
        tab1.setIndicator("TAB1");
        tab1.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab1);

        // Tab2 */
        TabSpec tab2 = mTabHost.newTabSpec("tab2");
        tab2.setIndicator("TAB2");
        tab2.setContent(new DummyTabFactory(this));
        mTabHost.addTab(tab2);

        // Tab3 */
        TabSpec tab3 = mTabHost.newTabSpec("tab3");
        tab3.setIndicator("TAB3");
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
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new Tab2Fragment());
            }else if("tab3" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new SeekBar_Activity());
            }
    		mLastTabId = tabId;
    		fragmentTransaction.commit();
    	}
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
    public void startCamera2Activity() {
        Intent intent = new Intent(this,Camera2Activity.class);
        startActivity(intent);
    }
    public void startTextActivity() {
        Intent intent = new Intent(this,TextActivity.class);
        startActivity(intent);
    }
    public void startTestgraphActivity() {
        Intent intent = new Intent(this,TestgraphActivity.class);
        startActivity(intent);
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

        long id = db.insert("person", date, insertValues);
    }

    public void SeekToast1() {
        Toast.makeText(this, "保存した(してない)", Toast.LENGTH_SHORT).show();
    }

    public void SeekToast2() {
        Toast.makeText(this, "殺す", Toast.LENGTH_SHORT).show();
    }
}
