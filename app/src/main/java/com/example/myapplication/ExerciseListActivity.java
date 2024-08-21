package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.HashMap;
import java.util.Map;

public class ExerciseListActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Map<String, String[][]> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        linearLayout = findViewById(R.id.linearLayout);

        exercises = new HashMap<>();
        exercises.put("Abs", new String[][]{
                {"Crunches", "A classic abdominal exercise.", "5 mins", "50 calories", "crunches"},
                {"Leg Raises", "Effective for lower abs.", "5 mins", "40 calories", "leg_raises"},
                {"Plank", "Strengthens the core.", "3 mins", "30 calories", "plank"},
                {"Bicycle Crunches", "Targets all areas of abs.", "4 mins", "45 calories", "bicycle_crunches"},
                {"Mountain Climbers", "Great for cardio and abs.", "5 mins", "60 calories", "mountain_climbers"}
        });
        exercises.put("Arms", new String[][]{
                {"Push-Ups", "Strengthens the chest and triceps.", "5 mins", "50 calories", "push_ups"},
                {"Bicep Curls", "Targets the biceps.", "5 mins", "40 calories", "bicep_curls"},
                {"Tricep Dips", "Great for triceps.", "4 mins", "35 calories", "tricep_dips"},
                {"Hammer Curls", "Works the forearms and biceps.", "5 mins", "40 calories", "hammer_curls"},
                {"Overhead Tricep Extension", "Targets the triceps.", "5 mins", "45 calories", "overhead_tricep_extension"}
        });
        exercises.put("Rear", new String[][]{
                {"Glute Bridges", "Strengthens the glutes.", "5 mins", "40 calories", "glute_bridges"},
                {"Donkey Kicks", "Targets the glutes.", "5 mins", "35 calories", "donkey_kicks"},
                {"Fire Hydrants", "Effective for the glutes.", "5 mins", "35 calories", "fire_hydrants"},
                {"Squats", "Works the glutes and legs.", "5 mins", "50 calories", "squats"},
                {"Lunges", "Great for glutes and thighs.", "5 mins", "45 calories", "lunges"}
        });
        exercises.put("Legs", new String[][]{
                {"Squats", "Strengthens the legs.", "5 mins", "50 calories", "squats"},
                {"Lunges", "Targets the thighs and glutes.", "5 mins", "45 calories", "lunges"},
                {"Calf Raises", "Works the calf muscles.", "4 mins", "30 calories", "calf_raises"},
                {"Leg Press", "Great for the entire leg.", "5 mins", "55 calories", "leg_press"},
                {"Leg Curls", "Targets the hamstrings.", "5 mins", "40 calories", "leg_curls"}
        });
        exercises.put("Back", new String[][]{
                {"Pull-Ups", "Strengthens the back and arms.", "5 mins", "50 calories", "pull_ups"},
                {"Deadlifts", "Works the lower back.", "5 mins", "60 calories", "deadlifts"},
                {"Superman", "Effective for the lower back.", "4 mins", "30 calories", "superman"},
                {"Bent Over Rows", "Targets the upper back.", "5 mins", "55 calories", "bent_over_rows"},
                {"Lat Pulldowns", "Great for the lats.", "5 mins", "50 calories", "lat_pulldowns"}
        });
        exercises.put("Chest", new String[][]{
                {"Bench Press", "Strengthens the chest.", "5 mins", "60 calories", "bench_press"},
                {"Push-Ups", "Works the chest and triceps.", "5 mins", "50 calories", "push_ups"},
                {"Chest Fly", "Targets the chest muscles.", "5 mins", "45 calories", "chest_fly"},
                {"Incline Bench Press", "Effective for upper chest.", "5 mins", "55 calories", "incline_bench_press"},
                {"Dumbbell Pullover", "Works the chest and back.", "5 mins", "50 calories", "dumbbell_pullover"}
        });

        String workoutType = getIntent().getStringExtra("WORKOUT_TYPE");
        if (workoutType != null && exercises.containsKey(workoutType)) {
            String[][] exerciseDetails = exercises.get(workoutType);
            for (String[] details : exerciseDetails) {
                addExerciseView(details[0], details[1], details[2], details[3], details[4]);
            }
        } else {
            Toast.makeText(this, "Workout type not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void addExerciseView(String name, String description, String time, String calories, String imageName) {
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 16, 16, 16);
        cardView.setLayoutParams(params);
        cardView.setCardBackgroundColor(getResources().getColor(R.color.cardBackgroundColor));
        cardView.setRadius(8);
        cardView.setCardElevation(8);

        LinearLayout cardLayout = new LinearLayout(this);
        cardLayout.setOrientation(LinearLayout.VERTICAL);
        cardLayout.setPadding(16, 16, 16, 16);

        ImageView imageView = new ImageView(this);
        int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(imageResId);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                400
        );
        imageView.setLayoutParams(imageParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView nameView = new TextView(this);
        nameView.setText(name);
        nameView.setTextSize(20);
        nameView.setTextColor(getResources().getColor(R.color.primaryTextColor));
        nameView.setTypeface(null, android.graphics.Typeface.BOLD);

        TextView descriptionView = new TextView(this);
        descriptionView.setText(String.format("Description: %s", description));
        descriptionView.setTextSize(16);
        descriptionView.setTextColor(getResources().getColor(R.color.secondaryTextColor));

        TextView timeView = new TextView(this);
        timeView.setText(String.format("Time: %s", time));
        timeView.setTextSize(16);
        timeView.setTextColor(getResources().getColor(R.color.secondaryTextColor));

        TextView caloriesView = new TextView(this);
        caloriesView.setText(String.format("Calories Burned: %s", calories));
        caloriesView.setTextSize(16);
        caloriesView.setTextColor(getResources().getColor(R.color.secondaryTextColor));

        cardLayout.addView(imageView);
        cardLayout.addView(nameView);
        cardLayout.addView(descriptionView);
        cardLayout.addView(timeView);
        cardLayout.addView(caloriesView);
        cardView.addView(cardLayout);

        linearLayout.addView(cardView);
    }
}
