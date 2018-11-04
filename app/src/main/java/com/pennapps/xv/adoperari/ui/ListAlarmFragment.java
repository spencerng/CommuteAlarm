package com.pennapps.xv.adoperari.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.FileManager;
import com.pennapps.xv.adoperari.models.Alarm;
import com.pennapps.xv.adoperari.models.Time;
import com.pennapps.xv.adoperari.models.WorkLocation;
import com.pennapps.xv.adoperari.ui.views.AlarmView;
import com.rey.material.widget.Switch;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class ListAlarmFragment extends Fragment {

    ArrayList<Alarm> alarms;
    RelativeLayout alarmContainer;

    public ListAlarmFragment() {
        // Required empty public constructor
    }

    public static ListAlarmFragment newInstance() {
        return new ListAlarmFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ScrollView rl = (ScrollView) inflater.inflate(R.layout.fragment_list_alarm, container, false);
        alarmContainer = (RelativeLayout) rl.findViewById(R.id.alarmContainer);

        try {
            alarms = FileManager.loadAlarmList(getContext());
            //alarms = new ArrayList<>();

            //alarms.add(new Alarm(new Time(6, 28, 0, {false, true, false, true, false, true, false), new WorkLocation()))

            int lastId = 0;
            boolean firstTime = true;

            Toast.makeText(getContext(), Integer.toString(alarms.size()),Toast.LENGTH_SHORT).show();

            for (Alarm alarm : alarms) {
                Log.e("alarm name", "hello" + alarm.getTime().getMinute());
                AlarmView av = new AlarmView(getContext(), null);
                int currentId = View.generateViewId();
                av.setId(currentId);
                av.setAlarm(alarm);
                TextView time = (TextView) av.findViewById(R.id.timeDisplay);
                TextView amPm = (TextView) av.findViewById(R.id.amPmDisplay);
                TextView dayOfWeek = (TextView) av.findViewById(R.id.dayWeekDisplay);
                TextView location = (TextView) av.findViewById(R.id.locationDisplay);
                Switch alarmEnabled =  (com.rey.material.widget.Switch) av.findViewById(R.id.alarmEnabled);
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

                location.setText(alarm.getWorkLocation().name);

                final String[] dayNames = {"Sun" , "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

                String dayString = "";
                for(int i = 0; i < 7; i++)
                    if(alarm.getTime().getIsDayOfWeek()[i])
                        dayString+=dayNames[i]+",";
                dayOfWeek.setText(dayString.substring(0, dayString.length()-1));

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                if (!firstTime)
                    params.addRule(RelativeLayout.BELOW, lastId);
                lastId = currentId;


                alarmContainer.addView(av, params);


                firstTime = false;


            }
        }
        catch(IOException e){
            e.printStackTrace();
            return inflater.inflate(R.layout.sad, container, false);
        }
        return rl;

    }



}
