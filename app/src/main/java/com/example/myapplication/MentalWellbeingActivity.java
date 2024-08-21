package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MentalWellbeingActivity extends AppCompatActivity {

    private Spinner spinnerIssues;
    private TextView tvResponse;
    private TextView tvQuote;
    private Button btnSubmit;
    private Map<String, String> adviceMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mental_wellbeing);

        spinnerIssues = findViewById(R.id.spinnerIssues);
        tvResponse = findViewById(R.id.tvResponse);
        tvQuote = findViewById(R.id.tvQuote);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Populate advice map with various issues and responses
        adviceMap = new HashMap<>();
        adviceMap.put("Stress", "Consider practicing mindfulness or meditation to reduce stress.");
        adviceMap.put("Anxiety", "Regular physical exercise can help manage anxiety. Try to stay active.");
        adviceMap.put("Sleep", "Establish a regular sleep schedule and create a relaxing bedtime routine.");
        adviceMap.put("Mood", "Connecting with friends and family can improve your mood and provide support.");
        adviceMap.put("Depression", "Seek support from a mental health professional. You're not alone.");
        adviceMap.put("Fatigue", "Ensure you are getting enough sleep and maintaining a balanced diet.");
        adviceMap.put("Motivation", "Set small, achievable goals to keep yourself motivated.");
        adviceMap.put("Focus", "Minimize distractions and take regular breaks to stay focused.");
        adviceMap.put("Procrastination", "Break tasks into smaller steps to make them more manageable.");
        adviceMap.put("Self-Esteem", "Practice self-compassion and challenge negative self-talk.");
        adviceMap.put("Burnout", "Take time to rest and recharge. It's okay to take breaks.");
        adviceMap.put("Anger", "Practice deep breathing techniques to manage your anger.");
        adviceMap.put("Loneliness", "Reach out to friends and family or join social groups to connect with others.");
        adviceMap.put("Grief", "Allow yourself to feel your emotions and seek support from loved ones.");
        adviceMap.put("PTSD", "Consider seeking professional help to manage PTSD symptoms.");
        adviceMap.put("Social Anxiety", "Gradually expose yourself to social situations to build confidence.");
        adviceMap.put("Eating Disorders", "Seek support from a healthcare professional specializing in eating disorders.");
        adviceMap.put("Work-Life Balance", "Set boundaries between work and personal life to maintain balance.");
        adviceMap.put("Relationship Issues", "Open communication with your partner can help resolve issues.");
        adviceMap.put("Substance Abuse", "Seek professional help to address substance abuse issues.");

        // Set a random quote of the day
        String[] quotesArray = getResources().getStringArray(R.array.quotes_array);
        String quoteOfTheDay = quotesArray[new Random().nextInt(quotesArray.length)];
        tvQuote.setText(quoteOfTheDay);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedIssue = spinnerIssues.getSelectedItem().toString();
                provideAdvice(selectedIssue);
            }
        });
    }

    private void provideAdvice(String query) {
        String response = adviceMap.get(query);
        if (response != null) {
            tvResponse.setText(response);
        } else {
            tvResponse.setText("Sorry, I don't have advice for that. Try another query.");
        }
    }
}
