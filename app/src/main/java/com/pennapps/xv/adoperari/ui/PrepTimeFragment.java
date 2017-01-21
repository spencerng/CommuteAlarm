package com.pennapps.xv.adoperari.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pennapps.xv.adoperari.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrepTimeFragment extends Fragment {


    public PrepTimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prep_time, container, false);
    }

}
