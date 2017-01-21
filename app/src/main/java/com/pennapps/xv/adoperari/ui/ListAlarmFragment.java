package com.pennapps.xv.adoperari.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.models.Alarm;

public class ListAlarmFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_alarm, container, false);
    }

}
