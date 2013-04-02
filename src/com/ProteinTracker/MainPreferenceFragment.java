package com.ProteinTracker;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created with IntelliJ IDEA.
 * User: jose.bermudez
 * Date: 3/12/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}