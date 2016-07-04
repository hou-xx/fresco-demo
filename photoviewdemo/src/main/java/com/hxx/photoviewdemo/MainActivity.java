package com.hxx.photoviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {
    private PhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhotoView = (PhotoView) findViewById(R.id.photoview);
        mPhotoView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
    }
}
