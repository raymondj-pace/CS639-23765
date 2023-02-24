package com.example.imageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        constraintLayout = new ConstraintLayout(this);

        ImageView i = new ImageView(this);

        i.setImageResource(R.drawable.screen_shot_2022_05_27_at_8_32_40_am);
        i.setContentDescription(getResources().getString(R.string.freddys_name));

        i.setAdjustViewBounds(true);
        i.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        constraintLayout.addView(i);

        setContentView(constraintLayout);
 */
    }
}