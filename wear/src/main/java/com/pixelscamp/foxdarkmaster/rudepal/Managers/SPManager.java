package com.pixelscamp.foxdarkmaster.rudepal.Managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Fox Dark Master on 10/7/2016.
 */

public class SPManager {
    private static final String KEY_LOCALE = "locale";

    public static SharedPreferences getDefaultSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLocale(final Context context, final String locale) {
        SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
        editor.putString(KEY_LOCALE, locale).apply();
    }

    public static String getLocale(final Context context) {
        return getDefaultSharedPreferences(context)
                .getString(KEY_LOCALE, null);
    }
}
