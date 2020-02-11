package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Date;

public class Stopwatch extends AppCompatActivity {

    ImageButton start, finish;
    ImageView needle;
    Animation rounding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        start = findViewById(R.id.start);
        finish = findViewById(R.id.finish);
        needle = findViewById(R.id.needle);

        //Load animation
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needle.startAnimation(rounding);

            }
        });

    }

}
