package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton gs;
    Animation atg;
    TextView stopwatchTimer, problemIs, timeYouHave, getStarted;
    ImageView clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gs = findViewById(R.id.getStart);
        stopwatchTimer = findViewById(R.id.stopwatchTxt);
        problemIs = findViewById(R.id.quote);
        timeYouHave = findViewById(R.id.quote2);
        getStarted = findViewById(R.id.btntext);
        clock = findViewById(R.id.clock);

        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Stopwatch.class);
                startActivity(i);
            }
        });
    }
}
