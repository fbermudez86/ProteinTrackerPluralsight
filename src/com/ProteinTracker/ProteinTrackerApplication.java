package com.ProteinTracker;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created with IntelliJ IDEA.
 * User: jose.bermudez
 * Date: 3/12/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProteinTrackerApplication extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("test","testValue");
        editor.commit();

    }
}
