package com.pennapps.xv.adoperari.ui;
/*
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import android.view.View;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class PickLocationFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_location);
    }

    public void newPlacePicker(View view) {
        try {
            int PLACE_PICKER_REQUEST = 1;
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
        } catch (GooglePlayServicesNotAvailableException e) {
            Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
        }
    }

    public void newTimePicker(View v){
        DialogFragment newFragment = new PickTime();
        newFragment.show(getFragmentManager(),"TimePicker");
    }
}

*/