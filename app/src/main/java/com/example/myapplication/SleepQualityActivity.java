package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SleepQualityActivity extends AppCompatActivity {

    private TextView dateTextView, dateDetailTextView;
    private TextView sleepQualityTextView, sleepDurationTextView;
    private TextView deepSleepTextView, wentToBedTextView, wokeUpTextView;
    private Button waysToImproveButton;

    private long startTime, endTime, totalTime;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep2);

        dateTextView = findViewById(R.id.dateTextView);
        dateDetailTextView = findViewById(R.id.dateDetailTextView);
        sleepQualityTextView = findViewById(R.id.sleepQualityTextView);
        sleepDurationTextView = findViewById(R.id.sleepDurationTextView);
        deepSleepTextView = findViewById(R.id.deepSleepTextView);
        wentToBedTextView = findViewById(R.id.wentToBedTextView);
        wokeUpTextView = findViewById(R.id.wokeUpTextView);
        waysToImproveButton = findViewById(R.id.waysToImproveButton);

        // Set current date
        String currentDay = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        String currentDate = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
        dateTextView.setText("Today, " + currentDay);
        dateDetailTextView.setText(currentDate);

        Intent intent = getIntent();
        startTime = intent.getLongExtra("startTime", 0L);
        endTime = intent.getLongExtra("endTime", 0L);
        totalTime = intent.getLongExtra("totalTime", 0L);

        long sleepDuration = totalTime;
        long deepSleepDuration = (long) (sleepDuration * 0.4);

        double sleepQuality = Math.min((sleepDuration / (8.0 * 60 * 60 * 1000)) * 100, 100);
        sleepQualityTextView.setText(String.format(Locale.getDefault(), "Sleep Quality: %.0f%%", sleepQuality));
        sleepDurationTextView.setText("Sleep Duration: " + formatDuration(sleepDuration));
        deepSleepTextView.setText("Deep Sleep: " + formatDuration(deepSleepDuration));
        wentToBedTextView.setText("Went to Bed: " + timeFormat.format(new Date(startTime)));
        wokeUpTextView.setText("Woke Up: " + timeFormat.format(new Date(endTime)));

        waysToImproveButton.setOnClickListener(v -> {
            Intent improveIntent = new Intent(this, ImproveActivity.class);
            startActivity(improveIntent);
        });
    }

    private String formatDuration(long duration) {
        long hours = duration / (60 * 60 * 1000);
        long minutes = (duration % (60 * 60 * 1000)) / (60 * 1000);
        return String.format(Locale.getDefault(), "%dh %dm", hours, minutes);
    }
}
