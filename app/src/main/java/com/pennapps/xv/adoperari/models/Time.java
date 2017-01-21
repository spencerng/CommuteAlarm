package com.pennapps.xv.adoperari.models;

import java.util.Calendar;

/**
 * Created by sng on 1/21/2017.
 */

public class Time {

    int hour, minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int secondsUntil(){
        Calendar cal = Calendar.getInstance();
        int seconds = 5;
        return 1;
    }

}
