package com.example.simplecropviewsample;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.simplecropviewsample.R.id.imageView;
import static com.example.simplecropviewsample.R.id.textView2;


public class CameraActivity extends AppCompatActivity {
    // カメラ
    private Camera myCamera;
    public static String AttachName;//映した画像の絶対パス
   public static String TrimingPicture;//トリミング画像の絶対パス
    public static String TrimingPicturetitle;//トリミング画像のタイトル（正直いるかわかんない）
    // カメラ用サーフェイスビュー
    private SurfaceView mySurfaceView;

    // 地磁気・加速度センサー
    private SensorManager mySensor;

    // 地磁気・加速度センサー情報
    private static final int MATRIX_SIZE = 16;
    private static final int DIMENSION = 3;
    private float[] magneticValues = new float[DIMENSION];
    private float[] accelerometerValues = new float[DIMENSION];
    private float[] orientationValues = new float[DIMENSION];

    /**
     * カメラのイベント処理
     */
    private PictureCallback mPictureListener =

            new PictureCallback() {

                @Override
                public void onPictureTaken(byte[] data, Camera camera) {

                    // データを生成する
                    Bitmap tmp_bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    int width = tmp_bitmap.getWidth();
                    int height = tmp_bitmap.getHeight();

                            // 画像データを回転する
                    int rad_y = radianToDegree(orientationValues[2]);
                    Matrix matrix = new Matrix();
                    if ((rad_y > -45 && rad_y <= 0) || (rad_y > 0 && rad_y <= 45)) {
                        matrix.setRotate(90);
                    } else if (rad_y > 45 && rad_y <= 135) {
                        matrix.setRotate(180);
                    } else if ((rad_y > 135 && rad_y <= 180) || (rad_y >= -180 && rad_y <= -135)) {
                        matrix.setRotate(-90);
                    } else if (rad_y > -135 && rad_y <= -45) {
                        matrix.setRotate(0);
                    }
                    Bitmap bitmap = Bitmap.createBitmap(tmp_bitmap, 0, 0, width, height, matrix, true);

                    final String SAVE_DIR = "/MyPhoto/";
                    File file = new File(Environment.getExternalStorageDirectory().getPath() + SAVE_DIR);
                    try{
                        if(!file.exists()){
                            file.mkdir();
                        }
                    }catch(SecurityException e){
                        e.printStackTrace();
                        throw e;
                    }

                    Date mDate = new Date();
                    SimpleDateFormat fileNameDate = new SimpleDateFormat("yyyyMMdd_HHmm");
                    String fileName = fileNameDate.format(mDate) + ".jpg";
                    String trimingPicture = fileNameDate.format(mDate) + "unko.jpg";
                    AttachName = file.getAbsolutePath() + "/" + fileName;
                    TrimingPicture = file.getAbsolutePath() + "/" + trimingPicture;
                    TrimingPicturetitle =fileNameDate.format(mDate) + "unko.jpg";

                    try {
                        FileOutputStream out = new FileOutputStream(AttachName);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                        out.flush();
                        out.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }

                    // save index
                    ContentValues values = new ContentValues();
                    ContentResolver contentResolver = getContentResolver();
                    //マイムタイプ
                    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                    //拡張子抜きの画像名
                    values.put(MediaStore.Images.Media.TITLE, fileName);
                    values.put("_data", AttachName);
                    contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                    //ページ移動
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    TextView test = (TextView)findViewById(textView2);
                    test.setText(AttachName);
                    ImageView post = (ImageView)findViewById(imageView);
                    Bitmap bmImg = BitmapFactory.decodeFile(AttachName);
                    post.setImageBitmap(bmImg);

//                   // カメラを再開
                   myCamera.startPreview();

                }
            };


    /**
     * カメラ用サーフェイスのイベント処理
     */
    private SurfaceHolder.Callback mSurfaceListener =

