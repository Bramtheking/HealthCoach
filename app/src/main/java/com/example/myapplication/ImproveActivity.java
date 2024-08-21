package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ImproveActivity extends AppCompatActivity {

    private TextView sleepDurationValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);

        sleepDurationValue = findViewById(R.id.sleepDurationValue);

        // Retrieve sleep data from intent
        Intent intent = getIntent();
        long totalTime = intent.getLongExtra("totalTime", 0L);

        // Format and display sleep duration
        String sleepDuration = formatDuration(totalTime);
        sleepDurationValue.setText(sleepDuration);
    }

    private String formatDuration(long duration) {
        long hours = duration / (60 * 60 * 1000);
        long minutes = (duration % (60 * 60 * 1000)) / (60 * 1000);
        return String.format(Locale.getDefault(), "%dh %dm", hours, minutes);
    }
}
