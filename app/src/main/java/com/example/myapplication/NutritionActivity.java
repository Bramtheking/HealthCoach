package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class NutritionActivity extends AppCompatActivity {

    private EditText searchEditText, foodItemEditText;
    private TextView caloriesTextView, benefitsTextView, totalCaloriesTextView;
    private Button searchButton, addButton;

    private HashMap<String, Integer> foodCalories;
    private HashMap<String, String> foodBenefits;
    private int totalCalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);

        searchEditText = findViewById(R.id.searchEditText);
        foodItemEditText = findViewById(R.id.foodItemEditText);
        caloriesTextView = findViewById(R.id.caloriesTextView);
        benefitsTextView = findViewById(R.id.benefitsTextView);
        totalCaloriesTextView = findViewById(R.id.totalCaloriesTextView);
        searchButton = findViewById(R.id.searchButton);
        addButton = findViewById(R.id.addButton);

        initializeFoodData();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFood();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFoodToCalculator();
            }
        });
    }

    private void initializeFoodData() {
        foodCalories = new HashMap<>();
        foodBenefits = new HashMap<>();

        // Sample data, replace with actual data
        foodCalories.put("Apple", 52);
        foodBenefits.put("Apple", "Rich in dietary fiber, vitamins, and antioxidants.");

        foodCalories.put("Banana", 96);
        foodBenefits.put("Banana", "High in potassium and good for digestion.");
        foodCalories.put("Orange", 47);
        foodBenefits.put("Orange", "Excellent source of vitamin C and fiber.");

        foodCalories.put("Strawberry", 32);
        foodBenefits.put("Strawberry", "Rich in vitamins, fiber, and antioxidants.");

        foodCalories.put("Grapes", 69);
        foodBenefits.put("Grapes", "Contains vitamins C and K, antioxidants, and anti-inflammatory properties.");

        foodCalories.put("Watermelon", 30);
        foodBenefits.put("Watermelon", "Hydrating and rich in vitamins A and C.");

        foodCalories.put("Pineapple", 50);
        foodBenefits.put("Pineapple", "High in vitamins, enzymes, and antioxidants.");

        foodCalories.put("Mango", 60);
        foodBenefits.put("Mango", "Rich in vitamins A and C, and has digestive enzymes.");

        foodCalories.put("Blueberry", 57);
        foodBenefits.put("Blueberry", "High in antioxidants and vitamins C and K.");

        foodCalories.put("Cherry", 50);
        foodBenefits.put("Cherry", "Rich in vitamins, minerals, and antioxidants.");

        foodCalories.put("Peach", 39);
        foodBenefits.put("Peach", "High in vitamins A and C, and dietary fiber.");

        foodCalories.put("Kiwi", 61);
        foodBenefits.put("Kiwi", "Rich in vitamins C, K, and E, and antioxidants.");

        foodCalories.put("Pear", 57);
        foodBenefits.put("Pear", "Good source of dietary fiber and vitamin C.");

        foodCalories.put("Plum", 46);
        foodBenefits.put("Plum", "Rich in vitamins C and K, and antioxidants.");

        foodCalories.put("Raspberry", 52);
        foodBenefits.put("Raspberry", "High in fiber, vitamins C and K, and antioxidants.");

        foodCalories.put("Cantaloupe", 34);
        foodBenefits.put("Cantaloupe", "High in vitamins A and C, and hydration.");

        foodCalories.put("Grapefruit", 42);
        foodBenefits.put("Grapefruit", "Rich in vitamins A and C, and antioxidants.");

        foodCalories.put("Pomegranate", 83);
        foodBenefits.put("Pomegranate", "High in vitamins, antioxidants, and anti-inflammatory properties.");

        foodCalories.put("Papaya", 43);
        foodBenefits.put("Papaya", "Rich in vitamins A and C, and digestive enzymes.");

        foodCalories.put("Lemon", 29);
        foodBenefits.put("Lemon", "High in vitamin C, aids in digestion and hydration.");

        foodCalories.put("Apricot", 48);
        foodBenefits.put("Apricot", "High in vitamins A and C, and dietary fiber.");

        foodCalories.put("Blackberry", 43);
        foodBenefits.put("Blackberry", "Rich in vitamins C and K, and antioxidants.");

        foodCalories.put("Coconut", 354);
        foodBenefits.put("Coconut", "Rich in fiber, vitamins, and minerals, and provides healthy fats.");

        foodCalories.put("Date", 282);
        foodBenefits.put("Date", "High in fiber, vitamins, and minerals, and provides quick energy.");

        foodCalories.put("Fig", 74);
        foodBenefits.put("Fig", "Rich in vitamins and minerals, and promotes digestive health.");

        foodCalories.put("Guava", 68);
        foodBenefits.put("Guava", "High in vitamins C and A, and antioxidants.");

        foodCalories.put("Lychee", 66);
        foodBenefits.put("Lychee", "Rich in vitamins C and B6, and antioxidants.");

        foodCalories.put("Mandarin", 53);
        foodBenefits.put("Mandarin", "High in vitamins A and C, and antioxidants.");

        foodCalories.put("Nectarine", 44);
        foodBenefits.put("Nectarine", "Rich in vitamins A and C, and dietary fiber.");

        foodCalories.put("Olive", 115);
        foodBenefits.put("Olive", "High in healthy fats, vitamins, and antioxidants.");

        foodCalories.put("Passion Fruit", 97);
        foodBenefits.put("Passion Fruit", "Rich in vitamins A and C, and dietary fiber.");

        foodCalories.put("Persimmon", 81);
        foodBenefits.put("Persimmon", "High in vitamins A and C, and dietary fiber.");

        foodCalories.put("Quince", 57);
        foodBenefits.put("Quince", "Rich in vitamins C and B, and antioxidants.");

        foodCalories.put("Rambutan", 68);
        foodBenefits.put("Rambutan", "High in vitamins C and B3, and antioxidants.");

        foodCalories.put("Starfruit", 31);
        foodBenefits.put("Starfruit", "Rich in vitamins C and B, and antioxidants.");

        foodCalories.put("Tangerine", 53);
        foodBenefits.put("Tangerine", "High in vitamins A and C, and dietary fiber.");

        foodCalories.put("Ugli Fruit", 47);
        foodBenefits.put("Ugli Fruit", "Rich in vitamins A and C, and antioxidants.");

        foodCalories.put("Cucumber", 16);
        foodBenefits.put("Cucumber", "High in vitamins K and C, and hydration.");

        foodCalories.put("Tomato", 18);
        foodBenefits.put("Tomato", "Rich in vitamins C and K, and antioxidants.");

        foodCalories.put("Carrot", 41);
        foodBenefits.put("Carrot", "High in vitamins A and K, and antioxidants.");

        foodCalories.put("Broccoli", 55);
        foodBenefits.put("Broccoli", "Rich in vitamins C and K, and fiber.");

        foodCalories.put("Spinach", 23);
        foodBenefits.put("Spinach", "High in vitamins A, C, and K, and antioxidants.");

        foodCalories.put("Potato", 77);
        foodBenefits.put("Potato", "Rich in vitamins C and B6, and potassium.");


    }

    private void searchFood() {
        String food = searchEditText.getText().toString().trim();
        if (foodCalories.containsKey(food)) {
            int calories = foodCalories.get(food);
            String benefits = foodBenefits.get(food);

            caloriesTextView.setText("Calories: " + calories);
            benefitsTextView.setText("Benefits: " + benefits);
        } else {
            caloriesTextView.setText("Calories: Not found");
            benefitsTextView.setText("Benefits: Not found");
        }
    }

    private void addFoodToCalculator() {
        String foodInput = foodItemEditText.getText().toString().trim();
        String[] foods = foodInput.split("\\+|\\band\\b");

        int addedCalories = 0;
        StringBuilder foodNotFound = new StringBuilder();

        for (String food : foods) {
            String trimmedFood = food.trim();
            if (foodCalories.containsKey(trimmedFood)) {
                int calories = foodCalories.get(trimmedFood);
                addedCalories += calories;
            } else {
                if (foodNotFound.length() > 0) {
                    foodNotFound.append(", ");
                }
                foodNotFound.append(trimmedFood);
            }
        }

        totalCalories += addedCalories;

        if (addedCalories > 0) {
            totalCaloriesTextView.setText("Total Calories: " + totalCalories);
        } else {
            totalCaloriesTextView.setText("Total Calories: Food not found - " + foodNotFound.toString());
        }
    }

}
