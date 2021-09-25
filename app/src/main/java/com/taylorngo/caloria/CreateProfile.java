package com.taylorngo.caloria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateProfile extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPreferences";

    private EditText nameInput;
    private EditText weightInput;
    private EditText heightInputFeet;
    private EditText heightInputInches;
    private RadioButton genderMale;
    private RadioButton genderFemale;
    private EditText ageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        nameInput = findViewById(R.id.nameInput);
        weightInput = findViewById(R.id.weightInput);
        heightInputFeet = findViewById(R.id.heightInput1);
        heightInputInches = findViewById(R.id.heightInput2);
        genderMale = findViewById(R.id.maleRadioButton);
        genderFemale = findViewById(R.id.femaleRadioButton);
        ageInput = findViewById(R.id.ageInput);

        Button submitButton = findViewById(R.id.submitProfileButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME", nameInput.getText().toString());
                editor.putInt("WEIGHT", Integer.parseInt(weightInput.getText().toString()));
                editor.putInt("HEIGHT1", Integer.parseInt(heightInputFeet.getText().toString()));
                editor.putInt("HEIGHT2", Integer.parseInt(heightInputInches.getText().toString()));
                String gender = null;
                if(genderMale.isChecked()){
                    gender = "Male";
                }
                else if(genderFemale.isChecked()){
                    gender = "Female";
                }
                editor.putString("GENDER", gender);
                editor.putInt("AGE", Integer.parseInt(ageInput.getText().toString()));
                editor.apply();
                finish();
            }
        });
    }
}