package com.pennapps.xv.adoperari.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pennapps.xv.adoperari.R;

/**
 * Created by sng on 1/21/2017.
 */

public class DaysOfWeekPicker extends RelativeLayout {

    private Button sun, mon, tues, wed, thurs, fri, sat;
    private boolean[] isDayPicked = new boolean[7];

    public DaysOfWeekPicker(Context c, AttributeSet attrs){
        super(c, attrs);
        initializeViews(c);



    }

    private void initializeViews(Context c){
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.day_of_week_picker, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        for(int i = 0; i < 7; i++)
            isDayPicked[i] = false;

        sun = (Button) findViewById(R.id.sunButton);
        mon = (Button) findViewById(R.id.monButton);
        tues = (Button) findViewById(R.id.tuesButton);
        wed = (Button) findViewById(R.id.wedButton);
        thurs = (Button) findViewById(R.id.thursButton);
        fri = (Button) findViewById(R.id.friButton);
        sat = (Button) findViewById(R.id.satButton);

        sun.setBackgroundColor(Color.TRANSPARENT);
        mon.setBackgroundColor(Color.TRANSPARENT);
        tues.setBackgroundColor(Color.TRANSPARENT);
        wed.setBackgroundColor(Color.TRANSPARENT);
        thurs.setBackgroundColor(Color.TRANSPARENT);
        fri.setBackgroundColor(Color.TRANSPARENT);
        sat.setBackgroundColor(Color.TRANSPARENT);

        sun.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[0])
                   sun.setBackgroundColor(Color.TRANSPARENT);
                else sun.setBackgroundResource(R.drawable.round_button);
                isDayPicked[0]=!isDayPicked[0];
            }
        });
        mon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[1])
                    mon.setBackgroundColor(Color.TRANSPARENT);
                else mon.setBackgroundResource(R.drawable.round_button);
                isDayPicked[1]=!isDayPicked[1];

            }
        });
        tues.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[2])
                    tues.setBackgroundColor(Color.TRANSPARENT);
                else tues.setBackgroundResource(R.drawable.round_button);
                isDayPicked[2]=!isDayPicked[2];
            }
        });
        wed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[3])
                    wed.setBackgroundColor(Color.TRANSPARENT);
                else wed.setBackgroundResource(R.drawable.round_button);
                isDayPicked[3]=!isDayPicked[3];
            }
        });
        thurs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[4])
                    thurs.setBackgroundColor(Color.TRANSPARENT);
                else thurs.setBackgroundResource(R.drawable.round_button);
                isDayPicked[4]=!isDayPicked[4];
            }
        });
        fri.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[5])
                    fri.setBackgroundColor(Color.TRANSPARENT);
                else fri.setBackgroundResource(R.drawable.round_button);
                isDayPicked[5]=!isDayPicked[5];
            }
        });
        sat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDayPicked[6])
                    sat.setBackgroundColor(Color.TRANSPARENT);
                else sat.setBackgroundResource(R.drawable.round_button);
                isDayPicked[6]=!isDayPicked[6];
            }
        });
    }

    public boolean[] getIsDayPicked() { return isDayPicked; }

}
