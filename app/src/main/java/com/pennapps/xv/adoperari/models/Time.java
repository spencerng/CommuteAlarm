package com.pennapps.xv.adoperari.models;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by sng on 1/21/2017.
 */

public class Time {

    int hour;
    int minute;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    int second;
    boolean[] isDayOfWeek = new boolean[7];

    public boolean[] getIsDayOfWeek() {
        return isDayOfWeek;
    }

    public void setIsDayOfWeek(boolean[] isDayOfWeek) {
        this.isDayOfWeek = isDayOfWeek;
    }

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

    public Time(int hour, int minute, int second, boolean[] isDayOfWeek) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.isDayOfWeek = isDayOfWeek;
    }

    public Time countdownTo(){
        Calendar cal = Calendar.getInstance();
        int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1; //Sunday = 1, Saturday = 7
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        int currentSecond = cal.get(Calendar.SECOND);

        int secondsLeft = 0;
        while(!isDayOfWeek[currentDayOfWeek]||currentHour!=hour||currentMinute!=minute||currentSecond!=second){
            secondsLeft++;
            currentSecond++;
            if(currentSecond==60){
                currentMinute++;
                currentSecond= 0;
            }
            if(currentMinute==60){
                currentHour++;
                currentMinute=0;
            }
            if(currentHour==24){
                currentDayOfWeek++;
                currentHour = 0;
            }
            if(currentDayOfWeek==7)
                currentDayOfWeek=0;

        }



        int minutesLeft = secondsLeft/60;
        secondsLeft%=60;
        int hoursLeft = minutesLeft/60;
        minutesLeft%=60;


        return new Time(hoursLeft, minutesLeft, secondsLeft, null);
    }

    /*//determine if a time object a "less than" (in a day) than present time object
    public boolean isLessThan(Time t){
        if(t.getHour()<hour)
            return true;
        if(t.getHour()>hour)
            return false;
        if(t.getMinute()<minute)
            return true;
        return false;
    }*/

    public String displayCountdown(){
        Time cd = countdownTo();
        String minutes = Integer.toString(cd.getHour());
        if(minutes.length()==1)
            minutes = "0"+minutes;
        String seconds = Integer.toString(cd.getSecond());
        if(seconds.length()==1)
            seconds = "0"+seconds;
        return cd.getHour()+":"+minutes+":"+seconds;
    }

    public void addMinutes(int minuteAdd){
        minute+=minuteAdd;
        if(minute>=60) {
            hour+=minute/60;
            minute%=60;
        }
        if(hour>=24)
            hour%=24;
    }

}
