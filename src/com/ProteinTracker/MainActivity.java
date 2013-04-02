package com.ProteinTracker;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {


    //region Listener properties
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, MainPreferenceActivity.class));
        }
    };
    private View.OnClickListener resetButtonListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment confirmResetDialogFragment = ConfirmResetDialogFragment.newInstance(R.string.resetDialogMessage);
            confirmResetDialogFragment.show(getFragmentManager(), "dialog");
        }
    };
    //endregion

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button enterButton = (Button)findViewById(R.id.enterBtn);
        enterButton.setOnClickListener(listener);
        registerForContextMenu(enterButton);

        //Reset Button
        Button resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(resetButtonListener);
    }

    //region Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater;
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.settingsMenuItem:
                startActivity(new Intent(MainActivity.this, MainPreferenceActivity.class));
                break;
            default:
                Toast.makeText(this, item.getTitle() + " was clicked", 10).show();
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater;
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.contextSettingsMenuItem:
                startActivity(new Intent(MainActivity.this, MainPreferenceActivity.class));
                break;
            default:
        }
        return super.onContextItemSelected(item);    //To change body of overridden methods use File | Settings | File Templates.
    }
    //endregion

    //region Reset Dialog Events

    /**
     * Handles the positive flow for ResetDialog
     */
    public void resetAction() {
        Toast.makeText(MainActivity.this, "Counter Reset",5).show();
    }

    /**
     * Handles the negative flow for ResetDialog
     */
    public void doNotResetAction() {
        Toast.makeText(MainActivity.this, "Didn't Reset",5).show();
    }
    //endregion
}