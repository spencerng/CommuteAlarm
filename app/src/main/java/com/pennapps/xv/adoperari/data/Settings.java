package com.pennapps.xv.adoperari.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/** Access SharedPreferences data
 * Created by sng on 1/21/2017.
 */

public class Settings extends PreferenceFragment{

    SharedPreferences sp;

    public static Settings getInstance(Context c){
        Settings set = new Settings();
        set.sp = PreferenceManager.getDefaultSharedPreferences(c);
        return set;
    }

    public void setIsSetup(boolean isSetup){
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isSetup", isSetup);
        editor.apply();
    }

    public boolean isSetup(){
        return sp.getBoolean("isSetup", false);
    }

    //In minutes
    public void setPrepTime(int prepTime){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("prepTime", prepTime);
        editor.apply();
    }

    public int getPrepTime(){
        return sp.getInt("prepTime", 5);
    }

    public void setTempHour(int tempHour){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("tempHour", tempHour);
        editor.apply();
    }

    public void setTempMinute(int tempMinute){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("tempMinute", tempMinute);
        editor.apply();
    }
    public int getTempMinute(){ return sp.getInt("tempMinute", 0);}
    public int getTempHour(){ return sp.getInt("tempHour", 0);}

}
