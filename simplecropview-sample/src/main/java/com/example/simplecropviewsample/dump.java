package com.example.simplecropviewsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.isseiaoki.simplecropview.util.Utils;
import java.util.concurrent.ExecutorService;

public class dump extends FragmentActivity {
    private static final String TAG = dump.class.getSimpleName();
    private ImageView mImageView;
    private ImageView testImageView;
    private ExecutorService mExecutor;
    private static Bitmap bitmap;

    public static Intent createIntent(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, dump.class);
        intent.setData(uri);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // apply custom font
        FontUtils.setFont((ViewGroup) findViewById(R.id.layout_root));

        mImageView = (ImageView) findViewById(R.id.result_image);
        testImageView = (ImageView) findViewById(R.id.result_image_test);
//        mExecutor = Executors.newSingleThreadExecutor();

        final Uri uri = getIntent().getData();
//        mExecutor.submit(new LoadScaledImageTask(this, uri, mImageView, calcImageSize()));
        int maxSize = Utils.getMaxSize();
        int requestSize = Math.min(calcImageSize(), maxSize);
        bitmap = Utils.decodeSampledBitmapFromUri(this, uri, requestSize);
        testImageView.setImageBitmap(bitmap);
//        try {
//            FileOutputStream out = new FileOutputStream(TrimingPicture);
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            out.flush();
//            out.close();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        // save index
//        ContentValues values = new ContentValues();
//        ContentResolver contentResolver = getContentResolver();
//        //マイムタイプ
//        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
//        //拡張子抜きの画像名
//        values.put(MediaStore.Images.Media.TITLE, TrimingPicturetitle);
//        values.put("_data", TrimingPicture);
//        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
   }
//
//    @Override
//    protected void onDestroy() {
//        mExecutor.shutdown();
//        super.onDestroy();
//    }
//
    public int calcImageSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        return Math.min(Math.max(metrics.widthPixels, metrics.heightPixels), 2048);
    }
//
//    public boolean isLargeImage(Bitmap bm) {
//        return bm.getWidth() > 2048 || bm.getHeight() > 2048;
//    }
//
//    public static class LoadScaledImageTask implements Runnable {
//        private Handler mHandler = new Handler(Looper.getMainLooper());
//        Context context;
//        Uri uri;
//        ImageView imageView;
//
//        int width;
//
//        public LoadScaledImageTask(Context context, Uri uri, ImageView imageView, int width) {
//            this.context = context;
//            this.uri = uri;
//            this.imageView = imageView;
//            this.width = width;
//        }
//
//        @Override
//        public void run() {
//            final int exifRotation = Utils.getExifOrientation(context, uri);
//            int maxSize = Utils.getMaxSize();
//            int requestSize = Math.min(width, maxSize);
//            try {
//                final Bitmap sampledBitmap = Utils.decodeSampledBitmapFromUri(context, uri, requestSize);
//
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {//トリミングした写真表示部分
//                        imageView.setImageMatrix(Utils.getMatrixFromExifOrientation(exifRotation));
//                        imageView.setImageBitmap(sampledBitmap);
//                    }
//                });
//            } catch (OutOfMemoryError e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
