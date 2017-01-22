package com.pennapps.xv.adoperari.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.FileManager;
import com.pennapps.xv.adoperari.models.Alarm;
import com.pennapps.xv.adoperari.ui.views.AlarmView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        alarmContainer = (RelativeLayout) getActivity().findViewById(R.id.alarmContainer);
        try {
            alarms = FileManager.loadAlarmList(getContext());

            int lastId = 0;
            boolean firstTime = true;

            for (Alarm alarm : alarms) {
                AlarmView av = new AlarmView(getContext(), null);
                av.setAlarm(alarm);
                av.populateView();

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                if (!firstTime)
                    params.addRule(RelativeLayout.BELOW, lastId);

                lastId = View.generateViewId();
                av.setId(lastId);
                alarmContainer.addView(av, params);
                firstTime = false;


            }
        }
        catch(Exception e){
            e.printStackTrace();
            return inflater.inflate(R.layout.sad, container, false);
        }
        return inflater.inflate(R.layout.fragment_list_alarm, container, false);

    }

}
