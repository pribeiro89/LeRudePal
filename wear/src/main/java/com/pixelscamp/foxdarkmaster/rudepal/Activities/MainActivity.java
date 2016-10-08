package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.pixelscamp.foxdarkmaster.rudepal.Handler.DataTask;
import com.pixelscamp.foxdarkmaster.rudepal.R;
import com.pixelscamp.foxdarkmaster.rudepal.Utils.Utils;

import org.json.JSONObject;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_main);

        ImageButton bnt_speech = (ImageButton) this.findViewById(R.id.button_main_speak);
        bnt_speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SpeechInputActivity.class);
                startActivity(intent);
            }

        });

        Button bnt_text = (Button) this.findViewById(R.id.button_main_text);
        bnt_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TextInputActivity.class);
            startActivity(intent);
        }

        });
    }

}
