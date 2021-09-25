package com.taylorngo.caloria;

import static android.content.Context.MODE_PRIVATE;

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

import org.jetbrains.annotations.NotNull;

public class SettingsFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable


    public static final String SHARED_PREFS = "sharedPreferences";

    private EditText weightInput;
    private EditText heightInputFeet;
    private EditText heightInputInches;
    private RadioButton genderMale;
    private RadioButton genderFemale;
    private EditText ageInput;

    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        weightInput = view.findViewById(R.id.editWeight);
        heightInputFeet = view.findViewById(R.id.editHeight1);
        heightInputInches = view.findViewById(R.id.editHeight2);
        genderMale = view.findViewById(R.id.toggleMale);
        genderFemale = view.findViewById(R.id.toggleFemale);
        ageInput = view.findViewById(R.id.editAge);
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        weightInput.setText(String.valueOf(sharedPreferences.getInt("WEIGHT",0)));
        heightInputFeet.setText(String.valueOf(sharedPreferences.getInt("HEIGHT1",0)));
        heightInputInches.setText(String.valueOf(sharedPreferences.getInt("HEIGHT2",0)));
        ageInput.setText(String.valueOf(sharedPreferences.getInt("AGE",0)));
        String gender = sharedPreferences.getString("GENDER", "Male");
        if (gender.equals("Male")){
            genderMale.setChecked(true);
        }
        else{
            genderFemale.setChecked(true);
        }
        Button submitButton = view.findViewById(R.id.buttonUpdate);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
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
            }
        });
        return view;
    }
}
