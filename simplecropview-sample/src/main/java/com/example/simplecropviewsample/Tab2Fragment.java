package com.example.simplecropviewsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Tab2Fragment extends Fragment {


    @Override
    public View onCreateView(
    		LayoutInflater inflater,
    		ViewGroup container,
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2_fragment, container, false);
        ImageButton btn = (ImageButton)v.findViewById(R.id.CameraButton);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                ((MainTabActivity) getActivity()).startCamera2Activity();
//            }
//        });
        return v;
    }

}
