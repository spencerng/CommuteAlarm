package com.pennapps.xv.adoperari.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by kevin on 1/21/17.
 */
public class PickTimeDateFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Use the current time as the default values for the time picker
        //final Calendar c = Calendar.getInstance();
        int hour = 8;
        int minute = 0;

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Do something with the user chosen time
        //Get reference of host activity (XML Layout File) TextView widget
        Context context = getActivity();
        Toast.makeText(context, "Hour: " + String.valueOf(hourOfDay) + "\nMinute : " + String.valueOf(minute), Toast.LENGTH_SHORT).show();
    }
}
