package com.example.asynctest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        AsyncTaskImgDownloader imgDownLoader = new AsyncTaskImgDownloader(this);

        String img_size = getString(R.string.image_size);
        imgDownLoader.execute("https://picsum.photos/" + img_size);

        // Find the View that shows the numbers category
        Button btn = (Button) findViewById(R.id.reload_button);


        // Set a click listener on that View
        btn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent randomImage = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(randomImage);
            }
        });

        // https://picksum.photos/200 add /300 for height or .jpg
    }

    public static Resources getRes() {
        return res;
    }
}