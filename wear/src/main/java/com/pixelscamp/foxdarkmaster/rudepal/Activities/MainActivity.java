package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.pixelscamp.foxdarkmaster.rudepal.Handler.DataTask;
import com.pixelscamp.foxdarkmaster.rudepal.R;
import com.pixelscamp.foxdarkmaster.rudepal.Utils.Utils;

import org.json.JSONObject;

public class MainActivity extends Activity implements DataTask.IConnectionListener {

    private AsyncTask task;

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

    private void getDataFromServer() {
        if (Utils.isNetworkAvailable(this)) {
            task = new DataTask(this, DataTask.ASK_TRANSLATION, this);
            task.execute();
        }
    }

    @Override
    public void onPre() {
        // TODO Show progress bar
    }

    @Override
    public void onResult(JSONObject result) {
        Log.d(TAG, "DEBUG Result: " + result);

        //SPManager.setActivitiesByDay(this, 1, resultDay1);
        //setupData();
    }

    @Override
    public void onError(int code) {
        // TODO Hide progress bar
        Log.d(TAG, "DEBUG onError: " + code);

        //setupData();
    }
}
