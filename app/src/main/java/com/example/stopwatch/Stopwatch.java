package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Stopwatch extends AppCompatActivity {

    ImageButton start, finish;
    ImageView needle;
    Animation rounding, rounding2;
    TextView finishtxt, startTxt;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        start = findViewById(R.id.start);
        startTxt = findViewById(R.id.starttxt);
        finish = findViewById(R.id.finish);
        finishtxt = findViewById(R.id.finishtxt);
        needle = findViewById(R.id.needle);
        timer = findViewById(R.id.timer);

        //Load animation
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);
        rounding2 = AnimationUtils.loadAnimation(this, R.anim.rounding2);

        finish.setVisibility(View.GONE);
        finishtxt.setVisibility(View.GONE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needle.startAnimation(rounding);
                finish.setVisibility(View.VISIBLE);
                finishtxt.setVisibility(View.VISIBLE);
                start.setVisibility(View.GONE);
                startTxt.setVisibility(View.GONE);

                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needle.startAnimation(rounding2);
                finish.setVisibility(View.GONE);
                finishtxt.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                startTxt.setVisibility(View.VISIBLE);

                timer.stop();


            }
        });

    }

    private void showElapsedTime() {
        int elapsedMillis = (int) (SystemClock.elapsedRealtime() - 10*1000);
        Toast.makeText(Stopwatch.this, "Elapsed milliseconds: " + elapsedMillis,
                Toast.LENGTH_SHORT).show();
    }

}
