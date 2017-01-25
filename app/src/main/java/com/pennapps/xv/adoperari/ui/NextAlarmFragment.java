package com.pennapps.xv.adoperari.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.FileManager;
import com.pennapps.xv.adoperari.models.Alarm;

import java.util.ArrayList;


public class NextAlarmFragment extends Fragment {
    public NextAlarmFragment() {
        // Required empty public constructor
    }

    ArrayList<Alarm> alarmList;

    public static NextAlarmFragment newInstance() {
        return new NextAlarmFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentala
        try{
            alarmList = FileManager.loadAlarmList(getContext());
        }catch (Exception e){
            return inflater.inflate(R.layout.sad, container, false);
        }
        return inflater.inflate(R.layout.fragment_next_alarm, container, false);
    }


}
