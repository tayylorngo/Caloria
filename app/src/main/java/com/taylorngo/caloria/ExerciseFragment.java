package com.taylorngo.caloria;

import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

public class ExerciseFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        JsonArray exercises = null;
        try {
            InputStream stream;
            stream = getContext().getAssets().open("exercises.json");
            Reader reader = new InputStreamReader(stream);
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
            exercises = (JsonArray) parser.get("exercises");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinearLayout ll = view.findViewById(R.id.linLayout);
        exercises.forEach(exercise -> {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout row = new LinearLayout(getContext());
            TextView name = new TextView(getContext());
            row.addView(name);
            ll.addView(row);
        });
        return view;
    }
}
