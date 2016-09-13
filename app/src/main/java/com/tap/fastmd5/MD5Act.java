package com.tap.fastmd5;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.twmacinta.util.MD5;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MD5Act extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MD5Act";

    Button mFastMd5;

    Button mJavaMd5;

    Button mNativeMd5;

    TextView mReuslt;

    private Handler mHandler;

    final String PATH = "/sdcard/com.ilongyuan.implosion-102004000.apk";

    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        mFastMd5 = (Button) findViewById(R.id.fast_md5);
        mJavaMd5 = (Button) findViewById(R.id.java_md5);
        mNativeMd5 = (Button) findViewById(R.id.native_md5);

        mReuslt = (TextView) findViewById(R.id.md5_result);

        mFastMd5.setOnClickListener(this);
        mJavaMd5.setOnClickListener(this);
        mNativeMd5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fast_md5:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long t1 = System.currentTimeMillis();
                            byte[] hash = MD5.getHash(new File(PATH));
                            final String md5 = MD5.asHex(hash);
                            final long t2 = System.currentTimeMillis() - t1;
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    builder.append("fastmd5: " + md5 + " time: " + t2 + " ms \n");
                                    mReuslt.setText(builder.toString());
                                }
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.d(TAG, "run: ", e);
                        }
                    }
                }).start();
                break;
            case R.id.java_md5:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long t1 = System.currentTimeMillis();
                            final String md5 = JavaMd5.md5File(PATH, new AtomicBoolean(false));
                            final long t2 = System.currentTimeMillis() - t1;
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    builder.append("javamd5: " + md5 + " time: " + t2 + " ms \n");
                                    mReuslt.setText(builder.toString());
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d(TAG, "run: ", e);
                        }
                    }
                }).start();
                break;

            case R.id.native_md5:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long t1 = System.currentTimeMillis();
                            final String md5 = NativeMd5.md5(PATH);
                            final long t2 = System.currentTimeMillis() - t1;
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    builder.append("nativemd5: " + md5 + " time: " + t2 + " ms \n");
                                    mReuslt.setText(builder.toString());
                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d(TAG, "run: ", e);
                        }
                    }
                }).start();
                break;
        }
    }
}
