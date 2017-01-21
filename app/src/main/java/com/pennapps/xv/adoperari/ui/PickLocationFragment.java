package com.pennapps.xv.adoperari.ui;
/*
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

<<<<<<< HEAD
import android.view.View;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class PickLocationFragment extends AppCompatActivity {
=======
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickLocationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickLocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/*
public class PickLocationFragment extends Fragment {
    Alarm firstAlarm;
    Button nextButton;

    public PickLocationFragment() {
        // Required empty public constructor
    }

    public static PickLocationFragment newInstance(Alarm a) {
        PickLocationFragment fragment = new PickLocationFragment();
        fragment.setAlarm(a);
        return fragment;
    }
>>>>>>> 38b457f7bd058daad96e8734476a87c2d3848874

    void setAlarm(Alarm alarm){
        firstAlarm = alarm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_pick_location);
    }

    public void newPlacePicker(View view) {
        try {
            int PLACE_PICKER_REQUEST = 1;
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
        } catch (GooglePlayServicesNotAvailableException e) {
            Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_SHORT).show();
        }
    }

    public void newTimePicker(View v){
        DialogFragment newFragment = new PickTime();
        newFragment.show(getFragmentManager(),"TimePicker");
=======
        nextButton = (Button) getActivity().findViewById(R.id.getStartedButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getFragmentManager().beginTransaction().replace(android.R.id.content, PickLocationFragment.)
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_started, container, false);
>>>>>>> 38b457f7bd058daad96e8734476a87c2d3848874
    }
}

*/