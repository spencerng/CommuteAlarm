package com.pennapps.xv.adoperari.models;

/** Tracks data points for each day
 * Created by sng on 1/21/2017.
 */

public class DayTracker {

    double average = 0;
    int daysTracked = 0;

    DayTracker(){

    }

    public void addValue(int value){
        average = (average*daysTracked+value)/(daysTracked+1);
        daysTracked++;
    }

}
