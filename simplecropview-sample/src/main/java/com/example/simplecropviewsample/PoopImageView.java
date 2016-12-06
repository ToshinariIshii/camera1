package com.example.simplecropviewsample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PoopImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poop_image_view);

        Intent intent = this.getIntent();
        String pass = intent.getStringExtra("pass");
        ImageView imageView = (ImageView)findViewById(R.id.image);
        Bitmap bmImg = BitmapFactory.decodeFile(pass);
        imageView.setImageBitmap(bmImg);
/*
        String path = Environment.getExternalStorageDirectory()+ "/storage/emulated/0/MyPhoto/pic_20161206_1930.jpg";

        File imgFile = new File(path);
        if(imgFile.exists())
        {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }
*/
    }
}
