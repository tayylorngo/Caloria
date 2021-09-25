package com.taylorngo.caloria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private RadioButton genderMale;
    private RadioButton genderFemale;
    private EditText weightInput;
    private EditText heightInputFeet;
    private EditText heightInputInches;
    private EditText ageInput;
    private Button calculateButton;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        genderMale = view.findViewById(R.id.maleRadioButtonCalc);
        genderFemale = view.findViewById(R.id.femaleRadioButtonCalc);
        weightInput = view.findViewById(R.id.weightInputCalc);
        heightInputFeet = view.findViewById(R.id.heightInput1Calc);
        heightInputInches = view.findViewById(R.id.heightInput2Calc);
        ageInput = view.findViewById(R.id.ageInputCalc);
        calculateButton = view.findViewById(R.id.calculateCalories);

        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(MainActivity.SHARED_PREFS, Context.MODE_PRIVATE);
        genderMale.setChecked(sharedPreferences.getString("GENDER", null).equals("Male"));
        genderFemale.setChecked(sharedPreferences.getString("GENDER", null).equals("Female"));
        weightInput.setText("" + sharedPreferences.getInt("WEIGHT", 0));
        heightInputFeet.setText("" + sharedPreferences.getInt("HEIGHT1", 0));
        heightInputInches.setText("" + sharedPreferences.getInt("HEIGHT2", 0));
        ageInput.setText("" + sharedPreferences.getInt("AGE", 0));

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CalculatorResults.class);
                if(genderMale.isChecked()){
                    intent.putExtra("GENDER", "M");
                }
                else {
                    intent.putExtra("GENDER", "F");
                }
                intent.putExtra("WEIGHT", Integer.parseInt(weightInput.getText().toString()));
                intent.putExtra("HEIGHT1", Integer.parseInt(heightInputFeet.getText().toString()));
                intent.putExtra("HEIGHT2", Integer.parseInt(heightInputInches.getText().toString()));
                intent.putExtra("AGE", Integer.parseInt(ageInput.getText().toString()));
                startActivity(intent);
            }
        });

        return view;
    }
}
