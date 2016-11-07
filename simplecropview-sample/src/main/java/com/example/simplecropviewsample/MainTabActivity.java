package com.example.simplecropviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class MainTabActivity extends FragmentActivity implements TabHost.OnTabChangeListener {

	// TabHost
    private TabHost mTabHost;
    // Last selected tabId
    private String mLastTabId;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        
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

        // �����^�u�I��
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
            		.replace(R.id.realtabcontent, new Tab3Fragment());
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
    public void startCamera2Activity() {
        Intent intent = new Intent(this,Camera2Activity.class);
        startActivity(intent);

    }
}
