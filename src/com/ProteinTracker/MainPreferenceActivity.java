package com.ProteinTracker;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jose.bermudez
 * Date: 3/13/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainPreferenceActivity extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }
}