package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        // Check if user is already signed in
        if (isUserSignedIn()) {
            // Redirect to ChoiceActivity
            Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
            startActivity(intent);
            finish(); // Close MainActivity
        } else {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            Button welcomeButton = findViewById(R.id.button);
            welcomeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private boolean isUserSignedIn() {
        String userEmail = sharedPreferences.getString("current_user_email", null);
        return userEmail != null && databaseHelper.isUserSignedIn(userEmail);
    }
}
