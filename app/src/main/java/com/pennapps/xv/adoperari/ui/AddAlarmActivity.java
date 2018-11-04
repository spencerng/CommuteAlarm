package com.pennapps.xv.adoperari.ui;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.vision.text.Text;
import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.FileManager;
import com.pennapps.xv.adoperari.data.Settings;
import com.pennapps.xv.adoperari.models.Alarm;
import com.pennapps.xv.adoperari.models.Time;
import com.pennapps.xv.adoperari.models.WorkLocation;
import com.pennapps.xv.adoperari.ui.views.PickTime;
import com.pennapps.xv.adoperari.ui.views.DaysOfWeekPicker;

public class AddAlarmActivity extends AppCompatActivity {
    TextView showTime, showPlace;
    Button pickArrivalTime, pickPlace, finish;
    NumberPicker prepareTime;
    Place place;
    DaysOfWeekPicker dayOfWeekPicker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        showTime = (TextView) findViewById(R.id.showTime);
        showPlace = (TextView) findViewById(R.id.locationDisplay);
        pickArrivalTime = (Button) findViewById(R.id.pickArriveTime);
        prepareTime = (NumberPicker) findViewById(R.id.pickPrepTime);
        pickPlace = (Button) findViewById(R.id.pickPlace);
        finish = (Button) findViewById(R.id.finish);
        dayOfWeekPicker = (DaysOfWeekPicker) findViewById(R.id.dayPicker);
        Settings.getInstance(getBaseContext()).setTempHour(-1);
        Settings.getInstance(getBaseContext()).setTempMinute(-1);

        prepareTime.setMinValue(1);
        prepareTime.setMaxValue(120);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileManager.addSaveAlarm(new Alarm(new Time(Settings.getInstance(getBaseContext()).getTempHour(),
                        Settings.getInstance(getBaseContext()).getTempMinute(),0, dayOfWeekPicker.getIsDayPicked() ), new WorkLocation(place), prepareTime.getValue()), getBaseContext());

                finish();
            }
        });

        pickArrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTimePicker();
                Thread t = new Thread() {

                    @Override
                    public void run() {
                        try {
                            while (!isInterrupted()) {
                                Thread.sleep(1000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(!(Settings.getInstance(getBaseContext()).getTempHour() == -1 || Settings.getInstance(getBaseContext()).getTempMinute() == -1 ))
                                            interrupt();

                                    }
                                });
                            }
                        } catch (InterruptedException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showTime.setVisibility(View.VISIBLE);
                                    pickArrivalTime.setVisibility(View.INVISIBLE);

                                    int hour = Settings.getInstance(getBaseContext()).getTempHour();
                                    boolean am = true;

                                    if(hour>=12){
                                        am = false;
                                        if(hour!=12)
                                            hour-=12;

                                    }

                                    String minute;

                                    if(Settings.getInstance(getBaseContext()).getTempMinute()<10)
                                        minute = "0" + Settings.getInstance(getBaseContext()).getTempMinute();
                                    else minute = Integer.toString(Settings.getInstance(getBaseContext()).getTempMinute());

                                    showTime.setText(hour+":"+minute+" "+(am ? "AM" : "PM"));

                                }
                            });


                        }
                    }
                };
                t.start();
            }
        });

    }
    public void newTimePicker(){
        DialogFragment newFragment = new PickTime();
        newFragment.show(getFragmentManager(),"TimePicker");
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     //   if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                showPlace.setText(place.getName());
                showPlace.setVisibility(View.VISIBLE);
                pickPlace.setVisibility(View.GONE);
                this.place = place;
                finish.setEnabled(true);
            }
     //   }
    }



}


