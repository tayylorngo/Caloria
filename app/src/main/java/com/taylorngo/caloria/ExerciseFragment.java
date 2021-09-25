package com.taylorngo.caloria;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
public class ExerciseFragment extends Fragment {

    private EditText caloriesInput;
    private Button generateExercisesButton;
    private CheckBox runningBox;
    private CheckBox swimmingBox;
    private CheckBox walkingBox;
    private CheckBox bikingBox;
    private CheckBox yogaBox;
    private CheckBox hikingBox;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        caloriesInput = view.findViewById(R.id.caloriesInput);
        generateExercisesButton = view.findViewById(R.id.generateButton);
        runningBox = view.findViewById(R.id.runningCheckbox);
        swimmingBox = view.findViewById(R.id.swimmingCheckbox);
        walkingBox = view.findViewById(R.id.walkingCheckbox);
        bikingBox = view.findViewById(R.id.bikingCheckbox);
        yogaBox = view.findViewById(R.id.yogaCheckbox);
        hikingBox = view.findViewById(R.id.hikingCheckbox);
        CheckBox[] listOfBoxes = new CheckBox[6];
        listOfBoxes[0] = runningBox;
        listOfBoxes[1] = swimmingBox;
        listOfBoxes[2] = walkingBox;
        listOfBoxes[3] = bikingBox;
        listOfBoxes[4] = yogaBox;
        listOfBoxes[5] = hikingBox;
        for(CheckBox box : listOfBoxes){
            box.setChecked(true);
        }

        generateExercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caloriesInput.getText().toString().equals("")){
                    return;
                }
                int calories = Integer.parseInt(caloriesInput.getText().toString());
                Intent intent = new Intent(getActivity(), ExercisesGenerated.class);
                intent.putExtra("CALORIES", calories);
                intent.putExtra("RUNNING", runningBox.isChecked());
                intent.putExtra("SWIMMING", swimmingBox.isChecked());
                intent.putExtra("WALKING", walkingBox.isChecked());
                intent.putExtra("BIKING", bikingBox.isChecked());
                intent.putExtra("YOGA", yogaBox.isChecked());
                intent.putExtra("HIKING", hikingBox.isChecked());
                startActivity(intent);
            }
        });




        return view;
    }
}
