package com.taylorngo.caloria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorResults extends AppCompatActivity {

    private TextView maintainCaloriesLabel;
    private TextView mildCalorieLoss;
    private TextView regularCalorieLoss;
    private TextView extremeCalorieLoss;
    private TextView mildCalorieGain;
    private TextView regularCalorieGain;
    private TextView extremeCalorieGain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_results);

        maintainCaloriesLabel = findViewById(R.id.maintainCalories);
        mildCalorieLoss = findViewById(R.id.mildCalorieLoss);
        regularCalorieLoss = findViewById(R.id.regularCalorieLoss);
        extremeCalorieLoss = findViewById(R.id.extremeCalorieLoss);
        mildCalorieGain = findViewById(R.id.mildCalorieGain);
        regularCalorieGain = findViewById(R.id.regularCalorieGain);
        extremeCalorieGain = findViewById(R.id.extremeCalorieGain);

        Intent intent = getIntent();
        String gender = intent.getStringExtra("GENDER");
        int weight = intent.getIntExtra("WEIGHT", 0);
        int feet = intent.getIntExtra("HEIGHT1", 0);
        int inches = intent.getIntExtra("HEIGHT2", 0);
        int age = intent.getIntExtra("AGE", 0);

        double height = ((feet * 12) + inches) * 2.54;
        double weightInKilos = weight / 2.205;
        double BMR = 0;
        if(gender.equals("M")){
            BMR = (10 * weightInKilos) + (6.25 * height) - (5 * age) + 5;
            BMR *= 1.5;
        }
        else {
            BMR = (10 * weightInKilos) + (6.25 * height) - (5 * age) - 161;
            BMR *= 1.5;
        }
        String caloriesEnding = " Calories/day";
        maintainCaloriesLabel.setText(((int) BMR) + caloriesEnding);
        mildCalorieLoss.setText(((int)(BMR * 0.9)) + caloriesEnding);
        regularCalorieLoss.setText(((int)(BMR * 0.8)) + caloriesEnding);
        extremeCalorieLoss.setText(((int)(BMR * 0.61)) + caloriesEnding);
        mildCalorieGain.setText(((int)(BMR * 1.1)) + caloriesEnding);
        regularCalorieGain.setText(((int)(BMR * 1.2)) + caloriesEnding);
        extremeCalorieGain.setText(((int)(BMR * 1.39)) + caloriesEnding);
    }
}