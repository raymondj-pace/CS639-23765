package com.example.asynctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncTaskImgDownloader imgDownLoader = new AsyncTaskImgDownloader(this);

        String img_size = getString(R.string.image_size);
        imgDownLoader.execute("https://picsum.photos/" + img_size);

        // https://picksum.photos/200 add /300 for height or .jpg
    }
}