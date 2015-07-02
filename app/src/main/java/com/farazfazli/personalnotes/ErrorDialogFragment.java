package com.farazfazli.personalnotes;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by USER on 6/25/2015.
 */
public class ErrorDialogFragment extends DialogFragment {

    public ErrorDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int errorCode = getArguments().getInt(AppConstant.DIALOG_ERROR);
        return GooglePlayServicesUtil.getErrorDialog(errorCode, getActivity(), errorCode);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        getActivity().finish();
    }
}