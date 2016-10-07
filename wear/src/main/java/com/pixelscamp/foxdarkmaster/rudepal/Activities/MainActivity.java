package com.pixelscamp.foxdarkmaster.rudepal.Activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

import com.pixelscamp.foxdarkmaster.rudepal.Handler.DataTask;
import com.pixelscamp.foxdarkmaster.rudepal.R;
import com.pixelscamp.foxdarkmaster.rudepal.Utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements DataTask.IConnectionListener {

    private AsyncTask task;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    private void getDataFromServer() {
        if (Utils.isNetworkAvailable(this)) {
            task = new DataTask(this, DataTask.ACTIVITIES_GET, this);
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
