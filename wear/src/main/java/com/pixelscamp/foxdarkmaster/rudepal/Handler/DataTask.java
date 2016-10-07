package com.pixelscamp.foxdarkmaster.rudepal.Handler;

import android.content.Context;
import android.os.AsyncTask;

import com.pixelscamp.foxdarkmaster.rudepal.Activities.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox Dark Master on 10/6/2016.
 */

public class DataTask extends AsyncTask<Object, Void, JSONObject> {
    private static final String TAG = "DataTask";



    public interface IConnectionListener {
        void onPre();
        void onResult(JSONObject result);
        void onError(int code);
    }

    public static final int ASK_TRANSLATION = 00;
    public static final int GET_TRANSLATION = 01;
    public static final int ERROR_CONNECTING_TO_SERVER = 1000;

    private static final String[] METHODS = new String[] {
            "POST",
            "GET"
    };

    private static final String[][] SOURCES = new String[][]{
            new String[] { "ask_translation", "get_value" }
    };

    private IConnectionListener mListener;
    private int mRequest;
    private Context mContext;

    public DataTask(Context context, final int request, IConnectionListener listener){
        mContext = context;
        mRequest = request;
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        mListener.onPre();
    }

    @Override
    protected JSONObject doInBackground(Object... params) {
        int method = mRequest / 10;
        int source = mRequest % 10;

        JSONObject result;
        String requestParams = null;

        if (params != null && params.length > 0) {
            requestParams = paramsBuilder(params);
        }

        result = ServerConnection.request(
                mContext,
                null,
                METHODS[method],
                SOURCES[method][source],
                requestParams
        );

        if (result == null) {
            cancel(true);
        }

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        if (jsonObject.has("error")) {
            try {
                JSONObject error = jsonObject.getJSONObject("error");

                if (error.getString("error").equals("unauthorized")) {
                    mListener.onError(1);
                } else {
                    mListener.onError(0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            /*
            } else if (jsonObject.has("data")) {
                mListener.onResult(jsonObject);
            } else if (jsonObject.has("2016-08-20") && jsonObject.has("2016-08-21")) {
                mListener.onResult(jsonObject);
            */

        } else {
            // TODO ADD DATA TO LISTENER
            //mListener.onError(500);
        }
    }

    @Override
    protected void onCancelled(JSONObject jsonObject) {
        if (jsonObject == null) {
            mListener.onError(ERROR_CONNECTING_TO_SERVER);
        } else {
            mListener.onError(0);
        }
    }

    private String paramsBuilder(Object... params){
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (Object param : params) {
            count++;

            if (param instanceof String) {
                builder.append(param);

                if (count < params.length) {
                    builder.append(';');
                }
            } else {
                cancel(true);
            }
        }

        return builder.toString();
    }
}
