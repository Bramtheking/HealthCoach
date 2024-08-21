package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        databaseHelper = new DatabaseHelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.signupPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        Button signUpText = findViewById(R.id.button3);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!name.matches("[a-zA-Z ]+")) {
            Toast.makeText(SignUpActivity.this, "Name can only contain letters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
            Toast.makeText(SignUpActivity.this, "Password must be at least 8 characters, include an uppercase letter, a lowercase letter, a number and a special character.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.addUser(name, email, password)) {
            Toast.makeText(SignUpActivity.this, "Registration successful.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this, ChoiceActivity.class));
        } else {
            Toast.makeText(SignUpActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
