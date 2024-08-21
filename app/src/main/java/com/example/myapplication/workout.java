package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class workout extends AppCompatActivity {

    private MaterialCardView absCard, armsCard, rearCard, legsCard, backCard, chestCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout);

        absCard = findViewById(R.id.absCard);
        armsCard = findViewById(R.id.armsCard);
        rearCard = findViewById(R.id.rearCard);
        legsCard = findViewById(R.id.legsCard);
        backCard = findViewById(R.id.backCard);
        chestCard = findViewById(R.id.chestCard);

        absCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Abs");
            }
        });

        armsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Arms");
            }
        });

        rearCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Rear");
            }
        });

        legsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Legs");
            }
        });

        backCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Back");
            }
        });

        chestCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseListActivity("Chest");
            }
        });
    }

    private void openExerciseListActivity(String workoutType) {
        Intent intent = new Intent(workout.this, ExerciseListActivity.class);
        intent.putExtra("WORKOUT_TYPE", workoutType);
        startActivity(intent);
    }
}
