package com.pennapps.xv.adoperari.ui.views;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import com.pennapps.xv.adoperari.data.Settings;


/**
 * Created by jeffrey on 1/22/17.
 */

public class PickTime extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

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
        Settings set = Settings.getInstance(getActivity());
        set.setTempHour(hourOfDay);
        set.setTempMinute(minute);
    }
}