package com.pennapps.xv.adoperari.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.models.Alarm;

public class GetStartedActivity extends Activity {

    GetStartedFragment gsf;
    Alarm firstAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        gsf = new GetStartedFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, GetStartedFragment.newInstance(firstAlarm), "GET_STARTED")
                .commit();
    }
}
