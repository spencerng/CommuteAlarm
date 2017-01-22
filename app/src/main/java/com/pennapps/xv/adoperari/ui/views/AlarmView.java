package com.pennapps.xv.adoperari.ui.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.models.Alarm;

/**
 * Created by sng on 1/22/2017.
 */

public class AlarmView extends RelativeLayout{

    Alarm alarm;
    TextView time, amPm, dayOfWeek, location;
    com.rey.material.widget.Switch alarmEnabled;


    public AlarmView(Context c, AttributeSet attrs){
        super(c, attrs);
        initializeViews(c);

    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public void populateView(){
        alarmEnabled.setChecked(alarm.isEnabled());
        int hour = alarm.getTime().getHour();
        boolean am = true;

        if(hour>=12){
            am = false;
            if(hour!=12)
                hour-=12;

        }

        String minute;

        if(alarm.getTime().getMinute()<10)
            minute = "0" + alarm.getTime().getMinute();
        else minute = Integer.toString(alarm.getTime().getMinute());

        time.setText(hour+":"+minute);
        amPm.setText(am ? "AM" : "PM");

        location.setText(alarm.getWorkLocation().getName());

        final String[] dayNames = {"Sun" , "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        String dayString = "";
        for(int i = 0; i < 7; i++)
            if(alarm.getTime().getIsDayOfWeek()[i])
                dayString+=dayNames[i]+",";
        dayOfWeek.setText(dayString.substring(0, dayString.length()-1));

    }



    private void initializeViews(Context c){
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alarm_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        time = (TextView) findViewById(R.id.timeDisplay);
        amPm = (TextView) findViewById(R.id.amPmDisplay);
        dayOfWeek = (TextView) findViewById(R.id.dayWeekDisplay);
        location = (TextView) findViewById(R.id.locationDisplay);
        alarmEnabled =  (com.rey.material.widget.Switch) findViewById(R.id.alarmEnabled);
    }
}
