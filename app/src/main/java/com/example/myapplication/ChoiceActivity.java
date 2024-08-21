package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class ChoiceActivity extends AppCompatActivity {

    private MaterialCardView nutritionCard, workoutCard, sleepCard, stressCard, motivationCard, contactCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        nutritionCard = findViewById(R.id.nutritionCard);
        workoutCard = findViewById(R.id.workoutCard);
        sleepCard = findViewById(R.id.sleepCard);

        motivationCard = findViewById(R.id.motivationCard);
        contactCard = findViewById(R.id.contactCard);

        nutritionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(NutritionActivity.class);
            }
        });

        workoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(workout.class);
            }
        });

        sleepCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SleepActivity.class);
            }
        });



        motivationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MotivationActivity.class);
            }
        });

        contactCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Contact.class);
            }
        });
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(ChoiceActivity.this, activityClass);
        startActivity(intent);
    }
}
