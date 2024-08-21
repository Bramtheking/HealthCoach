package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Contact extends AppCompatActivity {

    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String message = messageEditText.getText().toString();
        String recipient = "bramwela8@gmail.com";

        if (!message.isEmpty()) {
            new SendMailTask(recipient, "Contact Us Message", message).execute();
            Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Message cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
