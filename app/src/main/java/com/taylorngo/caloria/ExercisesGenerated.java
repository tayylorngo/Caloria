package com.taylorngo.caloria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;
public class ExercisesGenerated extends AppCompatActivity {

    private TextView exercise1;
    private TextView exercise2;
    private TextView exercise3;
    private TextView exercise4;
    private TextView exercise5;
    private TextView exercise6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_generated);

        exercise1 = findViewById(R.id.exercise1);
        exercise2 = findViewById(R.id.exercise2);
        exercise3 = findViewById(R.id.exercise3);
        exercise4 = findViewById(R.id.exercise4);
        exercise5 = findViewById(R.id.exercise5);
        exercise6 = findViewById(R.id.exercise6);

        TextView[] listOfExercises = new TextView[6];
        listOfExercises[0] = exercise1;
        listOfExercises[1] = exercise2;
        listOfExercises[2] = exercise3;
        listOfExercises[3] = exercise4;
        listOfExercises[4] = exercise5;
        listOfExercises[5] = exercise6;
        for(TextView text : listOfExercises){
            text.setText("");
        }
        int boxesChecked = 0;
        boolean RUNNING = getIntent().getBooleanExtra("RUNNING", false);
        boolean SWIMMING = getIntent().getBooleanExtra("SWIMMING", false);
        boolean WALKING = getIntent().getBooleanExtra("WALKING", false);
        boolean BIKING = getIntent().getBooleanExtra("BIKING", false);
        boolean YOGA = getIntent().getBooleanExtra("YOGA", false);
        boolean HIKING = getIntent().getBooleanExtra("HIKING", false);

        if(RUNNING) {boxesChecked++;};
        if(SWIMMING) {boxesChecked++;};
        if(WALKING) {boxesChecked++;};
        if(BIKING) {boxesChecked++;};
        if(YOGA) {boxesChecked++;};
        if(HIKING) {boxesChecked++;};

        int textBoxCounter = 0;
        Random rand = new Random();
        int calories = getIntent().getIntExtra("CALORIES", 0);

        for(int i = 0; i < boxesChecked; i++){
            if(RUNNING){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 10;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nRunning " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                RUNNING = false;
                textBoxCounter++;
                continue;
            }
            if(SWIMMING){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 10;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nSwimming " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                SWIMMING = false;
                textBoxCounter++;
                continue;
            }
            if(WALKING){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 7;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nWalking " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                WALKING = false;
                textBoxCounter++;
                continue;
            }
            if(BIKING){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 10;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nBiking " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                BIKING = false;
                textBoxCounter++;
                continue;
            }
            if(YOGA){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 5;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nYoga " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                YOGA = false;
                textBoxCounter++;
                continue;
            }
            if(HIKING){
                int randomNumber;
                if(i == boxesChecked - 1){
                    randomNumber = calories;
                }
                else {
                    randomNumber = rand.nextInt(calories / 2);
                }
                int minutes = randomNumber / 12;
                listOfExercises[i].setText("Exercise " + (i + 1) + ":\n\nRunning " + minutes + " minutes (" + randomNumber + " calories)");
                calories -= randomNumber;
                HIKING = false;
                textBoxCounter++;
            }
        }
    }
}