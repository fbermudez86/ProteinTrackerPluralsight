package com.ProteinTracker;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //region mProgress properties
    private static final int PROGRESS = 0x1;
    private ProgressDialog mProgress;
    private int mProgressStatus = 0;
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            mProgress.dismiss();
        }
    };
    //endregion

    //region Listener properties
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, MainPreferenceActivity.class));
        }
    };

    private View.OnClickListener resetButtonListener =  new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            //Custom Dialog
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle("Custom Dialog");
            TextView textView =  (TextView)dialog.findViewById(R.id.cdText);
            textView.setText("Hello");
            dialog.show();
            /*
            DialogFragment confirmResetDialogFragment = ConfirmResetDialogFragment.newInstance(R.string.resetDialogMessage);
            confirmResetDialogFragment.show(getFragmentManager(), "dialog");*/

            /*mProgress = new ProgressDialog(v.getContext());
            mProgress.setCancelable(true);
            mProgress.setMessage("Doing Something...");
            mProgress.setTitle("Waiting");
            mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgress.setProgress(0);
            mProgress.setMax(10);
            mProgress.show();

            //reset progress bar status

            //ProgressBar initialization
            // mProgress = (ProgressBar) findViewById(R.id.progressBar);
            // Start lengthy operation in a background thread
            new Thread(new Runnable() {
                public void run() {
                    try
                    {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    // Update the progress bar
                    handler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                    handler.sendEmptyMessage(0);
                }
            }).start();
        }*/
    }};
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