            new SurfaceHolder.Callback() {
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    myCamera.stopPreview();
                    myCamera.release();
                    myCamera = null;
                }

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    myCamera = Camera.open();
                    try {
                        myCamera.setPreviewDisplay(holder);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    myCamera.stopPreview();

                    Camera.Parameters parameters = myCamera.getParameters();

                    // 画面の向きを設定
                    boolean portrait = isPortrait();
                    if (portrait) {
                        myCamera.setDisplayOrientation(90);
                    } else {
                        myCamera.setDisplayOrientation(0);
                    }

                    // 対応するプレビューサイズ・保存サイズを取得する
                    List<Size> pictureSizes = parameters.getSupportedPictureSizes();
                    List<Size> previewSizes = parameters.getSupportedPreviewSizes();

                    // 最大解像度を選択
                    Size pictureSize = getOptimalPictureSize(pictureSizes);
                    // 写真サイズに近くて最も大きいプレビューサイズを選択する
                    Size previewSize = getOptimalPreviewSize(previewSizes, pictureSize.width, pictureSize.height);

                    parameters.setPreviewSize(previewSize.width, previewSize.height);
                    parameters.setPictureSize(pictureSize.width, pictureSize.height);

                    // サーフェイスのサイズをカメラのプレビューサイズと同じ比率に設定
                    android.view.ViewGroup.LayoutParams layoutParams = mySurfaceView.getLayoutParams();
                    double preview_raito = (double)previewSize.width / (double)previewSize.height;
                    if (width > height) {
                        // 横長
                        int new_height = (int)(width / preview_raito);
                        if (new_height <= height) {
                            layoutParams.height = height;
                        } else {
                            int new_width = (int)(height * preview_raito);
                            layoutParams.width = new_width;
                        }
                    } else {
                        // 縦長
                        int new_width = (int)(height / preview_raito);
                        if (new_width <= width) {
                            layoutParams.width = new_width;
                        } else {
                            int new_height = (int)(width * preview_raito);
                            layoutParams.height = new_height;
                        }
                    }
                    mySurfaceView.setLayoutParams(layoutParams);

                    // パラメータを設定してカメラを再開
                    myCamera.setParameters(parameters);
                    myCamera.startPreview();
                }
            };

    /**
     * オートフォーカスのイベント処理
     */
    private AutoFocusCallback mAutoFocusListener =
            new AutoFocusCallback() {
                @Override
                public void onAutoFocus(boolean success, Camera camera) {
                }
            };

    /**
     * センサー制御のイベント処理
     */
    private SensorEventListener mSensorEventListener =

            new SensorEventListener() {

                @Override
                public void onSensorChanged(SensorEvent event) {

                    // Nexus7では常にSENSOR_STATUS_UNRELIABLEになるのでチェックしない
                /*
                if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE)
                    return;
                */

                    switch (event.sensor.getType()) {
                        case Sensor.TYPE_MAGNETIC_FIELD:
                            // 地磁気センサ
                            magneticValues = event.values.clone();
                            break;
                        case Sensor.TYPE_ACCELEROMETER:
                            // 加速度センサ(Nexus7ではサポート外？)
                            accelerometerValues = event.values.clone();
                            break;
                    }

                    if (magneticValues != null && accelerometerValues != null) {
                        float[] rotationMatrix = new float[MATRIX_SIZE];
                        float[] inclinationMatrix = new float[MATRIX_SIZE];
                        float[] remapedMatrix = new float[MATRIX_SIZE];

                        // 加速度センサと地磁気センタから回転行列を取得
                        SensorManager.getRotationMatrix(rotationMatrix, inclinationMatrix, accelerometerValues, magneticValues);

                        SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, remapedMatrix);
                        SensorManager.getOrientation(remapedMatrix, orientationValues);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // カメラプレビューの設定
        mySurfaceView = (SurfaceView)findViewById(R.id.surface_view);
        SurfaceHolder holder = mySurfaceView.getHolder();
        holder.addCallback(mSurfaceListener);

        // センサーを取得する
        mySensor = (SensorManager)getSystemService(SENSOR_SERVICE);

        Button buttonOK = (Button)this.findViewById(R.id.buttonSave);
        buttonOK.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                buttonSave_onClick();
            }
        });

    }

    @Override
    public void onResume() {

        super.onResume();

        // 地磁気センサ
        mySensor.registerListener(mSensorEventListener,
                mySensor.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_UI);

        // 加速度センサ
        mySensor.registerListener(mSensorEventListener,
                mySensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        mySensor.unregisterListener(mSensorEventListener);
    }

    /**
     * 画面の向きを取得する(縦ならtrue)
     */
    private boolean isPortrait() {
        return (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT);
    }

    /**
     * 大きすぎない写真サイズを選択する(300万画素以下、4:3のもの)
     */
    private Size getOptimalPictureSize(List<Size> sizes) {

        double targetRatio = (double)4 / 3;

        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            int gasosu = size.width * size.height;
            if (gasosu < (300 * 10000) && Math.abs(ratio - targetRatio) < 0.1) {
                return size;
            }
        }

        return sizes.get(0);
    }

    /**
     * 写真サイズに近くて最も大きいプレビューサイズを選択する
     */
    private Size getOptimalPreviewSize(List<Size> sizes, int w, int h) {

        if (sizes == null) {
            return null;
        }

        double targetRatio = (double) w / h;

        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) < 0.1) {
                return size;
            }
        }

        return sizes.get(0);
    }

    /**
     * ラジアンで計測した角度を、相当する度に変換する
     */
    private int radianToDegree(float rad) {
        return (int) Math.floor(Math.toDegrees(rad));
    }

    /**
     * 画面タッチ時でオートフォーカス
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Camera.Parameters params = myCamera.getParameters();
            if (!params.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_FIXED)) {
                myCamera.autoFocus(mAutoFocusListener);
            }
        }
        return true;
    }

    /**
     * 写真保存
     */
    protected void buttonSave_onClick() {
        myCamera.takePicture(null, null, mPictureListener);
    }

}