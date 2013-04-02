package com.ProteinTracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: jose.bermudez
 * Date: 4/2/13
 * Time: 9:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmResetDialogFragment extends DialogFragment {

    public static ConfirmResetDialogFragment newInstance(int title)
    {
        ConfirmResetDialogFragment fragment = new ConfirmResetDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");
        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).resetAction();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).doNotResetAction();
                    }
                })
                .create();
    }
}