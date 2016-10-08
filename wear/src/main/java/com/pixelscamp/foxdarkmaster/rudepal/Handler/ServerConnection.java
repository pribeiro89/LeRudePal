package com.pixelscamp.foxdarkmaster.rudepal.Handler;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import com.pixelscamp.foxdarkmaster.rudepal.Managers.LocaleManager;
import com.pixelscamp.foxdarkmaster.rudepal.Managers.SPManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Fox Dark Master on 10/6/2016.
 */

public class ServerConnection {
    private final static int TIMEOUT = 20000;
    public final static String SERVER_URL = "https://sandbox.unbabel.com/tapi/v2/mt_translation/";
    public final static String SERVER_USER = "pixels.camp.163";
    public final static String SERVER_KEY = "5c02b9d30f3e497825bc39910b5bdca39a28f27b";


    private static final String TAG = "ServerConnection";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static String queryBuilder(String token, String method, String source, String param){
        //final String formattedDate = dateFormat.format(new Date());

        return method + "/" + source;
        //+ ":"
        //+ formattedDate
        //+ (token != null ? ":" + token : "" )
        //+ "#"
        //+ (param != null ? param : "");
    }

    private static String urlBuilder(String locale){
        /*
        return SERVER_URL +
                "/" +
                locale +
                "/2016/";
        */
        return SERVER_URL + "/pt/2016/mobile/actividades_evento/";
    }

    private static JSONObject post(Context context, final String query){
        String locale = LocaleManager.getCurrentLocale(context);
        //String locale = "pt";

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();

        RequestBody requestBody = new FormBody.Builder()
                .add("q", query)
                .build();

        Request request = new Request.Builder()
                .url(urlBuilder(locale))
                .post(requestBody)
                .addHeader("Accept-Language", SPManager.getLocale(context))
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();

            Log.d(TAG, "EXECUTING REQUEST: \n"
                    + "SERVER URL: " + urlBuilder(locale) + "\n"
                    + "REQUEST: " + query + "\n"
                    + "RESULT: " + responseString);

            return new JSONObject(responseString);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject request(Context context, String token, String method, String source, String param){
        String query = queryBuilder(token, method, source, param);

        return post(context, query);
    }
}

