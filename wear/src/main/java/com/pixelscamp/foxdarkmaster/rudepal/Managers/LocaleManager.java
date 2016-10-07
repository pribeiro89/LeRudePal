package com.pixelscamp.foxdarkmaster.rudepal.Managers;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import java.util.Locale;

/**
 * Created by Fox Dark Master on 10/7/2016.
 */

public class LocaleManager {
    public static void loadLocale(Context context) {
        if (getCurrentLocale(context).startsWith("pt")){
            setLocale(context, "pt");
        } else {
            setLocale(context, "en");
        }

    }

    private static void setLocale(Context context, String locale){
        SPManager.setLocale(context, locale);

        Configuration cfg = new Configuration();
        Locale loc = new Locale(locale);

        cfg.setLocale(loc);
        Locale.setDefault(loc);
        context.getResources().updateConfiguration(cfg, null);
    }

    public static String getCurrentLocale(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return context
                    .getResources()
                    .getConfiguration()
                    .getLocales()
                    .toString();
        } else {
            return context
                    .getResources()
                    .getConfiguration()
                    .locale
                    .toString();
        }

    }
}

