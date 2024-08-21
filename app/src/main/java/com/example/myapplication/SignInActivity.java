package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView signUpPromptText;
    private DatabaseHelper databaseHelper;
    private SharedPreferences sharedPreferences;
    private TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        databaseHelper = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        usernameEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextText);
        signUpPromptText = findViewById(R.id.textView4);
        Button signInText = findViewById(R.id.button2);
         textView7 = findViewById(R.id.textView7);
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, ChoiceActivity.class));
            }
        });

        signUpPromptText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }


    private void signIn() {
        String email = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(SignInActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.checkUser(email, password)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("current_user_email", email);
            editor.apply();

            Toast.makeText(SignInActivity.this, "Authentication successful.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignInActivity.this, ChoiceActivity.class));
        } else {
            Toast.makeText(SignInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
