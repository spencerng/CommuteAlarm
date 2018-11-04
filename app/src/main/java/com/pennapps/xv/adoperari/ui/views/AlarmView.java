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


    }



    private void initializeViews(Context c){
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.alarm_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }
}
