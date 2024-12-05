package com.sultanayubi.discretescrollviewlibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class DiscreteScrollViewOptions {

    private static DiscreteScrollViewOptions instance;
    private static Context appContext; // Store the application context

    private final String KEY_TRANSITION_TIME;

    public static void init(Context context) {
        appContext = context.getApplicationContext(); // Use application context
        instance = new DiscreteScrollViewOptions(context);
    }

    private DiscreteScrollViewOptions(Context context) {
        KEY_TRANSITION_TIME = context.getString(R.string.pref_key_transition_time);
    }

    public static int getTransitionTime() {
        return defaultPrefs().getInt(instance.KEY_TRANSITION_TIME, 150);
    }

    private static SharedPreferences defaultPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }
}
