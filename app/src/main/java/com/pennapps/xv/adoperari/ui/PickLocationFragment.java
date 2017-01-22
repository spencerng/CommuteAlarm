package com.pennapps.xv.adoperari.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.models.Alarm;


public class PickLocationFragment extends Fragment {
    Alarm firstAlarm;
    Button pickLocationButton;

    public PickLocationFragment() {
        // Required empty public constructor
    }

    public static PickLocationFragment newInstance(Alarm a) {
        PickLocationFragment fragment = new PickLocationFragment();
        fragment.setAlarm(a);
        return fragment;
    }

    void setAlarm(Alarm alarm){
        firstAlarm = alarm;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pickLocationButton = (Button) getActivity().findViewById(R.id.pickLocationButton);

        pickLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch activity here
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_started, container, false);
    }
}
