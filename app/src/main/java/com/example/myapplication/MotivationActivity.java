package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MotivationActivity extends AppCompatActivity {

    private TextView tvDate;
    private TextView tvQuote;
    private Spinner spinnerIssues;
    private TextView tvSuggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation);

        tvDate = findViewById(R.id.tvDate);
        tvQuote = findViewById(R.id.tvQuote);
        spinnerIssues = findViewById(R.id.spinnerIssues);
        tvSuggestion = findViewById(R.id.tvSuggestion);

        // Get current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());
        tvDate.setText(currentDate);

        // Get quotes array
        String[] quotes = getResources().getStringArray(R.array.quotes_array);

        // Display quote based on the day of the week
        tvQuote.setText(quotes[new Date().getDay()]);

        // Set up spinner for mental issues
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.issues_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIssues.setAdapter(adapter);

        // Set up listener for spinner selection
        spinnerIssues.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] suggestions = getResources().getStringArray(R.array.suggestions_array);
                tvSuggestion.setText(suggestions[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSuggestion.setText("");
            }
        });
    }
}
