package com.taylorngo.caloria;

import android.content.Context;
import android.content.res.AssetManager;
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
import org.w3c.dom.Text;

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

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext=context;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
//        JsonArray exercises = null;
//        AssetManager am = mContext.getAssets();
//        String[] assets = null;
//        try {
//            assets = am.list("");
//            for(int i = 0; i < assets.length; i++) {
//                System.out.println(assets[i]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            InputStream stream;
//            stream = am.open("exercises.json");
//            Reader reader = new InputStreamReader(stream);
//            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
//            exercises = (JsonArray) parser.get("exercises");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LinearLayout ll = view.findViewById(R.id.linLayout);
//        exercises.forEach(exercise -> {
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            LinearLayout row ;
//            TextView name = new TextView(getContext());
//            name.setLayoutParams(new LinearLayout.LayoutParams(params));
//            name.setText("test");
//            //row.addView(name,params);
//            TextView n = new TextView(getContext());
//            TextView c = new TextView(getContext());
//            TextView s = new TextView(getContext());
//            ll.addView(row);
//            ll.addView(name);
//        });

        return view;
    }
}
