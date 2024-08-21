package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SleepActivity extends AppCompatActivity {

    private TextView dayTextView, timeTextView;
    private Button startSleepButton, breakSleepButton, stopSleepButton;

    private long startTime = 0L;
    private long pauseTime = 0L;
    private long totalTime = 0L;
    private Handler handler = new Handler();
    private Runnable updateTimerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);

        dayTextView = findViewById(R.id.dayTextView);
        timeTextView = findViewById(R.id.timeTextView);
        startSleepButton = findViewById(R.id.startSleepButton);
        breakSleepButton = findViewById(R.id.breakSleepButton);
        stopSleepButton = findViewById(R.id.stopSleepButton);

        // Set current day and time
        String currentDay = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
        dayTextView.setText(currentDay);
        timeTextView.setText(currentTime);

        startSleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSleepTracking();
            }
        });

        breakSleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breakSleepTracking();
            }
        });

        stopSleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSleepTracking();
            }
        });

        updateTimerThread = new Runnable() {
            public void run() {
                long time = SystemClock.uptimeMillis() - startTime + totalTime;
                // Optionally update a UI element with the elapsed time here
                handler.postDelayed(this, 1000);
            }
        };
    }

    private void startSleepTracking() {
        if (pauseTime != 0L) {
            startTime = SystemClock.uptimeMillis() - (pauseTime - startTime);
        } else {
            startTime = SystemClock.uptimeMillis();
        }
        handler.postDelayed(updateTimerThread, 0);
        Toast.makeText(this, "Sleep started", Toast.LENGTH_SHORT).show();
    }

    private void breakSleepTracking() {
        pauseTime = SystemClock.uptimeMillis();
        totalTime += pauseTime - startTime;
        handler.removeCallbacks(updateTimerThread);
        Toast.makeText(this, "Sleep paused", Toast.LENGTH_SHORT).show();
    }

    private void stopSleepTracking() {
        handler.removeCallbacks(updateTimerThread);
        long endTime = SystemClock.uptimeMillis();
        totalTime += endTime - startTime;

        Intent intent = new Intent(this, SleepQualityActivity.class);
        intent.putExtra("startTime", startTime);
        intent.putExtra("endTime", endTime);
        intent.putExtra("totalTime", totalTime);
        startActivity(intent);
        Toast.makeText(this, "Sleep stopped", Toast.LENGTH_SHORT).show();
    }
}
